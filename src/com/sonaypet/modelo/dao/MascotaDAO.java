/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sonaypet.modelo.dao;

import com.sonaypet.modelo.entidades.CRUD;
import com.sonaypet.modelo.entidades.Conexion;
import com.sonaypet.modelo.entidades.Mascota;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author cesar
 */
public class MascotaDAO implements CRUD {
    Connection con;
    Conexion cn = new Conexion();
    PreparedStatement ps;
    ResultSet rs;
    
    @Override
    public List listar() {
        List<Mascota> lista = new ArrayList<>();
        String sql = "SELECT * FROM tab_mascota";
        
        try{
        con = cn.Conectar();
        ps = con.prepareStatement(sql);
        rs = ps.executeQuery();
        
        while(rs.next()){
        Mascota m = new Mascota();
        m.setId(rs.getInt(1));
        m.setIdCliente(rs.getInt(2));
        m.setNombre(rs.getString(3));
        m.setFechaNac(rs.getString(4));
        m.setEspecie(rs.getString(5));
        m.setRaza(rs.getString(6));
        m.setGenero(rs.getString(7));
        m.setColor(rs.getString(8));
        m.setPelaje(rs.getString(9));
        lista.add(m);
        }
        
        } catch(Exception e){
        
        }
        
        return lista;
    }

    @Override
    public int agregar(Object[] o) {
       int r = 0;
       String sql = "INSERT INTO tab_mascota(ID_CLIENTE,MASC_NOMBRE,MASC_FECHANAC,MASC_ESPECIE,MASC_RAZA,MASC_GENERO,MASC_COLOR,MASC_PELAJE)values(?,?,?,?,?,?,?,?)";
       
       try{
           con = cn.Conectar();
           ps = con.prepareStatement(sql);
           ps.setObject(1, o[0]);
           ps.setObject(2, o[1]);
           ps.setObject(3, o[2]);
           ps.setObject(4, o[3]);
           ps.setObject(5, o[4]);
           ps.setObject(6, o[5]);
           ps.setObject(7, o[6]);
           ps.setObject(8, o[7]);
           r = ps.executeUpdate();
           
       }catch(Exception e){
       
       }
       
       return r;
    }

    @Override
    public int actualizar(Object[] o) {
        int r = 0;
        String sql = "UPDATE tab_mascota SET ID_CLIENTE=?,MASC_NOMBRE=?,MASC_FECHANAC=?,MASC_ESPECIE=?,MASC_RAZA=?,MASC_GENERO=?,MASC_COLOR=?,MASC_PELAJE=? WHERE ID_MASCOTA=?";
        
        try{
            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            ps.setObject(1, o[0]);
            ps.setObject(2, o[1]);
            ps.setObject(3, o[2]);
            ps.setObject(4, o[3]);
            ps.setObject(5, o[4]);
            ps.setObject(6, o[5]);
            ps.setObject(7, o[6]);
            ps.setObject(8, o[7]);
            ps.setObject(9, o[8]);
            r = ps.executeUpdate();
        
        }catch(Exception e){
        
        }
        
        return r;
    }

    @Override
    public void eliminar(int id) {
       String sql="DELETE FROM tab_mascota WHERE ID_MASCOTA=?";
        
        try{
            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        
        }catch(Exception e){
        
        }
    }
    
}
