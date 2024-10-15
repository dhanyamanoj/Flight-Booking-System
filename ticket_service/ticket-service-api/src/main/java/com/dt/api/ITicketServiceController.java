package com.dt.api;

import com.dt.dto.response.FlightResponse;
import com.dt.constant.TicketServiceConstant;
import com.dt.dto.request.TicketRequest;
import com.dt.dto.response.TicketResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

public interface ITicketServiceController {

    @PostMapping(TicketServiceConstant.CREATE_TICKET)
    @ResponseBody
    ResponseEntity<String> createTicket(@RequestBody TicketRequest ticket);

    @DeleteMapping(TicketServiceConstant.DELETE_TICKET_BY_ID)
    @ResponseBody
    ResponseEntity<String> deleteTicketByNo(@PathVariable String id);


    @GetMapping(TicketServiceConstant.GET_TICKET_ID)
    @ResponseBody
    ResponseEntity<TicketResponse> getTicketByNumber(@PathVariable(value = "id") String id);

    @GetMapping(TicketServiceConstant.GET_FLIGHT_BY_SOURCE_AND_DESTINATION)
    @ResponseBody
    ResponseEntity<FlightResponse> checkFlightBySourceAndDestination(@PathVariable(value = "source") String source, @PathVariable(value = "destination") String destination);

}
