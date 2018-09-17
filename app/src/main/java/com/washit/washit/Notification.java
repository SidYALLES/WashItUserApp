package com.washit.washit;

import java.util.Date;

public class Notification {
    private String title;
    private  String description;
    private NotificationTypes type;
    private Date time;
    private Status status;

    public Notification(String title, String description, NotificationTypes type, Date time, Status status) {
        this.title = title;
        this.description = description;
        this.type = type;
        this.time = time;
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public NotificationTypes getType() {
        return type;
    }

    public void setType(NotificationTypes type) {
        this.type = type;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
