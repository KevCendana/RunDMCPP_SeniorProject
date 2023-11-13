package com.RunDMCPP.Backend.models;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAutoGeneratedKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

import java.util.Objects;

@DynamoDBTable(tableName = "event")
public class Event {
    private String id;
    private String eventTitle;
    private String eventDescription;
    private String eventDateTime;
    private String eventLocation;
    @DynamoDBHashKey(attributeName = "id")
    @DynamoDBAutoGeneratedKey
    public String getId() {
        return id;
    }
    @DynamoDBAttribute(attributeName = "title")
    public String getEventTitle() {
        return eventTitle;
    }
    @DynamoDBAttribute(attributeName = "description")
    public String getEventDescription() {
        return eventDescription;
    }
    @DynamoDBAttribute(attributeName = "dateTime")
    public String getDateTime() {
        return eventDateTime;
    }

    @DynamoDBAttribute(attributeName = "location")
    public String getEventLocation() {
        return eventLocation;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setEventTitle(String eventTitle) {
        this.eventTitle = eventTitle;
    }

    public void setEventDescription(String eventDescription) {
        this.eventDescription = eventDescription;
    }

    public void setDateTime(String eventDateTime) {
        this.eventDateTime = eventDateTime;
    }

    public void setEventLocation(String eventLocation) {
        this.eventLocation = eventLocation;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o){
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Event event = (Event) o;
        return Objects.equals(this.id, event.id) && Objects.equals(this.eventTitle, event.eventTitle) && Objects.equals(this.eventDescription, event.eventDescription) && 
        Objects.equals(this.eventDateTime, event.eventDateTime) && Objects.equals(this.eventLocation, event.eventLocation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.eventTitle, this.eventDescription, this.eventDateTime, this.eventLocation);
    }
}