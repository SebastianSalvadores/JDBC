/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testconexiona;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Sebastian
 */
public class TestConexionA {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Connection connection;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/pokemondb";
            connection = DriverManager.getConnection(url, "root", "root");
        } catch (SQLException ex) {
            connection = null;
            ex.printStackTrace();
            System.out.println("SQLException: " + ex.getMessage());
        }
        String sql = "SELECT numero_pokedex, nombre FROM pokemon";
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        while(rs.next()){
            int pokedex = rs.getInt("numero_pokedex");
            String nombrePokemon = rs.getString("NOMBRE");
            System.out.println(pokedex + " " + nombrePokemon);
        }
        
        
    }
    
}
