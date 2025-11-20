package com.hajar.projet_hajar_khettou.service;

import com.hajar.projet_hajar_khettou.entity.Client;
import com.hajar.projet_hajar_khettou.entity.Conseiller;
import com.hajar.projet_hajar_khettou.repository.ClientRepository;
import com.hajar.projet_hajar_khettou.repository.ConseillerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;
    private final ConseillerRepository conseillerRepository;

    public ClientServiceImpl(ClientRepository clientRepository,
                             ConseillerRepository conseillerRepository) {
        this.clientRepository = clientRepository;
        this.conseillerRepository = conseillerRepository;
    }

    @Override
    public Client creerClientPourConseiller(Long conseillerId, Client client) {
        Conseiller conseiller = conseillerRepository.findById(conseillerId)
                .orElseThrow(() -> new RuntimeException("Conseiller introuvable"));
        conseiller.addClient(client);
        return clientRepository.save(client);
    }

    @Override
    public List<Client> listerClientsDuConseiller(Long conseillerId) {
        return clientRepository.findByConseillerId(conseillerId);
    }

    @Override
    public void supprimerClient(Long clientId) {
        clientRepository.deleteById(clientId);
    }
}
