package com.ventas.ventas.controller;
import com.ventas.ventas.model.TipoProducto;
import com.ventas.ventas.service.TipoProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/tipoProductos")
public class TipoProductoController {

    @Autowired
    private TipoProductoService tipoProductoService;

    @GetMapping
    public ResponseEntity<List<TipoProducto>> findAll(){
        return  ResponseEntity.ok(tipoProductoService.finAll());
    }

    @PostMapping
    public ResponseEntity<TipoProducto> create (@Valid @RequestBody TipoProducto tipoProducto){
        return new ResponseEntity<>(tipoProductoService.create(tipoProducto), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoProducto> findbyId (@PathVariable("id") Integer idTipoProducto){
        return tipoProductoService.findbyid(idTipoProducto)
                .map(ResponseEntity::ok)
                .orElseGet(() ->ResponseEntity.notFound().build());
    }

    @PutMapping
    public ResponseEntity<TipoProducto> update(@Valid @RequestBody TipoProducto tipoProducto){
        return tipoProductoService.findbyid(tipoProducto.getIdTipoProducto())
                .map(p ->
                        ResponseEntity.ok(tipoProductoService.update(tipoProducto)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete (@PathVariable("id") Integer idTipoProducto){
        return tipoProductoService.findbyid(idTipoProducto)
                .map(p -> {
                    tipoProductoService.delete(idTipoProducto);
                    return ResponseEntity.ok().build();
                }).orElseGet(() ->ResponseEntity.notFound().build());
    }
}
