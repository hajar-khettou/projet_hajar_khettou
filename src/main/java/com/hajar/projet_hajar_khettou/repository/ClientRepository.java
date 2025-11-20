package com.hajar.projet_hajar_khettou.repository;

import com.hajar.projet_hajar_khettou.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClientRepository extends JpaRepository<Client, Long> {

    List<Client> findByConseillerId(Long conseillerId);
}
