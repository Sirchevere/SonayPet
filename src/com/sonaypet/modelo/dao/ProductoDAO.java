
package com.sonaypet.modelo.dao;

import com.sonaypet.modelo.entidades.CRUD;
import com.sonaypet.modelo.entidades.Producto;
import com.sonaypet.modelo.entidades.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class ProductoDAO implements CRUD {
    int r;
    Connection con;
    Conexion cn = new Conexion();
    PreparedStatement ps;
    ResultSet rs;
    
    public int actualizarStock(int cant, int idp){
        String sql = "UPDATE producto set stock=? WHERE idProducto=?";
        try{
            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(1, cant);
            ps.setInt(2, idp);
            ps.executeUpdate();
        
        }catch(Exception e){
            
        
        }
    
        return r;
    }
    
    public Producto listarID(int id){
        Producto p = new Producto();
        String sql = "SELECT * FROM producto WHERE idProducto=?";
        try{
            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while(rs.next()){
                p.setId(rs.getInt(1));
                p.setNom(rs.getString(2));
                p.setPrecio(rs.getDouble(3));
                p.setStock(rs.getInt(4));
                
            }
            
        }catch(Exception e){
        
        }
        return p;
    }

    @Override
    public List listar() {
         List<Producto> lista = new ArrayList<>();
        String sql = "SELECT * FROM producto";
        
        try{
        con = cn.Conectar();
        ps = con.prepareStatement(sql);
        rs = ps.executeQuery();
        
        while(rs.next()){
        Producto p = new Producto();
        p.setId(rs.getInt(1));
        p.setNom(rs.getString(2));
        p.setPrecio(rs.getDouble(3));
        p.setStock(rs.getInt(4));
        lista.add(p);
        }
        
        } catch(Exception e){
        
        }
        
        return lista;
    }

    @Override
    public int agregar(Object[] o) {
        
       int r = 0;
       String sql = "INSERT INTO producto(nombre,precio,stock)values(?,?,?)";
       
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
        String sql = "UPDATE producto SET nombre=?,precio=?,stock=? WHERE idProducto=?";
        
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
        
         String sql="DELETE FROM producto WHERE idProducto=?";
        
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
    
}
