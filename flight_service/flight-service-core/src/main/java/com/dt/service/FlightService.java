package com.dt.service;

import com.dt.domain.Flight;
import lombok.AllArgsConstructor;
import com.dt.port.inbound.IFlightPort;
import org.springframework.stereotype.Service;
import com.dt.port.outbound.IFlightPersistencePort;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class FlightService implements IFlightPort {

   private IFlightPersistencePort iflightPersistencePort;

    @Override
    public Optional<com.dt.domain.Flight> getFlightBySrcAndDest(String source, String destination) {

        return iflightPersistencePort.getFlightBySrcAndDest(source, destination);
    }

    @Override
    public List<com.dt.domain.Flight> getAllFlights() {
        return iflightPersistencePort.getAllFlights();
    }

    @Override
    public Optional<com.dt.domain.Flight> createFlight(com.dt.domain.Flight flight) {
        return iflightPersistencePort.createFlight(flight);
    }

    @Override
    public void updateFlight(Flight flight) {
        iflightPersistencePort.updateFlight(flight);
    }
}