package com.portfolio.ticketapi.dto;

import com.portfolio.ticketapi.model.TicketPriority;
import com.portfolio.ticketapi.model.TicketStatus;
import jakarta.validation.constraints.NotNull;

public class UpdateTicketRequest {

    @NotNull(message = "Status is required")
    private TicketStatus status;

    @NotNull(message = "Priority is required")
    private TicketPriority priority;

    public UpdateTicketRequest() {

    }

    public TicketStatus getStatus() {
        return status;
    }

    public void setStatus(TicketStatus status) {
        this.status = status;
    }

    public TicketPriority getPriority() {
        return priority;
    }

    public void setPriority(TicketPriority priority) {
        this.priority = priority;
    }
}
