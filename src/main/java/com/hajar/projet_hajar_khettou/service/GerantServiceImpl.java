package com.hajar.projet_hajar_khettou.service;

import com.hajar.projet_hajar_khettou.entity.Gerant;
import com.hajar.projet_hajar_khettou.repository.GerantRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class GerantServiceImpl implements GerantService {

    private final GerantRepository gerantRepository;

    public GerantServiceImpl(GerantRepository gerantRepository) {
        this.gerantRepository = gerantRepository;
    }

    @Override
    public List<Gerant> getAll() {
        return gerantRepository.findAll();
    }

    @Override
    public Gerant getById(Long id) {
        return gerantRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Gérant introuvable avec id " + id));
    }

    @Override
    public Gerant create(Gerant gerant) {
        return gerantRepository.save(gerant);
    }

    @Override
    public Gerant update(Long id, Gerant updated) {
        Gerant existing = getById(id);

        existing.setNom(updated.getNom());
        existing.setPrenom(updated.getPrenom());
        existing.setEmail(updated.getEmail());
        existing.setTelephone(updated.getTelephone());

        return gerantRepository.save(existing);
    }

    @Override
    public void delete(Long id) {
        gerantRepository.deleteById(id);
    }
}
