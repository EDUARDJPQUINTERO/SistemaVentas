package Modelo;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ClientesDAO {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r;
    
    public Clientes buscar(String dni){
        Clientes c=new Clientes();
        String sql="select * from cliente where Dni=?"+dni;
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                c.setIdCliente(rs.getInt(1));
                c.setDni(rs.getString(2));
                c.setNombres(rs.getString(1));
                c.setDireccion(rs.getString(1));
                c.setEstado(rs.getString(1));
            }
        } catch (Exception e){    
        }
        return c;
    }

    public List<Clientes> listar() {
    String sql = "select * from cliente"; // Se añadió un espacio antes de "from"
    List<Clientes> lista = new ArrayList<>();
    try {
        con = cn.Conexion();
        ps = con.prepareStatement(sql);
        rs = ps.executeQuery();
        while (rs.next()) {
            Clientes cliente = new Clientes();
            cliente.setIdCliente(rs.getInt("IdCliente"));
            cliente.setDni(rs.getString("Dni"));
            cliente.setNombres(rs.getString("Nombres"));
            cliente.setDireccion(rs.getString("Direccion"));
            cliente.setEstado(rs.getString("Estado"));
            lista.add(cliente);
        }
    } catch (Exception e) {
        // Manejo de excepciones
    }
    return lista;
}

    public int agregar(Clientes cliente) {
        String sql = "insert into cliente(Dni, Nombres, Direccion, Estado) VALUES (?, ?, ?, ?)";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, cliente.getDni());
            ps.setString(2, cliente.getNombres());
            ps.setString(3, cliente.getDireccion());
            ps.setString(4, cliente.getEstado());
            ps.executeUpdate();
        } catch (Exception e) {
            
        }
        return r;
    }

    public Clientes listarId(int idCliente) {
        Clientes cliente = new Clientes();
        String sql = "select * from cliente where IdCliente=?"+idCliente;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            //ps.setInt(1, idCliente);
            rs = ps.executeQuery();
            while (rs.next()) {
                //cliente.setIdCliente(rs.getInt("IdCliente"));
                cliente.setDni(rs.getString(2));
                cliente.setNombres(rs.getString(3));
                cliente.setDireccion(rs.getString(4));
                cliente.setEstado(rs.getString(5));
            }
        } catch (Exception e) {
           
        }
        return cliente;
    }

    public int actualizar(Clientes cliente) {
        String sql = "update cliente set Dni=?, Nombres=?, Direccion=?, Estado=? WHERE IdCliente=?";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, cliente.getDni());
            ps.setString(2, cliente.getNombres());
            ps.setString(3, cliente.getDireccion());
            ps.setString(4, cliente.getEstado());
            ps.setInt(5, cliente.getIdCliente());
            ps.executeUpdate();
        } catch (Exception e) {
          
        }
        return r;
    }

    public void eliminar(int idCliente) {
        String sql = "delete from cliente where IdCliente=?"+idCliente;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            //ps.setInt(1, idCliente);
            ps.executeUpdate();
        } catch (Exception e) {
       
        }
    }
}
