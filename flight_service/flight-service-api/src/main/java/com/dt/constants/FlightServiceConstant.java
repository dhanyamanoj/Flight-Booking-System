package com.dt.constants;

public class FlightServiceConstant {

    private static final String FLIGHT = "flight";
    private static final String SOURCE = "/source/{source}";

    public static final String DESTINATION = "/destination/{destination}";

    public static final String GETALLFLIGHTS = "/getAllFlights";
    public static final String POSTFLIGHT="/createFlight";
    public static final String GETLISTOFFLIGHTS = FLIGHT+GETALLFLIGHTS;
    public static final String CREATEFLIGHT = FLIGHT+POSTFLIGHT;

    public static final String GETFLIGHTBYSANDD = FLIGHT+SOURCE+DESTINATION;
    public static final String UPDATEFLIGHT =FLIGHT+ "/update";

}