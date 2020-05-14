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
public class Mascota {
    int id;	
    int idCliente;	
    String Nombre;
    String fechaNac;	
    String especie;	
    String raza;
    String genero;	
    String color;
    String pelaje;

    public Mascota() {
        
    }

    public Mascota(int id, int idCliente, String Nombre, String fechaNac, String especie, String raza, String genero, String color, String pelaje) {
        this.id = id;
        this.idCliente = idCliente;
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

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
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
