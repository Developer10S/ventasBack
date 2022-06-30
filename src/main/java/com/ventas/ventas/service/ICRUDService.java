package com.ventas.ventas.service;

import com.ventas.ventas.model.Cliente;

import java.util.List;
import java.util.Optional;

public interface ICRUDService<T>{

    List<T> finAll();

    Optional<T> findbyid(Integer id);

    T create (T model);

    T update (T model);

    void delete(Integer id);
}
