/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProductoDAO {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r;
    
    public Producto buscar(int id){
        Producto p=new Producto();
        String sql="select * from producto where idproducto="+id;
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                p.setId(rs.getInt(1));
                p.setNombre(rs.getString(2));
                p.setPrecio(rs.getDouble(3));
                p.setStock(rs.getInt(4));
                p.setEstado(rs.getString(5));
            }
        }catch (Exception e){
        }
        return p;
    }
    public int actualizarstock(int id,int stock){
        String sql="update producto set Stock=? where idproducto=?";
        try{
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.setInt(1, stock);
            ps.setInt(2, id);
            ps.executeUpdate();
        }catch(Exception e){ 
        }
        return r;
    }

    public List<Producto> listar() {
        String sql = "select * from producto";
        List<Producto> lista = new ArrayList<>();
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Producto prod = new Producto();
                prod.setId(rs.getInt("IdProducto"));
                prod.setNombre(rs.getString("Nombres"));
                prod.setPrecio(rs.getDouble("Precio"));
                prod.setStock(rs.getInt("Stock"));
                prod.setEstado(rs.getString("Estado"));
                lista.add(prod);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }

   public int agregar(Producto producto){
    String sql = "INSERT INTO producto(Nombres, Precio, Stock, Estado) VALUES (?, ?, ?, ?)";
    try {
        con = cn.Conexion();
        ps = con.prepareStatement(sql);
        ps.setString(1, producto.getNombre());
        ps.setDouble(2, producto.getPrecio());
        ps.setInt(3, producto.getStock());
        ps.setString(4, producto.getEstado());
        ps.executeUpdate();
    } catch (Exception e){
        // Manejar la excepción apropiadamente
    }
    return r;
}

public Producto listarId(int idProducto){
    Producto producto = new Producto();
    String sql = "SELECT * FROM producto WHERE IdProducto = ?";
    try {
        con = cn.Conexion();
        ps = con.prepareStatement(sql);
        ps.setInt(1, idProducto);
        rs = ps.executeQuery();
        while(rs.next()){
            producto.setId(rs.getInt("IdProducto"));
            producto.setNombre(rs.getString("Nombres"));
            producto.setPrecio(rs.getDouble("Precio"));
            producto.setStock(rs.getInt("Stock"));
            producto.setEstado(rs.getString("Estado"));
        }
    } catch (Exception e){
        // Manejar la excepción apropiadamente
    }
    return producto;
}

public int actualizar(Producto producto){
    String sql = "UPDATE producto SET Nombres=?, Precio=?, Stock=?, Estado=? WHERE IdProducto=?";
    try{
        con = cn.Conexion();
        ps = con.prepareStatement(sql);
        ps.setString(1, producto.getNombre());
        ps.setDouble(2, producto.getPrecio());
        ps.setInt(3, producto.getStock());
        ps.setString(4, producto.getEstado());
        ps.setInt(5, producto.getId());
        ps.executeUpdate();
    } catch (Exception e){
        // Manejar la excepción apropiadamente
    }
    return r;
}

public void eliminar(int idProducto){
    String sql = "DELETE FROM producto WHERE IdProducto=?";
    try {
        con = cn.Conexion();
        ps = con.prepareStatement(sql);
        ps.setInt(1, idProducto);
        ps.executeUpdate();
    } catch (Exception e){
        // Manejar la excepción apropiadamente
    }
}

}

