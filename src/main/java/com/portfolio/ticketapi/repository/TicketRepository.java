package com.portfolio.ticketapi.repository;

import com.portfolio.ticketapi.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
}