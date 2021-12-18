package com.flightnotebook.flightnotebookback.repositories;

import com.flightnotebook.flightnotebookback.entities.FlightRecord;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightRecordRepository extends CrudRepository<FlightRecord, String> {
}
