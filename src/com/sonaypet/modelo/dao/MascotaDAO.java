/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sonaypet.modelo.dao;

import com.sonaypet.modelo.entidades.AgregarMascota;
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

        try {
            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
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

        } catch (Exception e) {

        }

        return lista;
    }
    @Override
    public List custom(int id) {
        List<AgregarMascota> lista = new ArrayList<>();
        String sql = "SELECT tab_mascota.ID_MASCOTA, tab_cliente.CLI_NOMBRES, \n"
                + "tab_cliente.CLI_APELLIDOS, \n"
                + "tab_mascota.MASC_NOMBRE,\n"
                + "tab_mascota.MASC_FECHANAC,\n"
                + "tab_mascota.MASC_ESPECIE,tab_mascota.MASC_RAZA,tab_mascota.MASC_GENERO,tab_mascota.MASC_COLOR,tab_mascota.MASC_PELAJE\n"
                + "\n"
                + "FROM   sonaypet_cliveterinaria.tab_mascota \n"
                + "INNER JOIN tab_cliente \n"
                + "        ON tab_cliente.ID_CLIENTE = tab_mascota.ID_CLIENTE\n"
                + "WHERE  tab_mascota.id_cliente ="+id;

        try {
            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                AgregarMascota m = new AgregarMascota();
                m.setId(rs.getInt(1));
                m.setCliNombre(rs.getString(2));
                m.setCliApellido(rs.getString(3));
                m.setNombre(rs.getString(4));
                m.setFechaNac(rs.getString(5));
                m.setEspecie(rs.getString(6));
                m.setRaza(rs.getString(7));
                m.setGenero(rs.getString(8));
                m.setColor(rs.getString(9));
                m.setPelaje(rs.getString(10));
                lista.add(m);
            }

        } catch (Exception e) {

        }

        return lista;
    }
        

    @Override
    public int agregar(Object[] o) {
        int r = 0;
        String sql = "INSERT INTO tab_mascota(ID_CLIENTE,MASC_NOMBRE,MASC_FECHANAC,MASC_ESPECIE,MASC_RAZA,MASC_GENERO,MASC_COLOR,MASC_PELAJE)values(?,?,?,?,?,?,?,?)";

        try {
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

        } catch (Exception e) {

        }

        return r;
    }

    @Override
    public int actualizar(Object[] o) {
        int r = 0;
        String sql = "UPDATE tab_mascota SET ID_CLIENTE=?,MASC_NOMBRE=?,MASC_FECHANAC=?,MASC_ESPECIE=?,MASC_RAZA=?,MASC_GENERO=?,MASC_COLOR=?,MASC_PELAJE=? WHERE ID_MASCOTA=?";

        try {
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

        } catch (Exception e) {

        }

        return r;
    }

    @Override
    public void eliminar(int id) {
        String sql = "DELETE FROM tab_mascota WHERE ID_MASCOTA=?";

        try {
            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (Exception e) {

        }
    }
    @Override
    public List buscarTodosID(int id){
     List<Mascota> lista = new ArrayList<>();
        String sql = "SELECT * FROM `tab_mascota` WHERE ID_CLIENTE ="+id;

        try {
            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
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

        } catch (Exception e) {

        }

        return lista;
    }
    
    @Override
    public Object listarID(int id) {
        Mascota m = new Mascota();
        String sql ="SELECT * FROM tab_mascota WHERE ID_MASCOTA=?";
        
        try{
            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            
            while(rs.next()){
                m.setId(rs.getInt(1));
                m.setIdCliente(rs.getInt(2));
                m.setNombre(rs.getString(3));
                m.setFechaNac(rs.getString(4));
                m.setEspecie(rs.getString(5));
                m.setRaza(rs.getString(6));
                m.setGenero(rs.getString(7));
                m.setColor(rs.getString(8));
                m.setPelaje(rs.getString(9));
                
            }
            
        }catch(Exception e){
        
        }
        return m;
    }

}
