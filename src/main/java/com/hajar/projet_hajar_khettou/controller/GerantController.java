package com.hajar.projet_hajar_khettou.controller;

import com.hajar.projet_hajar_khettou.entity.Gerant;
import com.hajar.projet_hajar_khettou.service.GerantService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/gerants")
public class GerantController {

    private final GerantService gerantService;

    public GerantController(GerantService gerantService) {
        this.gerantService = gerantService;
    }

    @GetMapping
    public List<Gerant> getAll() {
        return gerantService.getAll();
    }

    @GetMapping("/{id}")
    public Gerant getById(@PathVariable Long id) {
        return gerantService.getById(id);
    }

    @PostMapping
    public Gerant create(@RequestBody Gerant gerant) {
        return gerantService.create(gerant);
    }

    @PutMapping("/{id}")
    public Gerant update(@PathVariable Long id, @RequestBody Gerant updated) {
        return gerantService.update(id, updated);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        gerantService.delete(id);
    }
}
