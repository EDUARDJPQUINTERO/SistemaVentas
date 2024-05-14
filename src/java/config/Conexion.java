/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package config;
//clase java
import java.sql.Connection;
import java.sql.DriverManager;
/**
 *
 * @author danie
 */
public class Conexion {
    Connection con; //Variable crear para conexion
    String url="jdbc:mysql://localhost/bd_ventas";
    String user="root";
    String pass="";
    public Connection Conexion(){ //Creamos metodo que retorne la variable con
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection(url,user,pass);
        }catch(Exception e){
        }
        return con;
    }
}
