package com.dt.port.inboundport;

import com.dt.domain.FlightClass;
import com.dt.domain.Ticket;

import java.util.Optional;

public interface ITicketServicePort {

    Optional<FlightClass> checkFlightBySourceAndDestination(String source, String desn);
    boolean createTicket(Ticket ticket);
    boolean deleteTicketByNo(String id);
    Optional<Ticket> getTicketByNumber(String id);
}
