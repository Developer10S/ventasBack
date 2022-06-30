package com.ventas.ventas.service;

import com.ventas.ventas.model.Cliente;
import com.ventas.ventas.repository.IClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService implements ICRUDService<Cliente> {

    @Autowired
    private IClienteRepository clienteRepor;

    @Override
    public List<Cliente> finAll() {
        return clienteRepor.findAll();
    }

    @Override
    public Optional<Cliente> findbyid(Integer id) {
        return clienteRepor.findById(id);
    }

    @Override
    public Cliente create(Cliente cliente) {
        return clienteRepor.save(cliente);
    }

    @Override
    public Cliente update(Cliente cliente) {
        return clienteRepor.save(cliente);
    }

    @Override
    public void delete(Integer id) {
        clienteRepor.deleteById(id);
    }
}
