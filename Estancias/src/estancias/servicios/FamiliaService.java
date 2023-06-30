/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estancias.servicios;

import estancias.entidades.Familia;
import estancias.persistencia.FamiliaDAO;
import java.util.ArrayList;

/**
 *
 * @author Sebastian
 */
public class FamiliaService {
    private final FamiliaDAO dao;

    public FamiliaService() {
        this.dao = new FamiliaDAO();
    }
   
    public ArrayList<Familia> listarA() throws Exception{
        try {
            ArrayList<Familia> familias = dao.listarA();
            return familias;
        } catch (Exception e) {
            throw e;
        }
    }
    
    public ArrayList<Familia> listarC() throws Exception{
        try {
            ArrayList<Familia> familias = dao.listarC();
            return familias;
        } catch (Exception e) {
            throw e;
        }
    }
}
