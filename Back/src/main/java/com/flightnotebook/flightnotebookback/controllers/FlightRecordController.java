package com.flightnotebook.flightnotebookback.controllers;

import com.flightnotebook.flightnotebookback.entities.FlightRecord;
import com.flightnotebook.flightnotebookback.repositories.FlightRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/flight-record")
public class FlightRecordController {
    @Autowired
    private FlightRecordRepository flightRecordRepository;

    @GetMapping
    public List<FlightRecord> findAllFlightRecords() {
        // TODO implement
        return (List<FlightRecord>) flightRecordRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<FlightRecord> findRecordFlightById(@PathVariable(value = "uuid") String uuid) {
        Optional<FlightRecord> flightRecord = flightRecordRepository.findById(uuid);
        if(flightRecord.isPresent()) {
            return ResponseEntity.ok().body(flightRecord.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public FlightRecord saveFlightRecord(@Validated @RequestBody FlightRecord flightRecord) {
        return flightRecordRepository.save(flightRecord);
    }
}
