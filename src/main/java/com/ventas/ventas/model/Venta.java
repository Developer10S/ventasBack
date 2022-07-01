package com.ventas.ventas.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Entity
public class Venta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idVenta;

    private LocalDate fecha;

    @ManyToOne
    @JoinColumn(name = "id_cliente", nullable = false)
    private Cliente idCliente;

    @OneToMany (mappedBy = "idVenta",cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, fetch = FetchType.LAZY)

    private List<DetalleVenta> detalleVentaList;

    public Integer getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(Integer idVenta) {
        this.idVenta = idVenta;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Cliente getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Cliente idCliente) {
        this.idCliente = idCliente;
    }

    public List<DetalleVenta> getDetalleVentaList() {
        return detalleVentaList;
    }

    public void setDetalleVentaList(List<DetalleVenta> detalleVentaList) {
        this.detalleVentaList = detalleVentaList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Venta venta = (Venta) o;
        return Objects.equals(idVenta, venta.idVenta);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idVenta);
    }
}

