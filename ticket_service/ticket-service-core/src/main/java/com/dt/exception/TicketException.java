package com.dt.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class TicketException extends NoEntityFoundException {
    public TicketException(String msg) {
        super(msg);
    }
}

