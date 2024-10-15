package com.dt.port.inbound;

import com.dt.domain.Flight;

import java.util.List;
import java.util.Optional;

public interface IFlightPort {

    Optional<Flight> getFlightBySrcAndDest(String source, String destination);

    List<Flight> getAllFlights();

    Optional<Flight> createFlight(Flight flight);

    void updateFlight(Flight flight);
}