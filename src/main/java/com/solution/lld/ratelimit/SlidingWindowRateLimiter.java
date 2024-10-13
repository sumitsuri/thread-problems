package com.solution.lld.ratelimit;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class SlidingWindowRateLimiter extends AbstractRateLimiter{
    private Map<String, Queue<Long>> requestTimestamps;

    public SlidingWindowRateLimiter(int maxRequests, long windowSizeInMilliseconds) {
        super(maxRequests, windowSizeInMilliseconds);
        this.requestTimestamps = new HashMap<>();
    }

    @Override
    public boolean isRequestAllowed(String clientId) {
        long currentTimeInMilliseconds = System.currentTimeMillis();
        requestTimestamps.putIfAbsent(clientId, new LinkedList<>());

        Queue<Long> timestamps = requestTimestamps.get(clientId);

        while(!timestamps.isEmpty() && currentTimeInMilliseconds - timestamps.peek() > windowSizeInMilliseconds){
            timestamps.poll();
        }
        if(timestamps.size() < maxRequests){
            timestamps.add(currentTimeInMilliseconds);
            return true;
        }
        return false;
    }
}
