package com.dt.service;

import com.dt.domain.Ticket;
import com.dt.port.outboundport.IFlightServicePort;
import com.dt.port.outboundport.ITicketPersistencePort;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TicketServiceTest {

    @Mock
    private IFlightServicePort iFlightServicePort;
    @Mock
    private ITicketPersistencePort iTicketPersistencePort;

    @InjectMocks
    TicketService ticketService;

    @Test
    void TestTicketByTicketId() {
        final Ticket ticket = Ticket.builder().ticketno("120").psname("Rahul").numberOfSeats(23).fsrc("Delhi").fdesn("Bangalore").build();
        when(iTicketPersistencePort.getTicketByNumber(ticket.getTicketno())).thenReturn(Optional.of(ticket));
        final Optional<Ticket> ticketByNo = ticketService.getTicketByNumber(ticket.getTicketno());
        Assertions.assertEquals(ticket.getTicketno(), ticketByNo.get().getTicketno());
        Assertions.assertEquals(ticket.getFsrc(), ticketByNo.get().getFsrc());
        Assertions.assertEquals(ticket.getFdesn(), ticketByNo.get().getFdesn());

    }
    @Test
    void TestTicketByTicketIdNull() {

        when(iTicketPersistencePort.getTicketByNumber(anyString())).thenReturn(Optional.empty());
        final Optional<Ticket> ticketByNo = ticketService.getTicketByNumber("123");
        Assertions.assertTrue(ticketByNo.isEmpty());

    }


}
