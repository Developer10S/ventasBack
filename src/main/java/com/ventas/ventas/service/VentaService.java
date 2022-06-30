package com.ventas.ventas.service;

import com.ventas.ventas.model.Venta;
import com.ventas.ventas.repository.IVentaRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class VentaService implements ICRUDService<Venta>{

    @Autowired
    private IVentaRepository ventaRepository;
    @Override
    public List<Venta> finAll() {
        return ventaRepository.findAll();
    }

    @Override
    public Optional<Venta> findbyid(Integer id) {
        return ventaRepository.findById(id);
    }

    @Override
    public Venta create(Venta venta) {
        return ventaRepository.save(venta);
    }

    @Override
    public Venta update(Venta venta) {
        return ventaRepository.save(venta);
    }

    @Override
    public void delete(Integer id) {
    ventaRepository.deleteById(id);
    }
}
