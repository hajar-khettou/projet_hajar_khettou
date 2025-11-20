package com.hajar.projet_hajar_khettou.controller;

import com.hajar.projet_hajar_khettou.entity.Conseiller;
import com.hajar.projet_hajar_khettou.service.ConseillerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/conseillers")
public class ConseillerController {

    private final ConseillerService conseillerService;

    public ConseillerController(ConseillerService conseillerService) {
        this.conseillerService = conseillerService;
    }

    @GetMapping
    public List<Conseiller> getAll() {
        return conseillerService.getAll();
    }

    @GetMapping("/{id}")
    public Conseiller getById(@PathVariable Long id) {
        return conseillerService.getById(id);
    }

    @PostMapping
    public Conseiller create(@RequestBody Conseiller conseiller) {
        return conseillerService.create(conseiller);
    }

    @PutMapping("/{id}")
    public Conseiller update(@PathVariable Long id, @RequestBody Conseiller updated) {
        return conseillerService.update(id, updated);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        conseillerService.delete(id);
    }
}
