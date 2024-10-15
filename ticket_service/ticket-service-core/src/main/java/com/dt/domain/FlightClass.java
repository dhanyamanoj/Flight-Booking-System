package com.dt.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString

public class FlightClass {
    @Id
    private String id;
    private String source;
    private String destination;
    private Double price;
    private Integer seats;
    private String doj;
}
