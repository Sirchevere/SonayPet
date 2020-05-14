
package com.sonaypet.modelo.dao;

import com.sonaypet.modelo.entidades.Conexion;
import com.sonaypet.modelo.entidades.DetalleVentas;
import com.sonaypet.modelo.entidades.Venta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class VentasDAO {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r = 0;
    
    public String nroSerieVentas(){
        String serie = "";
        String sql = "SELECT max(numeroSerie) FROM ventas";
        try{
            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                serie = rs.getString(1);
            
            }
        }catch(Exception e){
        
        
        }
        
        return serie;
    }
    
    public String idVentas(){
        String idv = "";
        String sql ="SELECT max(idVentas) FROM ventas";
        try{
        con = cn.Conectar();
        ps = con.prepareStatement(sql);
        rs = ps.executeQuery();
        while(rs.next()){
            idv = rs.getString(1);
        }
        
        
        }catch (Exception e){
        
        
        }
    
        return idv;
        
    }
    
    public int guardarVentas (Venta v){
        Venta venta = new Venta();
        String sql = "INSERT INTO ventas(idCliente,idVendedor,numeroSerie,fechaVenta,monto)values(?,?,?,?,?)";
        try{
        con = cn.Conectar();
        ps = con.prepareStatement(sql);
        ps.setInt(1, v.getIdCliente());
        ps.setInt(2, v.getIdVendedor());
        ps.setString(3, v.getSerie());
        ps.setString(4, v.getFecha());
        ps.setDouble(5, v.getMonto());
        r = ps.executeUpdate();
        
        }catch(Exception e){
        
        }
            
        return r;
    
    }
    
    public int guardarDetalleVentas(DetalleVentas dv){
        String sql = "INSERT INTO detalleventas(idVentas,idProducto,cantidad,precioVenta)values(?,?,?,?)";
        try{
        con = cn.Conectar();
        ps = con.prepareStatement(sql);
        ps.setInt(1, dv.getIdVentas());
        ps.setInt(2, dv.getIdProducto());
        ps.setInt(3, dv.getCantidad());
        ps.setDouble(4, dv.getPrecio());
        ps.executeUpdate();
        
        }catch(Exception e){
        
        }
        
        return r;
    
    }
}
