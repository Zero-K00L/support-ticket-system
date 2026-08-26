package com.portfolio.ticketapi.dto;

import com.portfolio.ticketapi.model.TicketPriority;

public class CreateTicketRequest {

    private String title;
    private String description;
    private TicketPriority priority;

    public CreateTicketRequest() {
    }

    // Getters
    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public TicketPriority getPriority() {
        return priority;
    }

    // Setters
    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPriority(TicketPriority priority) {
        this.priority = priority;
    }
}
