/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tienda.persistencia;

import tienda.entidades.Fabricante;

/**
 *
 * @author Sebastian
 */
public final class FabricanteDAO extends DAO{
    public void guardarFabricante(Fabricante fabricante) throws Exception{
        try {
            if(fabricante == null){
                throw new Exception("Debe indicar un fabricante.");
            }
            String sql = "INSERT INTO fabricante (nombre) VALUES ('" + fabricante.getNombre() + "');";
            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        } finally{
            desconectarBase();
        }
    }
    
    public void eliminarFabricante(String nombre) throws Exception{
        try {
            if(nombre == null || nombre.trim().isEmpty()){
                throw new Exception("Debe indicar un nombre de fabricante");
            }
            String sql = "DELETE FROM fabricante WHERE nombre = '" + nombre + "';";
            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        } finally {
            desconectarBase();
        }
    }
}
