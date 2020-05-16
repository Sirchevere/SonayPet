/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sonaypet.modelo.entidades;

import java.util.List;

/**
 *
 * @author cesar
 */
public interface CRUD {
    public List listar();
    public int agregar(Object[] o);
    public int actualizar(Object[] o);
    public void eliminar(int id);
    public List custom(int id);
    public Object listarID(int id);
    public List buscarTodosID(int id);
}
