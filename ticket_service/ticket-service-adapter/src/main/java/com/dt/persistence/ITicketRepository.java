package com.dt.persistence;

import com.dt.domain.Ticket;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITicketRepository extends MongoRepository<Ticket,String> {
}
