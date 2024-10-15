package com.dt.exception;


import lombok.NoArgsConstructor;

@NoArgsConstructor
public class FlightException extends Exception {
    public FlightException(String msg) {
        super(msg);
    }

}
