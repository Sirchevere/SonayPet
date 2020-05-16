
package com.sonaypet.modelo.dao;

import com.sonaypet.modelo.entidades.CRUD;
import com.sonaypet.modelo.entidades.ClienteInventario;
import com.sonaypet.modelo.entidades.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class ClienteInventarioDAO implements CRUD{
    Connection con;
    Conexion cn = new Conexion();
    PreparedStatement ps;
    ResultSet rs;

    @Override
    public List listar() {
        List<ClienteInventario> lista = new ArrayList<>();
        String sql = "SELECT * FROM cliente";
        
        try{
        con = cn.Conectar();
        ps = con.prepareStatement(sql);
        rs = ps.executeQuery();
        
        while(rs.next()){
        ClienteInventario c = new ClienteInventario();
        c.setId(rs.getInt(1));
        c.setDni(rs.getString(2));
        c.setNom(rs.getString(3));
        c.setDirec(rs.getString(4));
        lista.add(c);
        }
        
        } catch(Exception e){
        
        }
        
        return lista;
    
    }

    
    
    public ClienteInventario listarID(String dni){
        ClienteInventario c = new ClienteInventario();
        String sql ="SELECT * FROM cliente WHERE dni=?";
        
        try{
            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, dni);
            rs = ps.executeQuery();
            
            while(rs.next()){
                c.setId(rs.getInt(1));
                c.setDni(rs.getString(2));
                c.setNom(rs.getString(3));
                c.setDirec(rs.getString(4));
                
            }
            
        }catch(Exception e){
        
        }
        return c;
    }
    
    
    @Override
    public int agregar(Object[] o) {
        
       int r = 0;
       String sql = "INSERT INTO cliente(dni,nombres,direccion)values(?,?,?)";
       
       try{
           con = cn.Conectar();
           ps = con.prepareStatement(sql);
           ps.setObject(1, o[0]);
           ps.setObject(2, o[1]);
           ps.setObject(3, o[2]);
           r = ps.executeUpdate();
           
       }catch(Exception e){
       
       }
       
       return r;
    }

    @Override
    public int actualizar(Object[] o) {
        int r = 0;
        String sql = "UPDATE cliente SET dni=?,nombres=?,direccion=? WHERE idCliente=?";
        
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
    public void eliminar(int id) {
        
        String sql="DELETE FROM cliente WHERE idCliente=?";
        
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
    public List listarID(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List buscarTodosID(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
