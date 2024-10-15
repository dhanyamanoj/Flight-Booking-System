package com.dt.service;

import com.dt.domain.FlightClass;
import lombok.AllArgsConstructor;

import com.dt.domain.Ticket;
import com.dt.port.inboundport.ITicketServicePort;
import com.dt.port.outboundport.IFlightServicePort;
import com.dt.port.outboundport.ITicketPersistencePort;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class TicketService implements ITicketServicePort {

    private IFlightServicePort flightServicePort;
    private ITicketPersistencePort IticketPersistencePort;

    @Override
    public Optional<FlightClass> checkFlightBySourceAndDestination(String source, String desn) {
        return flightServicePort.getFlightBySrcAndDest(source, desn);
    }

    @Override
    public boolean createTicket(Ticket ticket) {
        Optional<FlightClass> flightBySrcAndDest = flightServicePort.getFlightBySrcAndDest(ticket.getFsrc(), ticket.getFdesn());
        if(flightBySrcAndDest.isEmpty()){
            return false;
        }
        FlightClass flight = flightBySrcAndDest.get();

        if(flight.getSeats() >0){
            Optional<Ticket> ticket1 = IticketPersistencePort.createTicket(ticket);
//            String src=flight.getSource();
//            String desn=flight.getDestination();
//            FlightServiceResponse flightResponse=(flightServicePort.getFlightBySrcAndDest(src,desn)).get();
//            Flight flight= flightMapper.convertToFlight(flightResponse);

            flight.setSeats(flight.getSeats()-ticket.getNumberOfSeats());
            flightServicePort.updateFlight(flight);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteTicketByNo(String id) {
        Optional<Ticket> ticket= IticketPersistencePort.getTicketByNumber(id);
        if (ticket.isEmpty()) {
            return false;
        }

        IticketPersistencePort.deleteTicketByNo(id);
        return true;
    }

    @Override
    public Optional<Ticket> getTicketByNumber(String id) {
        Optional<Ticket> ticketByNumber = IticketPersistencePort.getTicketByNumber(id);
        return ticketByNumber;
    }
}
