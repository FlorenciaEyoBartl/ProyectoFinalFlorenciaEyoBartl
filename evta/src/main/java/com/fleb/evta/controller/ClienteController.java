package com.fleb.evta.controller;

import com.fleb.evta.model.Cliente;
import com.fleb.evta.model.ClienteDTO;
import com.fleb.evta.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public ResponseEntity<List<Cliente>> findAll() {
        try {
            List<Cliente> clientes = clienteService.findAll();
            return ResponseEntity.ok(clientes);
        } catch (Exception ex) {
            ex.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> one(@PathVariable Integer id) {
        try {
            Cliente cliente = clienteService.findById(id);
            if (cliente != null) {
                return ResponseEntity.ok(cliente);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente no encontrado con ID: " + id);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al buscar el cliente.");
        }
    }

    @PostMapping
    public ResponseEntity<String> newEntity(@Validated @RequestBody ClienteDTO clienteDTO) {
        try {
            // Convertir ClienteDTO a Cliente
            Cliente cliente = convertirDTOaCliente(clienteDTO);

            // Guardar el cliente
            Cliente savedCliente = clienteService.save(cliente);

            // Retornar la respuesta con el mensaje adecuado
            return ResponseEntity.status(HttpStatus.CREATED).body("Cliente creado exitosamente. Cliente ID: " + savedCliente.getClienteid());
        } catch (Exception ex) {
            ex.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al crear el cliente.");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateEntity(@PathVariable Integer id, @Validated @RequestBody ClienteDTO clienteDTO) {
        try {
            // Convertir ClienteDTO a Cliente
            Cliente cliente = convertirDTOaCliente(clienteDTO);

            // Actualizar el cliente
            Cliente existingCliente = clienteService.findById(id);
            if (existingCliente != null) {
                cliente.setClienteid(id);
                Cliente updatedCliente = clienteService.save(cliente);
                return ResponseEntity.ok("Cliente actualizado exitosamente. Cliente ID: " + updatedCliente.getClienteid());
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al actualizar el cliente.");
        }
    }

    // Método para convertir ClienteDTO a Cliente
    private Cliente convertirDTOaCliente(ClienteDTO clienteDTO) {
        Cliente cliente = new Cliente();
        cliente.setNombre(clienteDTO.getNombre());
        cliente.setApellido(clienteDTO.getApellido());
        cliente.setDni(clienteDTO.getDni());
        return cliente;
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCliente(@PathVariable Integer id) {
        try {
            Cliente existingCliente = clienteService.findById(id);

            if (existingCliente != null) {
                clienteService.deleteById(id);
                return ResponseEntity.ok("Cliente eliminado exitosamente. Cliente ID: " + id);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente no encontrado con ID: " + id);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al eliminar el cliente.");
        }
    }
}
