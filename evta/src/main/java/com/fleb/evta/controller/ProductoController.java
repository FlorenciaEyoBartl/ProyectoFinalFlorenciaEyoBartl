package com.fleb.evta.controller;
import com.fleb.evta.model.Producto;
import com.fleb.evta.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/producto")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @GetMapping
    public List<Producto> findAll() {
        return this.productoService.findAll();
    }

    // Single item

    @GetMapping("/{id}")
    public Producto one(@PathVariable Integer id) {

        return this.productoService.findById(id);
    }

    @PostMapping
    public Producto newEntity(@RequestBody Producto producto) {
        return this.productoService.save(producto);
    }
}

/*


    {
        "productoid": 1,
        "cantidad": 2,
        "codigo": 123,
        "descripcion": "Zapatos",
        "precio": 500.0
    },
    {
        "productoid": 2,
        "cantidad": 5,
        "codigo": 128,
        "descripcion": "Zapatillas",
        "precio": 800.0
    },
    {
        "productoid": 3,
        "cantidad": 300,
        "codigo": 125,
        "descripcion": "ojota",
        "precio": 300.0
    }
]

 */
