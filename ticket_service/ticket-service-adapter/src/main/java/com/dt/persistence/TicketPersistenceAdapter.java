package com.dt.persistence;

import lombok.AllArgsConstructor;
import com.dt.domain.Ticket;
import com.dt.exception.TicketException;
import com.dt.port.outboundport.ITicketPersistencePort;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.Optional;

@Component
@AllArgsConstructor
public class TicketPersistenceAdapter implements ITicketPersistencePort {

    private ITicketRepository ticketRepository;
    @Override
    public Optional<Ticket> createTicket(Ticket ticket) {
        Ticket save = ticketRepository.save(ticket);
        if(Objects.isNull(save)){ throw new TicketException("can't save data");
        }
        return Optional.of(save);
    }

    @Override
    public void deleteTicketByNo(String id) {
        ticketRepository.deleteById(id);
    }

    @Override
    public Optional<Ticket> getTicketByNumber(String id) {
        Optional<Ticket> ticketById = ticketRepository.findById(id);
        return ticketById;

    }
}