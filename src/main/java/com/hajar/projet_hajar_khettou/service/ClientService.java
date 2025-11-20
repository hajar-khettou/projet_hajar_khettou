package com.hajar.projet_hajar_khettou.service;

import com.hajar.projet_hajar_khettou.entity.Client;

import java.util.List;

public interface ClientService {

    Client creerClientPourConseiller(Long conseillerId, Client client);

    List<Client> listerClientsDuConseiller(Long conseillerId);

    void supprimerClient(Long clientId);
}
