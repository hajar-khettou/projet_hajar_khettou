package com.hajar.projet_hajar_khettou.service;

import com.hajar.projet_hajar_khettou.entity.Conseiller;

import java.util.List;

public interface ConseillerService {

    List<Conseiller> getAll();

    Conseiller getById(Long id);

    Conseiller create(Conseiller conseiller);

    Conseiller update(Long id, Conseiller conseiller);

    void delete(Long id);
}
