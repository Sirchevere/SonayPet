/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sonaypet.modelo.dao;

import com.sonaypet.modelo.entidades.CRUD;
import com.sonaypet.modelo.entidades.ClienteVeterinaria;
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
public class ClienteVeterinariaDAO implements CRUD {

    Connection con;
    Conexion cn = new Conexion();
    PreparedStatement ps;
    ResultSet rs;
    
    @Override
    public List listar() {
        List<ClienteVeterinaria> lista = new ArrayList<>();
        String sql = "SELECT * FROM tab_cliente";
        
        try{
        con = cn.Conectar();
        ps = con.prepareStatement(sql);
        rs = ps.executeQuery();
        
        while(rs.next()){
        ClienteVeterinaria c = new ClienteVeterinaria();
        c.setId(rs.getInt(1));
        c.setNombre(rs.getString(2));
        c.setApellido(rs.getString(3));
        c.setFechaNac(rs.getString(4));
        c.setDireccion(rs.getString(5));
        c.setTelefono(rs.getString(6));
        c.setGenero(rs.getString(7));
        c.setEmail(rs.getString(8));
        c.setPass(rs.getString(9));
        lista.add(c);
        }
        
        } catch(Exception e){
        
        }
        
        return lista;
    }
    
        public ClienteVeterinaria listarID(int id){
        ClienteVeterinaria c = new ClienteVeterinaria();
        String sql ="SELECT * FROM tab_cliente WHERE ID_CLIENTE=?";
        
        try{
            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            
            while(rs.next()){
                c.setId(rs.getInt(1));
                c.setNombre(rs.getString(2));
                c.setApellido(rs.getString(3));
                c.setFechaNac(rs.getString(4));
                c.setDireccion(rs.getString(5));
                c.setTelefono(rs.getString(6));
                c.setGenero(rs.getString(7));
                c.setEmail(rs.getString(8));
                c.setPass(rs.getString(9));
                
            }
            
        }catch(Exception e){
        
        }
        return c;
    }
     
      public ClienteVeterinaria ValidarCliente(String pass,String email){
            ClienteVeterinaria cv = new ClienteVeterinaria();
            String sql = "SELECT * FROM tab_cliente WHERE AES_DECRYPT(pass,'4E5Yv<Pz%FN&')=? and email=?";
            try{
            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, pass);
            ps.setString(2, email);
            rs = ps.executeQuery();
            while(rs.next()){
                cv.setId(rs.getInt(1));
                cv.setNombre(rs.getString(2));
                cv.setApellido(rs.getString(3));
                cv.setFechaNac(rs.getString(4));
                cv.setDireccion(rs.getString(5));
                cv.setTelefono(rs.getString(6));
                cv.setGenero(rs.getString(7));
                cv.setEmail(rs.getString(8));
                cv.setPass(rs.getString(9));
            
            }
            
            } catch(Exception e){
            
            }
        
            return cv;
        }

    @Override
    public int agregar(Object[] o) {
       int r = 0;
       String sql = "INSERT INTO tab_cliente(CLI_NOMBRES,CLI_APELLIDOS,CLI_FECHANAC,CLI_DIRECCION,CLI_TELEFONO,CLI_GENERO,CLI_EMAIL,CLI_PASS)values(?,?,?,?,?,?,?,AES_ENCRYPT(?,'4E5Yv<Pz%FN&'))";
       
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
        String sql = "UPDATE tab_cliente SET CLI_NOMBRES=?,CLI_APELLIDOS=?,CLI_FECHANAC=?,CLI_DIRECCION=?,CLI_TELEFONO=?,CLI_GENERO=?,CLI_EMAIL=?,CLI_PASS=AES_ENCRYPT(?,'4E5Yv<Pz%FN&') WHERE ID_CLIENTE=?";
        
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
        String sql="DELETE FROM tab_cliente WHERE ID_CLIENTE=?";
        
        try{
            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        
        }catch(Exception e){
        
        }
    }

    @Override
    public List custom(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List buscarTodosID(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List custom2() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
