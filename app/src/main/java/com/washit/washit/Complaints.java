package com.washit.washit;

public class Complaints {

    String ComplaintId;
    String ComplaintText;
    String user;

    public Complaints(){

    }

    public Complaints(String complaintId, String complaintText, String user) {
        ComplaintId = complaintId;
        ComplaintText = complaintText;
        this.user = user;
    }

    public String getComplaintText() {
        return ComplaintText;
    }

    public String getUser() {
        return user;
    }

    public String getComplaintId() {
        return ComplaintId;
    }
}
