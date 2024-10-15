package com.dt.service;


import com.dt.domain.Flight;
import com.dt.port.outbound.IFlightPersistencePort;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class FlightServiceTest {

    @Mock
    private IFlightPersistencePort iFlightPersistencePort;

    @InjectMocks
    private FlightService flightService;

    @Test
    public void testGetFlightBySrcAndDest() {
        final Optional<com.dt.domain.Flight> flight= Optional.of(Flight.builder()
                .source("Allahabad")
                .destination("Kerala")
                .seats(4)
                .doj("13/11/2024")
                .price(12000.00)
                .build());

        when(iFlightPersistencePort.getFlightBySrcAndDest("Allahabad", "Kerala")).thenReturn(flight);

        final Optional<Flight> flightDetails= iFlightPersistencePort.getFlightBySrcAndDest("Allahabad", "Kerala");


        assertEquals(flight.get(), flightDetails.get());

    }
    @Test
    public void testGetFlightBySrcAndDestNull() {

        when(iFlightPersistencePort.getFlightBySrcAndDest(anyString(), anyString())).thenReturn(Optional.empty());

        final Optional<Flight> flightDetails= iFlightPersistencePort.getFlightBySrcAndDest("Mumbai", "Jaipur");
        Assertions.assertTrue(flightDetails.isEmpty());
    }

    @Test
    public void testListFlights() {
        final Flight flight = Flight.builder()
                .source("Pune")
                .destination("Chennai")
                .seats(2)
                .doj("26/04/2024")
                .price(1000.00)
                .build();

        final Flight flight1 = Flight.builder()
                .source("Jaipur")
                .destination("Delhi")
                .seats(2)
                .doj("1/1/2024")
                .price(11000.00)
                .build();
        when(iFlightPersistencePort.getAllFlights()).thenReturn(List.of(flight, flight1));

        final List<Flight> flightList = flightService.getAllFlights();
        assertEquals(2, flightList.size());
        assertEquals(flight, flightList.get(0));
        assertEquals(flight1, flightList.get(1));

    }
    @Test
    public void testListOfFlightsNull() {

        when(iFlightPersistencePort.getAllFlights()).thenReturn(Collections.emptyList());

        final List<Flight> flightDetails = iFlightPersistencePort.getAllFlights();

        Assertions.assertTrue(flightDetails.isEmpty());
    }


}
