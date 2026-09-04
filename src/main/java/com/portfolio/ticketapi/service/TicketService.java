package com.portfolio.ticketapi.service;

import com.portfolio.ticketapi.dto.CreateTicketRequest;
import com.portfolio.ticketapi.dto.UpdateTicketRequest;
import com.portfolio.ticketapi.model.Ticket;
import com.portfolio.ticketapi.model.TicketStatus;
import com.portfolio.ticketapi.repository.TicketRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class TicketService {

    private final TicketRepository ticketRepository;

    public TicketService(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    public List<Ticket> getAllTickets() {
        return ticketRepository.findAll();
    }

    public Optional<Ticket> getTicketById(Long id) {
        return ticketRepository.findById(id);
    }

    public Ticket createTicket(CreateTicketRequest request) {

        Ticket ticket = new Ticket(
                null,
                request.getTitle(),
                request.getDescription(),
                TicketStatus.OPEN,
                request.getPriority(),
                LocalDateTime.now()
        );

        return ticketRepository.save(ticket);
    }

    public Optional<Ticket> updateTicket(
            Long id,
            UpdateTicketRequest request) {

        return ticketRepository.findById(id)
                .map(ticket -> {

                    ticket.setStatus(request.getStatus());
                    ticket.setPriority(request.getPriority());

                    return ticketRepository.save(ticket);
                });
    }

    public boolean deleteTicket(Long id) {

        if (!ticketRepository.existsById(id)) {
            return false;
        }

        ticketRepository.deleteById(id);
        return true;
    }
}
