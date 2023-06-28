/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tienda.servicios;

import java.util.Scanner;
import tienda.entidades.Fabricante;
import tienda.persistencia.FabricanteDAO;

/**
 *
 * @author Sebastian
 */
public class FabricanteService {
    private FabricanteDAO dao;
    private Scanner leer;

    public FabricanteService() {
        dao = new FabricanteDAO();
        leer = new Scanner(System.in).useDelimiter("\n");
    }
    
    public void crearFabricante() throws Exception{
        System.out.println("Ingrese el nombre del fabricante:");
        String nombre = leer.next();
        
        try {
            if(nombre == null || nombre.trim().isEmpty()){
                throw new Exception("Debe ingresar un nombre de fabricante.");
            }
            
            Fabricante fabricante = new Fabricante();
            fabricante.setNombre(nombre);
            dao.guardarFabricante(fabricante);
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void eliminarFabricante(String nombre) throws Exception{
        try{
            if(nombre == null || nombre.trim().isEmpty()){
                throw new Exception("Debe ingresar nombre de fabricante a eliminar.");
            }
            dao.eliminarFabricante(nombre);
        }catch(Exception e){
            throw e;
        }
    }
}
