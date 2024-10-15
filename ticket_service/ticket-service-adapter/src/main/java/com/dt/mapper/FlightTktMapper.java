package com.dt.mapper;

import com.dt.domain.Flight;
import com.dt.domain.FlightClass;
import com.dt.dto.response.FlightResponse;
import com.dt.dto.response.FlightServiceResponse;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@NoArgsConstructor
@Component
public class FlightTktMapper {
    public FlightResponse convertToFlightDTO(FlightClass flight) {
        return FlightResponse.builder().id(flight.getId()).source(flight.getSource())
                .destination(flight.getDestination())
                .doj(flight.getDoj())
                .seats(flight.getSeats())
                .price(flight.getPrice())
                .status("200")
                .message("Success")
                .build();
    }

//    public Flight convertToFlight(FlightRequest flightServiceRequest) {
//        return Flight.builder()
//                .source(flightServiceRequest.getSource())
//                .destination(flightServiceRequest.getDestination())
//                .seats(flightServiceRequest.getSeats())
//                .doj(flightServiceRequest.getDoj())
//                .price(flightServiceRequest.getPrice())
//                .build();
//    }
    public FlightClass convertToFlight(FlightResponse flightServiceResponse) {
        return FlightClass.builder()
                .id(flightServiceResponse.getId())  // Optional, depends if ID is needed
                .source(flightServiceResponse.getSource())
                .destination(flightServiceResponse.getDestination())
                .seats(flightServiceResponse.getSeats())
                .doj(flightServiceResponse.getDoj())
                .price(flightServiceResponse.getPrice())
                .build();
    }

    public Flight convertToFlight(FlightClass flightClass) {
        return Flight.builder()
                .id(flightClass.getId())
                .source(flightClass.getSource())
                .destination(flightClass.getDestination())
                .seats(flightClass.getSeats())
                .doj(flightClass.getDoj())
                .price(flightClass.getPrice())
                .build();
    }
    public FlightResponse convertToFlightResponse(FlightServiceResponse flightResponse) {
        return FlightResponse.builder()
                .id(flightResponse.getId())
                .source(flightResponse.getSource())
                .destination(flightResponse.getDestination())
                .doj(flightResponse.getDoj())
                .seats(flightResponse.getSeats())
                .price(flightResponse.getPrice())
                .status("200")
                .message("Success")
                .build();
    }
}