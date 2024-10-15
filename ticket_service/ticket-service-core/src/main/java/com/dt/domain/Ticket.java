package com.dt.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Document(collection = "Ticket")
public class Ticket {
    @Id
    private String ticketno;
    private String psname;
    private Integer numberOfSeats;
    private String fsrc;
    private String fdesn;
}