package com.dt.persistence;

import com.dt.controller.FlightServiceController;
import com.dt.domain.Flight;
import com.dt.domain.FlightClass;
import com.dt.dto.response.FlightResponse;
import com.dt.dto.response.FlightServiceResponse;
import com.dt.mapper.FlightTktMapper;
import com.dt.port.outboundport.IFlightServicePort;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;


import java.util.Optional;

@Component
@AllArgsConstructor
public class FlightServiceClient implements IFlightServicePort {
    FlightTktMapper flightTktMapper;


    private FlightServiceController flightServiceController;

    @Override
    public Optional<FlightClass> getFlightBySrcAndDest(String scr, String desc) {
       ResponseEntity<FlightServiceResponse> respentity= flightServiceController.getFlightBySrcAndDest(scr, desc);
       if(respentity.getStatusCode().is2xxSuccessful()&& respentity.getBody()!=null){
           FlightServiceResponse flightResponse =respentity.getBody();
           FlightResponse response= flightTktMapper.convertToFlightResponse(flightResponse);
           FlightClass flight = flightTktMapper.convertToFlight(response);
           return Optional.of(flight);
       }
       return Optional.empty();

    }

    @Override
    public void updateFlight(FlightClass flightClass) {
        Flight flight = flightTktMapper.convertToFlight(flightClass);
        flightServiceController.updateFlight(flight);
    }

}
