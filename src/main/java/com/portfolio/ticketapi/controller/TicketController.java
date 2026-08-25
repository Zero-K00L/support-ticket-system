package com.portfolio.ticketapi.controller;

import com.portfolio.ticketapi.model.Ticket;
import com.portfolio.ticketapi.model.TicketPriority;
import com.portfolio.ticketapi.model.TicketStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/tickets")
public class TicketController {

    @GetMapping("/sample")
    public Ticket getSampleTicket() {

        return new Ticket(
                1L,
                "Unable to login",
                "User receives an error when singing in.",
                TicketStatus.OPEN,
                TicketPriority.HIGH,
                LocalDateTime.now()
        );
    }
}
