package com.RunDMCPP.Backend.models;

import java.time.Instant;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAutoGeneratedKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

// Class representing an announcement, stored in the announcements table in DynamoDB
@DynamoDBTable(tableName = "announcement")
public class Announcement {

    private String id;          // Unique identifier for the announcement
    private String title;       // Title of the announcement
    private String description; // Description of the announcement
    private long ttl;           // Time to Live value to be configured in AWS

    // Getters and Setters
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
        long now = Instant.now().getEpochSecond(); // Get current time in sec
        ttl = 60 * 60 * 24 * 28; // Set TTL to 4 weeks in seconds
        setTtl(ttl + now);       // Set the expiration time to 4 weeks from now.
        return ttl;
    }
    public void setTtl(long t){
        ttl = t;
    }
    
}
