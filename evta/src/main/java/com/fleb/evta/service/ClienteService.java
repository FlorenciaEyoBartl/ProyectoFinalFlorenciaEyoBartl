package com.fleb.evta.service;

import com.fleb.evta.model.ClienteDTO;
import com.fleb.evta.model.Cliente;
import com.fleb.evta.repository.ClienteRepository;
import jakarta.validation.Valid;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.validation.constraints.*;
import org.springframework.validation.annotation.Validated;


import java.util.List;


@Data
@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> findAll() {
        return this.clienteRepository.findAll();
    }

    public Cliente save(@Valid @Validated Cliente cliente) {
        // Imprimir los datos del cliente antes de guardarlos
        System.out.println("Datos del Cliente a Guardar: " + cliente);
        return this.clienteRepository.save(cliente);
    }

    public void deleteById(Integer id) {
        this.clienteRepository.deleteById(id);
    }

    public Cliente findById(Integer id) {
        var opCliente =  this.clienteRepository.findById(id);
        if (opCliente.isPresent()) {
            return opCliente.get();
        } else {
            return new Cliente();
        }
    }
}