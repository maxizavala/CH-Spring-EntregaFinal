package com.deg.productservice.controller;

import com.deg.productservice.exception.ClientAlreadyExistsException;
import com.deg.productservice.exception.ProductAlreadyExistsException;
import com.deg.productservice.model.Client;
import com.deg.productservice.model.Product;
import com.deg.productservice.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping(path = "api/client")
public class ClientController {
    @Autowired
    private ClientService clientService;

    @GetMapping(path = "/")
    public ResponseEntity<List<Client>> findAll() {
        return new ResponseEntity<>(this.clientService.findAll(), HttpStatus.OK);
    }

    @PostMapping(path = "/")
    public ResponseEntity<Client> create(@RequestBody Client client) throws ClientAlreadyExistsException {
        return new ResponseEntity<>(this.clientService.create(client), HttpStatus.OK);
    }
}
