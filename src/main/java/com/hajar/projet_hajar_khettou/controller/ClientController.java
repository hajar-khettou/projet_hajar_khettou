package com.hajar.projet_hajar_khettou.controller;

import com.hajar.projet_hajar_khettou.entity.Client;
import com.hajar.projet_hajar_khettou.service.ClientService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clients")
public class ClientController {

    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping("/conseiller/{conseillerId}")
    public Client creerClient(@PathVariable Long conseillerId,
                              @RequestBody Client client) {
        return clientService.creerClientPourConseiller(conseillerId, client);
    }

    @GetMapping("/conseiller/{conseillerId}")
    public List<Client> listerClients(@PathVariable Long conseillerId) {
        return clientService.listerClientsDuConseiller(conseillerId);
    }

    @DeleteMapping("/{clientId}")
    public void supprimerClient(@PathVariable Long clientId) {
        clientService.supprimerClient(clientId);
    }
}
