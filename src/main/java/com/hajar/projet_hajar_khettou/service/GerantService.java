package com.hajar.projet_hajar_khettou.service;

import com.hajar.projet_hajar_khettou.entity.Gerant;

import java.util.List;

public interface GerantService {

    List<Gerant> getAll();

    Gerant getById(Long id);

    Gerant create(Gerant gerant);

    Gerant update(Long id, Gerant gerant);

    void delete(Long id);
}
