package com.dt.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Builder
public class FlightServiceResponse {
    private String id;
    private String source;
    private String destination;
    private String doj;
    private Integer seats;
    private Double price;
    private String status;
    private String message;
}
