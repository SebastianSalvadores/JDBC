/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tienda.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Sebastian
 */
public abstract class DAO {
    //Los atributos para realizar la conexion, realizar consultas, modificar. heredados por sus clases hijas
    protected Connection conexion;
    protected Statement sentencia;
    protected ResultSet resultado;
    //Constantes para conectarse a la bbdd tienda
    private final String USER = "root";
    private final String PASSWORD = "root";
    private final String DATABASE = "tienda";
    private final String DRIVER = "com.mysql.cj.jdbc.Driver";
    
    protected void conectarBase() {
        try {
            Class.forName(DRIVER);
            String url = "jdbc:mysql://localhost:3306/" + DATABASE;
            conexion = DriverManager.getConnection(url, USER, PASSWORD);
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    protected void desconectarBase() {
        try {
            if(conexion != null){
                conexion.close();
            }
            if(sentencia != null){
                sentencia.close();
            }
            if(resultado != null){
                resultado.close();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    protected void insertarModificarEliminar(String sql){
        try {
            conectarBase();
            sentencia = conexion.createStatement();
            sentencia.executeUpdate(sql);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }finally{
            desconectarBase();
        }
    }
    
    protected void consultarBase(String sql){
        try {
            conectarBase();
            sentencia = conexion.createStatement();
            resultado = sentencia.executeQuery(sql);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
    }
    
}
