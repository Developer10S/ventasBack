package com.ventas.ventas.service;

import com.ventas.ventas.model.TipoProducto;
import com.ventas.ventas.repository.ITipoProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class TipoProductoService implements ICRUDService<TipoProducto> {

    @Autowired
    private ITipoProductoRepository tipoProductoRepository;

    @Override
    public List<TipoProducto> finAll() {
        return tipoProductoRepository.findAll();
    }

    @Override
    public Optional<TipoProducto> findbyid(Integer id) {
        return tipoProductoRepository.findById(id);
    }

    @Override
    public TipoProducto create(TipoProducto tipoProducto) {
        return tipoProductoRepository.save(tipoProducto);
    }

    @Override
    public TipoProducto update(TipoProducto tipoProducto) {
        return tipoProductoRepository.save(tipoProducto);
    }

    @Override
    public void delete(Integer id) {
    tipoProductoRepository.deleteById(id);
    }
}
