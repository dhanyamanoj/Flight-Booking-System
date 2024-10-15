package com.dt.persistence;

import com.dt.domain.Flight;
import com.dt.port.outbound.IFlightPersistencePort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@AllArgsConstructor
public class FlightPersistenceAdapter implements IFlightPersistencePort {

    private IFlightRepository flightRepo;

    @Override
    public List<Flight> getAllFlights() {
        return flightRepo.findAll();
    }

    @Override
    public Optional<Flight> getFlightBySrcAndDest(String source, String destination) {
        return Optional.ofNullable(flightRepo.getBySrcAndDesnName(source, destination));
    }

    @Override
    public Optional<Flight> createFlight(Flight flight) {
        return Optional.of(flightRepo.save(flight));
    }

    @Override
    public void updateFlight(Flight flight) {
        flightRepo.save(flight);
    }


}