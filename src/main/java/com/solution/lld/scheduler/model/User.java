package com.solution.lld.scheduler.model;

import com.google.common.base.Preconditions;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;

@Getter
@Setter
public class User {

    private String id;
    private String name;
    private String email;

    public User(String name, String email){
        Preconditions.checkArgument(StringUtils.isBlank(name),String.format("invalid name: [%s]", name));
        Preconditions.checkArgument(StringUtils.isBlank(email),String.format("invalid email: [%s]", name));

        this.name = name;
        this.email = email;
    }
}
