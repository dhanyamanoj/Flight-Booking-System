package com.dt.api;

import com.dt.constants.FlightServiceConstant;
import com.dt.domain.Flight;
import com.dt.dto.request.FlightServiceRequest;
import com.dt.dto.response.FlightServiceResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
@FeignClient(name = "flight-service", contextId = "flightServiceController" , url="http://localhost:8080/flight")
public interface IFlightServiceController {

    @GetMapping(FlightServiceConstant.GETFLIGHTBYSANDD)
    @ResponseBody
    ResponseEntity<FlightServiceResponse> getFlightBySrcAndDest(@PathVariable(value="source") String source, @PathVariable(value = "destination") String destination);

    @GetMapping(FlightServiceConstant.GETLISTOFFLIGHTS)
    @ResponseBody
    ResponseEntity<List<FlightServiceResponse>> getAllFlights();

    @PostMapping(FlightServiceConstant.CREATEFLIGHT)
    @ResponseBody
    ResponseEntity<FlightServiceResponse> createFlight(@RequestBody FlightServiceRequest flightServiceRequest);

    @PostMapping(FlightServiceConstant.UPDATEFLIGHT)
    @ResponseBody
    void updateFlight(Flight flight);
}
