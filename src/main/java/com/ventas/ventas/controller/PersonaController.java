package com.ventas.ventas.controller;

import com.ventas.ventas.model.Persona;
import com.ventas.ventas.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/personas")
public class PersonaController {

    @Autowired
    private PersonaService personaService;

    //operaciones para  persona
    @GetMapping
    public ResponseEntity<List<Persona>>findAll(){
        //retorna una lista de personas
        return ResponseEntity.ok(personaService.finAll());
    }

    @PostMapping
    public ResponseEntity<Persona> create(@Valid @RequestBody Persona persona){
        //retorna una persona y la recibirá como propiedad en el cuerpo de la peticio
        return new ResponseEntity<>(personaService.create(persona), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Persona> findbyId (@PathVariable("id") Integer idPersona){
        //buscar una persona por id, recibe una propiedad id
        return  personaService.findbyid(idPersona)
                .map(ResponseEntity::ok)
                .orElseGet(()-> ResponseEntity.notFound().build());
    }

    @PutMapping
    public ResponseEntity<Persona> update (@Valid @RequestBody Persona persona){
        //servicio para actualizar pero primero se busca si existe
        return personaService.findbyid(persona.getIdPersona())
                .map(p -> ResponseEntity.ok(personaService.update(persona)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> detele (@PathVariable("id") Integer idPersona){
        //borrar por id
        return personaService.findbyid(idPersona)
                .map(p -> {
                    personaService.delete(idPersona);
                    return ResponseEntity.ok().build();
                }).orElseGet(() -> ResponseEntity.notFound().build());
    }

}
