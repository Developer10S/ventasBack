package com.ventas.ventas.controller;

import com.ventas.ventas.model.DetalleVenta;
import com.ventas.ventas.service.DetalleVentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/detalleVenta")
public class DetalleVentaController {

    @Autowired
    private DetalleVentaService detalleVentaService;

    @GetMapping
    public ResponseEntity<List<DetalleVenta>> findAll(){
        return ResponseEntity.ok(detalleVentaService.finAll());
    }

    @PostMapping
    public ResponseEntity<DetalleVenta> create (@Valid @RequestBody DetalleVenta detalleVenta){
        return new ResponseEntity<>(detalleVentaService.create(detalleVenta), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetalleVenta> findbyId (@PathVariable("id") Integer idDetalleVenta){
        return detalleVentaService.findbyid(idDetalleVenta)
                .map(ResponseEntity::ok)
                .orElseGet(()-> ResponseEntity.notFound().build());
    }

    @PutMapping
    public ResponseEntity<DetalleVenta> update (@Valid @RequestBody DetalleVenta detalleVenta){
        return detalleVentaService.findbyid(detalleVenta.getIdDetalleVenta())
                .map(c ->
                    ResponseEntity.ok(detalleVentaService.update(detalleVenta)))
                    .orElseGet(()-> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete (@PathVariable("id") Integer idDetalleVenta){
        return detalleVentaService.findbyid(idDetalleVenta)
                .map(c ->{
                    detalleVentaService.delete(idDetalleVenta);
                    return ResponseEntity.ok().build();
                }).orElseGet(()-> ResponseEntity.notFound().build());
    }

}
