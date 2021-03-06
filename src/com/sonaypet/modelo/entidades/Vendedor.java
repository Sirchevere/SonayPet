
package com.sonaypet.modelo.entidades;


public class Vendedor {
    int id;
    String nom;
    String tel;
    String usuario;
    String dni;
    String estado;

    public Vendedor() {
    }

    public Vendedor(int id, String nom, String tel, String usuario, String dni, String estado) {
        this.id = id;
        this.nom = nom;
        this.tel = tel;
        this.usuario = usuario;
        this.dni = dni;
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    

}
