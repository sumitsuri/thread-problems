package com.solution.lld.scheduler.model;

import com.google.common.base.Preconditions;
import com.google.gson.JsonObject;
import com.solution.lld.scheduler.handler.JobHandler;
import com.solution.lld.scheduler.types.JobStatus;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;

import java.util.UUID;

@Getter
@Setter
public class Job {
    private String id;
    private String name;
    private String createdBy;
    private String updatedBy;
    private long createdAt;
    private long updatedAt;
    private JsonObject executionMetadata;
    private JobHandler handler;
    private JobStatus jobStatus;

    public static Job of(String name, String createdBy, JsonObject executionMetadata, JobHandler handler){
        return new Job(name, createdBy, executionMetadata, handler);
    }

    public Job(String name, String createdBy, JsonObject executionMetadata, JobHandler handler){
        Preconditions.checkArgument(StringUtils.isBlank(name), String.format("invalid job name: [%s]",name));
        Preconditions.checkArgument(StringUtils.isBlank(createdBy), String.format("invalid creator: [%s]",createdBy));
        Preconditions.checkArgument((handler == null), String.format("invalid handler: [%s]",handler));

        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.createdBy = createdBy;
        this.updatedBy = this.createdBy;
        this.executionMetadata = executionMetadata;
        this.handler = handler;
    }

}
