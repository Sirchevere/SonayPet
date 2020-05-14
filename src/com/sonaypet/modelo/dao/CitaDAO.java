/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sonaypet.modelo.dao;

import com.sonaypet.modelo.entidades.CRUD;
import com.sonaypet.modelo.entidades.Cita;
import com.sonaypet.modelo.entidades.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author cesar
 */
public class CitaDAO implements CRUD {
    Connection con;
    Conexion cn = new Conexion();
    PreparedStatement ps;
    ResultSet rs;

    @Override
    public List listar() {
        List<Cita> lista = new ArrayList<>();
        String sql = "SELECT * FROM tab_citas";
        
        try{
        con = cn.Conectar();
        ps = con.prepareStatement(sql);
        rs = ps.executeQuery();
        
        while(rs.next()){
        Cita c = new Cita();
        c.setId(rs.getInt(1));
        c.setIdCliente(rs.getInt(2));
        c.setIdMascota(rs.getInt(3));
        c.setFecha(rs.getString(4));
        c.setHora(rs.getString(5));
        lista.add(c);
        }
        
        } catch(Exception e){
        
        }
        
        return lista;
    }

    @Override
    public int agregar(Object[] o) {
       int r = 0;
       String sql = "INSERT INTO tab_citas(CLIENTE_ID,MASCOTA_ID,CITA_FECHAHR,CITA_HORA)values(?,?,?,?)";
       
       try{
           con = cn.Conectar();
           ps = con.prepareStatement(sql);
           ps.setObject(1, o[0]);
           ps.setObject(2, o[1]);
           ps.setObject(3, o[2]);
           ps.setObject(4, o[3]);
           r = ps.executeUpdate();
           
       }catch(Exception e){
       
       }
       
       return r;
    }

    @Override
    public int actualizar(Object[] o) {
        int r = 0;
        String sql = "UPDATE tab_citas SET CLIENTE_ID=?,MASCOTA_ID=?,CITA_FECHAHR=?,CITA_HORA=? WHERE ID_CITAS=?";
        
        try{
            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            ps.setObject(1, o[0]);
            ps.setObject(2, o[1]);
            ps.setObject(3, o[2]);
            ps.setObject(4, o[3]);
            ps.setObject(5, o[4]);
            r = ps.executeUpdate();
        
        }catch(Exception e){
        
        }
        
        return r;
    }

    @Override
    public void eliminar(int id) {
        String sql="DELETE FROM tab_citas WHERE ID_CITAS=?";
        
        try{
            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        
        }catch(Exception e){
        
        }
    }
    
}
