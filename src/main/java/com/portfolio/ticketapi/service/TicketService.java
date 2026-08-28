package com.portfolio.ticketapi.service;

import com.portfolio.ticketapi.dto.UpdateTicketRequest;
import com.portfolio.ticketapi.dto.CreateTicketRequest;
import com.portfolio.ticketapi.model.Ticket;
import com.portfolio.ticketapi.model.TicketPriority;
import com.portfolio.ticketapi.model.TicketStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TicketService {

    private final List<Ticket> tickets = new ArrayList<>();
    private Long nextId = 4L;

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

    public Optional<Ticket> getTicketById(Long id) {
        return tickets.stream()
                .filter(ticket -> ticket.getId().equals(id))
                .findFirst();
    }

    public Ticket createTicket(CreateTicketRequest request) {

        Ticket ticket = new Ticket(
                nextId++,
                request.getTitle(),
                request.getDescription(),
                TicketStatus.OPEN,
                request.getPriority(),
                LocalDateTime.now()
        );

        tickets.add(ticket);

        return ticket;
    }

    public Optional<Ticket> updateTicket(
            Long id,
            UpdateTicketRequest request) {

        return getTicketById(id).map(ticket -> {
            ticket.setStatus(request.getStatus());
            ticket.setPriority(request.getPriority());

            return ticket;
        });
    }

    public boolean deleteTicket(Long id) {
        return tickets.removeIf(
                ticket -> ticket.getId().equals(id)
        );
    }
}
