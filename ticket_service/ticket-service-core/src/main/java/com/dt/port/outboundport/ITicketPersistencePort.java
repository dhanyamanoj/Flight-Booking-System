package com.dt.port.outboundport;

import com.dt.domain.Ticket;

import java.util.Optional;

public interface ITicketPersistencePort {
    Optional<Ticket> createTicket(Ticket ticket);
    void deleteTicketByNo(String id);
    Optional<Ticket> getTicketByNumber(String id);
}
