package com.fleb.evta.model;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;
@Data
public class ComprobanteDTO {

    private Integer comprobanteid;
    private Integer cantidad;
    private Date fecha;
    private BigDecimal total;
    private Cliente cliente;
    private Set<LineaDTO> lineas;

}
