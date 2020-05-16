
package com.sonaypet.modelo.dao;
import com.sonaypet.modelo.entidades.CRUD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.sonaypet.modelo.entidades.Vendedor;
import com.sonaypet.modelo.entidades.Conexion;
import java.util.ArrayList;
import java.util.List;



public class VendedorDAO implements CRUD {
    PreparedStatement ps;
    ResultSet rs;
    Conexion cn = new Conexion();
    Connection con;
    
        public Vendedor ValidarVendedor(String dni,String usuario){
            Vendedor v = new Vendedor();
            String sql = "SELECT * FROM vendedor WHERE AES_DECRYPT(dni,'4E5Yv<Pz%FN&')=? and usuario=?";
            try{
            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, dni);
            ps.setString(2, usuario);
            rs = ps.executeQuery();
            while(rs.next()){
            v.setId(rs.getInt(1));
            v.setNom(rs.getString(2));
            v.setTel(rs.getString(3));
            v.setUsuario(rs.getString(4));
            v.setDni(rs.getString(5));
            
            }
            
            } catch(Exception e){
            
            }
        
            return v;
        }

    @Override
    public List listar() {
        
       List<Vendedor> lista = new ArrayList<>();
        String sql = "SELECT * FROM vendedor";
        
        try{
        con = cn.Conectar();
        ps = con.prepareStatement(sql);
        rs = ps.executeQuery();
        
        while(rs.next()){
        Vendedor v = new Vendedor();
        v.setId(rs.getInt(1));
        v.setNom(rs.getString(2));
        v.setTel(rs.getString(3));
        v.setUsuario(rs.getString(4));
        v.setDni(rs.getString(5));
        lista.add(v);
        }
        
        } catch(Exception e){
        
        }
        
        return lista;
    }

    @Override
    public int agregar(Object[] o) {
       
        int r = 0;
       String sql = "INSERT INTO vendedor(nombre,telefono,usuario,dni)values(?,?,?,AES_ENCRYPT(?,'4E5Yv<Pz%FN&'))";
       
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
        String sql = "UPDATE vendedor SET nombre=?,telefono=?,usuario=?,dni=AES_ENCRYPT(?,'4E5Yv<Pz%FN&') WHERE idVendedor=?";
        
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
        
          String sql="DELETE FROM vendedor WHERE idVendedor=?";
        
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
    public Object listarID(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List buscarTodosID(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
