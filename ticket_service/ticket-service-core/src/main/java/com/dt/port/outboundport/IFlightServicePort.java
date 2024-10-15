package com.dt.port.outboundport;

import com.dt.domain.FlightClass;

import java.util.Optional;


public interface IFlightServicePort {

    Optional<FlightClass> getFlightBySrcAndDest(String scr, String desc);

    void updateFlight(FlightClass flight);
}
