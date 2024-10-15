package com.dt.controller;

import com.dt.api.IFlightServiceController;
import com.dt.domain.Flight;
import com.dt.dto.request.FlightServiceRequest;
import com.dt.dto.response.FlightServiceResponse;
import com.dt.mapper.FlightMapper;
import com.dt.port.inbound.IFlightPort;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
public class FlightServiceController implements IFlightServiceController {

    private FlightMapper flightMapper;
    private IFlightPort flightPort;

    @Override
    public ResponseEntity<FlightServiceResponse> getFlightBySrcAndDest(String source, String destination) {

        final Optional<Flight> flightBySrcAndDest = flightPort.getFlightBySrcAndDest(source, destination);
        if (flightBySrcAndDest.isEmpty()) {

            FlightServiceResponse errorResponse = FlightServiceResponse.builder().status("NOT_FOUND").message("No such flight found").build();

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
        }

        return ResponseEntity.ok(flightMapper.convertToFlightDTO(flightBySrcAndDest.get()));
    }

    @Override
    public ResponseEntity<List<FlightServiceResponse>> getAllFlights() {
        final List<Flight> flights = flightPort.getAllFlights();
        return ResponseEntity.ok(flights.stream().map(i -> flightMapper.convertToFlightDTO(i)).collect(Collectors.toList()));
    }

    @Override
    public ResponseEntity<FlightServiceResponse> createFlight(FlightServiceRequest flightServiceRequest) {

        Flight flight = flightMapper.convertToFlight(flightServiceRequest);

        Flight savedFlight = flightPort.createFlight(flight)
                .orElse(null);

        if (savedFlight != null) {

            return ResponseEntity.ok(flightMapper.convertToFlightDTO(savedFlight));
        } else {

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null);
        }
    }

    @Override
    public void updateFlight(Flight flight) {
        flightPort.updateFlight(flight);
    }

}
