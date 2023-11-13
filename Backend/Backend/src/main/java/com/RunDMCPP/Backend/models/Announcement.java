package com.RunDMCPP.Backend.models;

import java.time.Instant;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAutoGeneratedKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

@DynamoDBTable(tableName = "announcement")
public class Announcement {

    private String id;
    private String title;
    private String description;
    private long ttl; // Time to Live value to be configured in aws

    @DynamoDBHashKey(attributeName = "id")
    @DynamoDBAutoGeneratedKey
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @DynamoDBAttribute(attributeName = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @DynamoDBAttribute(attributeName = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @DynamoDBAttribute
    public long getTtl(){ 
        long now = Instant.now().getEpochSecond();
        ttl = 60 * 60 * 24 * 28; // 4 weeks in sec
        setTtl(ttl + now); //expiration time
        return ttl;
    }

    public void setTtl(long t){
        ttl = t;
    }
    
}