package com.fleb.evta.model;

import jakarta.persistence.*;



import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name="comprobante")
@NamedQuery(name="Comprobante.findAll", query="SELECT c FROM Comprobante c")
public class Comprobante implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer comprobanteid;

    private Integer cantidad;

    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;

    private BigDecimal total;

    //bi-directional many-to-one association to Cliente
    @ManyToOne
    @JoinColumn(name="clienteid")
    private Cliente cliente;

    //bi-directional many-to-one association to Linea
    @OneToMany(mappedBy="comprobante", fetch=FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Linea> lineas;

    public Comprobante() {
    }

    public Integer getComprobanteid() {
        return comprobanteid;
    }

    public void setComprobanteid(Integer comprobanteid) {
        this.comprobanteid = comprobanteid;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Set<Linea> getLineas() {
        return lineas;
    }

    public void setLineas(Set<Linea> lineas) {
        this.lineas = lineas;
    }

    public Linea addLinea(Linea linea) {
        getLineas().add(linea);
        linea.setComprobante(this);

        return linea;
    }

    public Linea removeLinea(Linea linea) {
        getLineas().remove(linea);
        linea.setComprobante(null);

        return linea;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Comprobante [");
        if (comprobanteid != null)
            builder.append("comprobanteid=").append(comprobanteid).append(", ");
        if (cantidad != null)
            builder.append("cantidad=").append(cantidad).append(", ");
        if (fecha != null)
            builder.append("fecha=").append(fecha).append(", ");
        if (total != null)
            builder.append("total=").append(total).append(", ");
        if (cliente != null)
            builder.append("cliente=").append(cliente).append(", ");
        if (lineas != null)
            builder.append("lineas=").append(lineas);
        builder.append("]");
        return builder.toString();
    }




}