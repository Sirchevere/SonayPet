/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sonaypet.modelo.entidades;

/**
 *
 * @author cesar
 */
public class AgregarMascota {
    int id;	
    String cliNombre;
    String cliApellido;
    String Nombre;
    String fechaNac;	
    String especie;	
    String raza;
    String genero;	
    String color;
    String pelaje;

    public AgregarMascota() {
        
    }

    public AgregarMascota(int id, String cliNombre, String cliApellido, String Nombre, String fechaNac, String especie, String raza, String genero, String color, String pelaje) {
        this.id = id;
        this.cliNombre = cliNombre;
        this.cliApellido = cliApellido;
        this.Nombre = Nombre;
        this.fechaNac = fechaNac;
        this.especie = especie;
        this.raza = raza;
        this.genero = genero;
        this.color = color;
        this.pelaje = pelaje;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCliNombre() {
        return cliNombre;
    }

    public void setCliNombre(String cliNombre) {
        this.cliNombre = cliNombre;
    }

    public String getCliApellido() {
        return cliApellido;
    }

    public void setCliApellido(String cliApellido) {
        this.cliApellido = cliApellido;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(String fechaNac) {
        this.fechaNac = fechaNac;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getPelaje() {
        return pelaje;
    }

    public void setPelaje(String pelaje) {
        this.pelaje = pelaje;
    }

   
}
