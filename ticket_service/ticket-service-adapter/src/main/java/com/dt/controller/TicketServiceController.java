package com.dt.controller;

import com.dt.domain.FlightClass;
import com.dt.mapper.FlightTktMapper;
import lombok.AllArgsConstructor;
import com.dt.dto.response.FlightResponse;
import com.dt.api.ITicketServiceController;
import com.dt.domain.Ticket;
import com.dt.dto.request.TicketRequest;
import com.dt.dto.response.TicketResponse;
import com.dt.mapper.TicketMapper;
import com.dt.port.inboundport.ITicketServicePort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;


@RestController
@AllArgsConstructor
public class TicketServiceController implements ITicketServiceController {

    private TicketMapper ticketMapper;
    private ITicketServicePort ticketServicePort;
    private FlightTktMapper flightTktMapper;


    @Override
    public ResponseEntity<FlightResponse> checkFlightBySourceAndDestination(String src, String desn) {

//        // ticket service layer
//        Optional<FlightServiceResponse> flightBySrcAndDest = flightServiceClient.getFlightBySrcAndDest(src, desn);
//
//        // after going to Ticket service layer --> client
//        return ResponseEntity.ok(flightBySrcAndDest.get());

        final Optional<com.dt.domain.FlightClass> flightBySrcAndDest = ticketServicePort.checkFlightBySourceAndDestination(src, desn);
        if(flightBySrcAndDest.isPresent()) {
            FlightClass flight=flightBySrcAndDest.get();
            return ResponseEntity.ok(flightTktMapper.convertToFlightDTO(flight));
        }
        return ResponseEntity.notFound().build();

    }

    @Override
    public ResponseEntity<String> createTicket(TicketRequest ticketRequest) {
        final Ticket ticket = ticketMapper.convertToTicket(ticketRequest);
        boolean isCreated = ticketServicePort.createTicket(ticket);
        if(!isCreated) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ticket not created as flight does not exist");
        }
        return ResponseEntity.ok("Ticket created");
    }

    @Override
    public ResponseEntity<String> deleteTicketByNo(@PathVariable("id") String id) {
        boolean isDeleted = ticketServicePort.deleteTicketByNo(id);

        if (!isDeleted) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ticket not deleted");
        }

        return ResponseEntity.status(HttpStatus.OK).body("Ticket deleted");
    }

    @Override
    public ResponseEntity<TicketResponse> getTicketByNumber(String id) {
        final Optional<Ticket> ticketByNumber = ticketServicePort.getTicketByNumber(id);

        if (ticketByNumber.isEmpty()) {

            TicketResponse errorResponse = TicketResponse.builder().status("NOT_FOUND").message("Ticket not found for ticketNo: " + id).build();

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
        }

        return ResponseEntity.ok(ticketMapper.convertToTicketDTO(ticketByNumber.get()));
    }




}
