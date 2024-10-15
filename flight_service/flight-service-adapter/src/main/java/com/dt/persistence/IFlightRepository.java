package com.dt.persistence;

import com.dt.domain.Flight;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IFlightRepository extends MongoRepository<Flight,String> {

    @Query("{'source': ?0, 'destination': ?1}")
    Flight getBySrcAndDesnName(String source,String destination);

}
