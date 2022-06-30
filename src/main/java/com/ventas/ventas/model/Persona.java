package com.ventas.ventas.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPersona;

    @NotNull
    @NotBlank(message = "El nombre es obligatorio")
    @Size(min=3,max=70,message = "El nombre debe tener una longitud")
    @Column(name="nombres",nullable = false,length = 70)
    private String nombres;

    @NotNull
    @NotBlank(message = "los apellidos es obligatorio")
    @Size(min=3,max=150,message = "El apellido debe tener una longitud")
    @Column(name="apellidos",nullable = false,length = 150)
    private String apellidos;

    @Size(max=150,message = "La direccion no debe superar los 150 caracteres")
    @Column(name="direccion",nullable = true,length = 150)
    private String direccion;

    @Size(max=10,message = "El telefono no debe superar los 10 digitos")
    @Column(name="telefono",nullable = true,length = 10)
    private String telefono;

    public Integer getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Integer idPersona) {
        this.idPersona = idPersona;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
