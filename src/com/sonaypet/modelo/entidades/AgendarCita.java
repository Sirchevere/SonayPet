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
public class AgendarCita {
    int id;
    String nombre;
    String apellido;
    String nombreM;
    String fecha;
    String Hora;

    public AgendarCita() {
    }

    public AgendarCita(int id, String nombre, String apellido, String nombreM, String fecha, String Hora) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.nombreM = nombreM;
        this.fecha = fecha;
        this.Hora = Hora;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombreM() {
        return nombreM;
    }

    public void setNombreM(String nombreM) {
        this.nombreM = nombreM;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return Hora;
    }

    public void setHora(String Hora) {
        this.Hora = Hora;
    }

   
}
