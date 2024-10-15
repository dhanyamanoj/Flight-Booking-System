package com.dt.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class TicketResponse {
    private String ticketno;
    private String psname;
    private Integer numberOfSeats;
    private String fsrc;
    private String fdesn;
    private String status;
    private String message;
}
