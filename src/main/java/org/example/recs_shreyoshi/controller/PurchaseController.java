package org.example.recs_shreyoshi.controller;

import lombok.RequiredArgsConstructor;
import org.example.recs_shreyoshi.dto.PurchaseView;
import org.example.recs_shreyoshi.repositories.MasterDataRepository;
import org.example.recs_shreyoshi.repositories.PurchaseRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/purchases")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3001")
public class PurchaseController {

    private final PurchaseRepository repo;
    private final MasterDataRepository masterDataRepository;

//    @GetMapping
//    public List<Purchase> getAll() {
//        return repo.findAll();
//    }
//
//    @PostMapping
//    public Purchase create(@RequestBody Purchase purchase) {
//        return repo.save(purchase);
//    }

    @GetMapping("/purchases")
    public List<PurchaseView> purchases() {
        return masterDataRepository.getPurchases();
    }

}

