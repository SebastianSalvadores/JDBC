/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estancias.persistencia;

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
    protected Connection conexion;
    protected Statement sentencia;
    protected ResultSet resultado;
    
    private final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private final String USERNAME = "root";
    private final String PASSWORD = "root";
    private final String DATABASE = "estancias_exterior";
    
    protected void conectarBase() throws SQLException, ClassNotFoundException{
        try {
            Class.forName(DRIVER);
            String url = "jdbc:mysql://localhost:3306/" + DATABASE;
            conexion = DriverManager.getConnection(url, USERNAME, PASSWORD);
        } catch (ClassNotFoundException | SQLException ex) {
            throw ex;
        }
    }
    
    public void desconectarBase() throws SQLException{
        try{
            if(conexion != null){
                conexion.close();
            }
            if(sentencia != null){
                sentencia.close();
            }
            if(resultado != null){
                resultado.close();
            }
        }catch(SQLException ex){
            throw ex;
        } 
    }
    
    public void insertarModificarEliminar(String sql) throws SQLException, ClassNotFoundException{
        try {
            conectarBase();
            sentencia = conexion.createStatement();
            sentencia.executeUpdate(sql);
        } catch (SQLException ex) {
            throw ex;
        } finally {
            desconectarBase();
        }
    }
    
    public void consultarBase(String sql) throws ClassNotFoundException, SQLException{
        try {
            conectarBase();
            sentencia = conexion.createStatement();
            resultado = sentencia.executeQuery(sql);
        } catch (ClassNotFoundException | SQLException ex) {
            throw ex;
        } 
    }
    
}
