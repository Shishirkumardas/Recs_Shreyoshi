package org.example.recs_shreyoshi.controller;

import lombok.RequiredArgsConstructor;
import org.example.recs_shreyoshi.models.Area;
import org.example.recs_shreyoshi.models.Consumer;
import org.example.recs_shreyoshi.repositories.ConsumerRepository;
import org.example.recs_shreyoshi.repositories.MasterDataRepository;
import org.example.recs_shreyoshi.services.AreaService;
import org.example.recs_shreyoshi.services.ConsumerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/consumers")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3001")
public class ConsumerController {

    private final ConsumerRepository repo;
    private final ConsumerService consumerService;
    private final AreaService areaService;
    private final MasterDataRepository masterDataRepository;

    @GetMapping
    public List<Consumer> getAll() {
        return repo.findAll();
    }

//    @GetMapping("/consumer")
//    public Consumer getConsumer(@RequestParam(required = false) Long id,
//                        @RequestParam(required = false) String name) {
//        if (id != null) {
//            return consumerService.getConsumerById(id);
//        } else if (name != null) {
//            return consumerService.getConsumerByName(name);
//        } else {
//            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Either id or name must be provided");
//        }
//    }



    @PutMapping("/{id}")
    public Consumer updateConsumer(@PathVariable Long id, @RequestBody Consumer consumer) {
        return consumerService.updateConsumer(id, consumer);
    }

    @PostMapping
    public Consumer create(@RequestBody Consumer consumer) {
        return repo.save(consumer);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        repo.deleteById(id);
    }

    @GetMapping("/summary/area")
    public ResponseEntity<Area> getAreaSummary(long id) {
        Area summary = areaService.getAreaSummary(id);
        return ResponseEntity.ok((Area) summary);
    }

}

