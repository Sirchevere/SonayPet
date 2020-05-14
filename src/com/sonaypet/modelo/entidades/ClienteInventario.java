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
public class ClienteInventario {
    int id;
    String dni;
    String nom;
    String direc;

    public ClienteInventario() {
    }

    public ClienteInventario(int id, String dni, String nom, String direc) {
        this.id = id;
        this.dni = dni;
        this.nom = nom;
        this.direc = direc;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDirec() {
        return direc;
    }

    public void setDirec(String direc) {
        this.direc = direc;
    }

    
    
}
