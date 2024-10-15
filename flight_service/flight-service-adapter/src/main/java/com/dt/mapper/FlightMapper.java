package com.dt.mapper;

import com.dt.domain.Flight;
import com.dt.dto.request.FlightServiceRequest;
import com.dt.dto.response.FlightResponse;
import com.dt.dto.response.FlightServiceResponse;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@NoArgsConstructor
@Component
public class FlightMapper {
    public FlightServiceResponse convertToFlightDTO(Flight flight) {
        return FlightServiceResponse.builder().id(flight.getId()).source(flight.getSource())
                .destination(flight.getDestination())
                .doj(flight.getDoj())
                .seats(flight.getSeats())
                .price(flight.getPrice())
                .status("200")
                .message("Success")
                .build();
    }

    public Flight convertToFlight(FlightServiceRequest flightServiceRequest) {
        return Flight.builder()
                .source(flightServiceRequest.getSource())
                .destination(flightServiceRequest.getDestination())
                .seats(flightServiceRequest.getSeats())
                .doj(flightServiceRequest.getDoj())
                .price(flightServiceRequest.getPrice())
                .build();
    }
    public Flight convertToFlight(FlightResponse flightServiceResponse) {
        return Flight.builder()
                .id(flightServiceResponse.getId())  // Optional, depends if ID is needed
                .source(flightServiceResponse.getSource())
                .destination(flightServiceResponse.getDestination())
                .seats(flightServiceResponse.getSeats())
                .doj(flightServiceResponse.getDoj())
                .price(flightServiceResponse.getPrice())
                .build();
    }

}