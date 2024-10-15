package com.dt.port.outbound;

import com.dt.domain.Flight;


import java.util.List;
import java.util.Optional;


public interface IFlightPersistencePort {


    List<Flight> getAllFlights();
    Optional<Flight> getFlightBySrcAndDest(String source, String destination);

    Optional<Flight> createFlight(Flight flight);


    void updateFlight(Flight flight);
}
