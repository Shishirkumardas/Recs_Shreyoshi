package org.example.recs_shreyoshi.controller;

import lombok.RequiredArgsConstructor;
import org.example.recs_shreyoshi.models.Area;
import org.example.recs_shreyoshi.repositories.AreaRepository;
import org.example.recs_shreyoshi.services.AreaService;
import org.example.recs_shreyoshi.services.AreaSummaryDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.List;
@RestController
@RequestMapping("/api/areas")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3001")
public class AreaController {
    private final AreaRepository repo;
    private final AreaService areaService;

    @GetMapping
    public List<Area> getAll() {
        return areaService.getAllAreas();
    }

    @GetMapping("/area-summary/daily")
    public List<AreaSummaryDTO> getDailySummary(
            @RequestParam LocalDate date) {
        return areaService.getDailyAreaSummary(date);
    }

    @GetMapping("/area")
    public Area getArea(@RequestParam(required = false) Long id,
                        @RequestParam(required = false) String name) {
        if (id != null) {
            return areaService.getAreaById(id);
        } else if (name != null) {
            return areaService.getAreaByName(name);
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Either id or name must be provided");
        }
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')") // Only admin can create
    public Area createArea(@RequestBody Area area) {
        return areaService.createArea(area);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')") // Only admin can update
    public Area updateArea(@PathVariable Long id, @RequestBody Area area) {
        return areaService.updateArea(id, area);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')") // Only admin can delete
    public ResponseEntity<?> deleteArea(@PathVariable Long id) {
        areaService.deleteArea(id);
        return ResponseEntity.ok().body("Area deleted successfully");
    }

    @GetMapping("/summary/area")
    public Area areaSummary(long id) {
        return areaService.getAreaSummary(id);
    }
}
