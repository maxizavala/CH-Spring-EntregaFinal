package com.deg.productservice.service;

import com.deg.productservice.model.Client;
import com.deg.productservice.repository.ClientRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;

    // Obtener todos los clientes
    public List<Client> findAll() { return clientRepository.findAll(); }

    // Crear cliente
    public Client create(Client client) {
        return clientRepository.save(client);
    }

}
