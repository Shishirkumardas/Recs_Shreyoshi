package org.example.recs_shreyoshi.controller;

import lombok.RequiredArgsConstructor;
import org.example.recs_shreyoshi.dto.OverallSummary;
import org.example.recs_shreyoshi.repositories.MasterDataRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/summary")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3001")
public class OverallSummaryController {
    private final MasterDataRepository masterDataRepository;


    @GetMapping
    public OverallSummary summary() {
        return masterDataRepository.getSummary();
    }

}
