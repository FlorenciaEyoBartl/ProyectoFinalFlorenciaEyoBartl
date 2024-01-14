package com.fleb.evta.controller;

import com.fleb.evta.model.Comprobante;
import com.fleb.evta.model.ComprobanteDTO;
import com.fleb.evta.service.ComprobanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comprobante")

public class ComprobanteController {

    @Autowired
    private ComprobanteService comprobanteService;

    @GetMapping
    public List<ComprobanteDTO> findAll() {
        return this.comprobanteService.findAll();
    }



    @GetMapping("/{id}")
    public ComprobanteDTO one(@PathVariable Integer id) {

        return this.comprobanteService.findById(id);
    }
    @PostMapping
    public ComprobanteDTO newEntity(@RequestBody Comprobante comprobante) {
        return this.comprobanteService.save(comprobante);
    }
}

/*

Cuerpo JSON metodo POST

{
    "cliente": { "clienteid":1 },
    "lineas":[
    {
        "cantidad":1,
        "producto":{"productoid":1}
    },
    {
        "cantidad":1,
        "producto":{"productoid":2}
    }

    ]

}

[
    {
        "comprobanteid": 1,
        "cantidad": 2,
        "fecha": "2023-12-23T03:05:59.000+00:00",
        "total": 1300.0,
        "cliente": {
            "clienteid": 1,
            "nombre": "florencia",
            "apellido": "eyo",
            "dni": 36916300
        },
        "lineas": [
            {
                "lineaid": 1,
                "cantidad": 1,
                "descripcion": "Zapatos",
                "precio": 500.0
            },
            {
                "lineaid": 2,
                "cantidad": 1,
                "descripcion": "Zapatillas",
                "precio": 800.0
            }
        ]
    }
]


 */
