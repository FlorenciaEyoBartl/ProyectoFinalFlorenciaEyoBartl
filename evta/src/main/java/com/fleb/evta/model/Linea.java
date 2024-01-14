package com.fleb.evta.model;

import jakarta.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;



@Entity
@Table(name = "linea")

public class Linea implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer lineaid;

    private Integer cantidad;

    private String descripcion;

    private BigDecimal precio;

    //bi-directional many-to-one association to Comprobante
    @ManyToOne
    @JoinColumn(name="comprobanteid")
    private Comprobante comprobante;

    //bi-directional many-to-one association to Producto
    @ManyToOne
    @JoinColumn(name="productoid")
    private Producto producto;

    public Integer getLineaid() {
        return lineaid;
    }

    public void setLineaid(Integer lineaid) {
        this.lineaid = lineaid;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public Comprobante getComprobante() {
        return comprobante;
    }

    public void setComprobante(Comprobante comprobante) {
        this.comprobante = comprobante;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Linea [lineaid=").append(lineaid).append(", cantidad=").append(cantidad).append(", ");
        if (descripcion != null)
            builder.append("descripcion=").append(descripcion).append(", ");
        if (precio != null)
            builder.append("precio=").append(precio);
        builder.append("]");
        return builder.toString();
    }
}
