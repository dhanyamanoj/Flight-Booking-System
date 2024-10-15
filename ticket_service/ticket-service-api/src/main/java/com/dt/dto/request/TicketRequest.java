package com.dt.dto.request;


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
public class TicketRequest {
    private String ticketnumber;
    private String psname;
    private Integer numberOfSeats;
    private String fsrc;
    private String fdesn;

}
