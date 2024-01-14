package com.fleb.evta.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class LineaDTO {

    private Integer lineaid;

    private Integer cantidad;

    private String descripcion;

    private BigDecimal precio;
}