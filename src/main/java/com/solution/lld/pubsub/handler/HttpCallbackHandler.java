package com.solution.lld.pubsub.handler;

import com.solution.lld.pubsub.model.Message;
import com.solution.lld.pubsub.model.Subscription;
import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;
import lombok.SneakyThrows;
import org.springframework.util.CollectionUtils;

import java.util.List;

public class HttpCallbackHandler implements CallbackHandler{

    @SneakyThrows
    @Override
    public void handle(List<Message> messages, Subscription subscription) {


        if(CollectionUtils.isEmpty(messages)){
            return;
        }
        for(Message message : messages){
            System.out.println(String.format("[HttpCallbackHandler] publishing message on endpoint [%s] for subscription [%s] and topic [%s]", subscription.getEndpoint(), subscription.getName(), subscription.getTopic()));

            HttpResponse<JsonNode> response
                    = Unirest.post(subscription.getEndpoint())
                    .body(message.getPayload())
                    .header("accept","application/json")
                    .asJson();
            int currentRetryCount = 0;
            if(response.getStatus() != 200){
                System.out.println(String.format("[ERROR] got status [%d] from endpoint. retrying...",response.getStatus(), subscription.getEndpoint()));
                int currentBackOff = subscription.getRetryPolicy().getBackOffPolicy().getBackOffSeconds();
                boolean isSuccess = false;
                while(currentRetryCount <= subscription.getRetryPolicy().getMaxAttempt()){
                    currentBackOff = subscription.getRetryPolicy().getBackOffPolicy().getNextBackOffInterval(currentBackOff, currentRetryCount);
                    System.out.println(String.format("backing-off for [%d] seconds", currentBackOff));
                    Thread.sleep(currentBackOff * 1000L);
                    System.out.println(String.format("[Retry] [%d] ==> publishing message on endpoint [%s] for subscription [%s] and topic [%s]", subscription.getEndpoint(), subscription.getName(), subscription.getTopic()));
                    response
                            = Unirest.post(subscription.getEndpoint())
                            .body(message.getPayload())
                            .header("accept","application/json")
                            .asJson();
                    if(response.getStatus() != 200){
                        currentRetryCount++;
                    }else{
                        isSuccess = true;
                        System.out.println(String.format("[SUCCESS] published message on endpoint [%s] for subscription [%s] and topic [%s]",subscription.getEndpoint(), subscription.getName(), subscription.getTopic()));
                        break;
                    }

                }
                if(!isSuccess){
                    System.out.println(String.format("[ERROR] publishing message on endpoint [%s] for subscription [%s] and topic [%s]",subscription.getEndpoint(), subscription.getName(), subscription.getTopic()));
                }
                if(subscription.getDeadLetterPolicy() != null){
                    System.out.println(String.format("[DEAD-LETTER] publishing message to dead-letter topic [%s] for subscription [%s] and topic [%s]", subscription.getDeadLetterPolicy().getTopicName(),subscription.getName(),subscription.getTopic()));
                }
            }
        }
    }
}
