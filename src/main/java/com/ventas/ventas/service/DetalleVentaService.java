package com.ventas.ventas.service;

import com.ventas.ventas.model.DetalleVenta;
import com.ventas.ventas.repository.IDetalleVentaRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class DetalleVentaService implements ICRUDService<DetalleVenta> {

    @Autowired
    private IDetalleVentaRepository detalleVentaRepository;

    @Override
    public List<DetalleVenta> finAll() {
        return detalleVentaRepository.findAll();
    }

    @Override
    public Optional<DetalleVenta> findbyid(Integer id) {
        return detalleVentaRepository.findById(id);
    }

    @Override
    public DetalleVenta create(DetalleVenta detalleVenta) {
        return detalleVentaRepository.save(detalleVenta);
    }

    @Override
    public DetalleVenta update(DetalleVenta detalleVenta) {
        return detalleVentaRepository.save(detalleVenta);
    }

    @Override
    public void delete(Integer id) {
    detalleVentaRepository.deleteById(id);
    }
}
