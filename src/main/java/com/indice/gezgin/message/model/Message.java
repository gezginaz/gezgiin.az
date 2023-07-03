package com.indice.gezgin.message.model;


import com.indice.gezgin.icpmodel.BaseModel;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Builder;
import lombok.ToString;

import java.util.Date;

@Entity
@Builder
@ToString
public class Message extends BaseModel {

    @Column(nullable = false, updatable = false)
    private String type;

    @Column(nullable = false, updatable = false)
    private String fullNameOfSender;

    @Column(nullable = false, updatable = false)
    private String contactOfSender;

    @Column(nullable = false, updatable = false)
    private String message;

    private Boolean isActive;



    // Constructor
    public Message() {}

    public Message(Long id, Date createdAt, Date updatedAt, String type, String fullNameOfSender, String contactOfSender, String message, Boolean isActive) {
        super(id, createdAt, updatedAt);
        this.type = type;
        this.fullNameOfSender = fullNameOfSender;
        this.contactOfSender = contactOfSender;
        this.message = message;
        this.isActive = isActive;
    }

    public Message(String type, String fullNameOfSender, String contactOfSender, String message, Boolean isActive) {
        this.type = type;
        this.fullNameOfSender = fullNameOfSender;
        this.contactOfSender = contactOfSender;
        this.message = message;
        this.isActive = isActive;
    }



    // Getters and Setters
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFullNameOfSender() {
        return fullNameOfSender;
    }

    public void setFullNameOfSender(String fullNameOfSender) {
        this.fullNameOfSender = fullNameOfSender;
    }

    public String getContactOfSender() {
        return contactOfSender;
    }

    public void setContactOfSender(String contactOfSender) {
        this.contactOfSender = contactOfSender;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }
}
