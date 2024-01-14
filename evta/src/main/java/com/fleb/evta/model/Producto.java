package com.fleb.evta.model;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name="producto")
@NamedQuery(name="Producto.findAll", query="SELECT p FROM Producto p")
@Data

public class Producto implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer productoid;

    private Integer cantidad;

    private Integer codigo;

    private String descripcion;

    private BigDecimal precio;

    
}
