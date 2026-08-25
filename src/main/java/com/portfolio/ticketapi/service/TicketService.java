package com.portfolio.ticketapi.service;

import com.portfolio.ticketapi.model.Ticket;
import com.portfolio.ticketapi.model.TicketPriority;
import com.portfolio.ticketapi.model.TicketStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class TicketService {

    private final List<Ticket> tickets = new ArrayList<>();

    public TicketService() {

        tickets.add(new Ticket (
                1L,
                "Unable to log in",
                "User receives an error when signing in.",
                TicketStatus.OPEN,
                TicketPriority.HIGH,
                LocalDateTime.now()
        ));

        tickets.add(new Ticket(
                2L,
                "Printer not working",
                "Office printer is not responding",
                TicketStatus.IN_PROGRESS,
                TicketPriority.MEDIUM,
                LocalDateTime.now()
        ));

        tickets.add(new Ticket(
                3L,
                "Password reset",
                "User needs help resetting their password.",
                TicketStatus.RESOLVED,
                TicketPriority.LOW,
                LocalDateTime.now()
        ));
    }

    public List<Ticket> getAllTickets() {
        return tickets;
    }
}
