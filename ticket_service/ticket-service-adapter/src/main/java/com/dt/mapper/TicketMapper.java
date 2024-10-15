package com.dt.mapper;

import lombok.NoArgsConstructor;
import com.dt.domain.Ticket;
import com.dt.dto.request.TicketRequest;
import com.dt.dto.response.TicketResponse;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
public class TicketMapper {

    public Ticket convertToTicket(TicketRequest ticketRequest){
        return Ticket.builder().ticketno(ticketRequest.getTicketnumber())
                .fdesn(ticketRequest.getFdesn())
                .fsrc(ticketRequest.getFsrc())
                .numberOfSeats(ticketRequest.getNumberOfSeats())
                .psname(ticketRequest.getPsname())
                .build();
    }

    public TicketResponse convertToTicketDTO(Ticket ticket){
        return  TicketResponse.builder()
                .ticketno(ticket.getTicketno())
                .fsrc(ticket.getFsrc())
                .fdesn(ticket.getFdesn())
                .numberOfSeats(ticket.getNumberOfSeats())
                .psname(ticket.getPsname())
                .status("SUCCESS")
                .message("Ticket Success")
                .build();
    }
}
