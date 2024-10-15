package com.dt.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class NoEntityFoundException extends RuntimeException {
    public NoEntityFoundException(String msg) {super(msg); }
}
