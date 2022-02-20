package com.test.lld.pubsub.model;


import com.google.common.base.Preconditions;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Getter
@AllArgsConstructor
public class Topic {

    private String name;
    private List<Message> messages;

    public static Topic of(String name){
        return new Topic(name);
    }

    public Topic(String name){
        Preconditions.checkArgument(StringUtils.isEmpty(name), String.format("Invalid topic name: [%s]", name));

        this.name = name;
        this.messages = new ArrayList<>();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Topic topic = (Topic) o;
        return Objects.equals(name, topic.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
