package com.ventas.ventas.service;

import com.ventas.ventas.model.Producto;
import com.ventas.ventas.repository.IProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoService implements ICRUDService<Producto>{

    @Autowired
    private IProductoRepository productoRepository;

    @Override
    public List<Producto> finAll() {
        return productoRepository.findAll();
    }

    @Override
    public Optional<Producto> findbyid(Integer id) {
        return productoRepository.findById(id);
    }

    @Override
    public Producto create(Producto producto) {
        return productoRepository.save(producto);
    }

    @Override
    public Producto update(Producto producto) {
        return productoRepository.save(producto);
    }

    @Override
    public void delete(Integer id) {
    productoRepository.deleteById(id);
    }
}
