package com.hajar.projet_hajar_khettou.service;

import com.hajar.projet_hajar_khettou.entity.Conseiller;
import com.hajar.projet_hajar_khettou.repository.ConseillerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ConseillerServiceImpl implements ConseillerService {

    private final ConseillerRepository conseillerRepository;

    public ConseillerServiceImpl(ConseillerRepository conseillerRepository) {
        this.conseillerRepository = conseillerRepository;
    }

    @Override
    public List<Conseiller> getAll() {
        return conseillerRepository.findAll();
    }

    @Override
    public Conseiller getById(Long id) {
        return conseillerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Conseiller introuvable avec id " + id));
    }

    @Override
    public Conseiller create(Conseiller conseiller) {
        return conseillerRepository.save(conseiller);
    }

    @Override
    public Conseiller update(Long id, Conseiller updated) {
        Conseiller existing = getById(id);

        existing.setNom(updated.getNom());
        existing.setPrenom(updated.getPrenom());
        existing.setEmail(updated.getEmail());
        existing.setTelephone(updated.getTelephone());


        return conseillerRepository.save(existing);
    }

    @Override
    public void delete(Long id) {
        conseillerRepository.deleteById(id);
    }
}
