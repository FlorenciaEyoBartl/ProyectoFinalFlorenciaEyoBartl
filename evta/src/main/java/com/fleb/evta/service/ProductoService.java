package com.fleb.evta.service;

import java.util.List;

import com.fleb.evta.model.Producto;
import com.fleb.evta.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
 public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    public List<Producto> findAll() {
        return this.productoRepository.findAll();
    }

    public Producto save(Producto cliente) {
        return this.productoRepository.save(cliente);
    }

    public Producto findById(Integer id) {

        var opCliente =  this.productoRepository.findById(id);
        if (opCliente.isPresent()) {
            return opCliente.get();
        } else {
            return new Producto();
        }
    }

}
