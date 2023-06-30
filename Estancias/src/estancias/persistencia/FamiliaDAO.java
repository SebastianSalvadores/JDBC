/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estancias.persistencia;

import estancias.entidades.Casa;
import estancias.entidades.Familia;
import estancias.servicios.CasaService;
import java.util.ArrayList;

/**
 *
 * @author Sebastian
 */
public class FamiliaDAO extends DAO{
    
    private final CasaService casaService;

    public FamiliaDAO() {
        casaService = new CasaService();
    }
    
    
    
    public ArrayList<Familia> listarA() throws Exception{
        try {
            String sql = "SELECT * FROM familias WHERE num_hijos >= 3 AND edad_maxima < 10";
            
            consultarBase(sql);
            
            ArrayList<Familia> familias = new ArrayList();
            Familia familia = null;
            while(resultado.next()){
                familia = new Familia();
                familia.setIdFamilia(resultado.getInt(1));
                familia.setNombre(resultado.getString(2));
                familia.setEdadMinima(resultado.getInt(3));
                familia.setEdadMaxima(resultado.getInt(4));
                familia.setNumHijos(resultado.getInt(5));
                familia.setEmail(resultado.getString(6));
                Integer idCasa = resultado.getInt(7);
                Casa casa = casaService.buscarCasaPorId(idCasa);
                familia.setCasaFamilia(casa);
                familias.add(familia);
            }
            desconectarBase();
            return familias;
        } catch (Exception e) {
            throw e;
        }
    }
    
    public ArrayList<Familia> listarC() throws Exception{
        try {
            String sql = "SELECT * FROM familias WHERE email LIKE '%@hotmail.com%'";
            consultarBase(sql);
            
            ArrayList<Familia> familias = new ArrayList();
            Familia familia = null;
            
            while(resultado.next()){
                familia = new Familia();
                familia.setIdFamilia(resultado.getInt(1));
                familia.setNombre(resultado.getString(2));
                familia.setEdadMinima(resultado.getInt(3));
                familia.setEdadMaxima(resultado.getInt(4));
                familia.setNumHijos(resultado.getInt(5));
                familia.setEmail(resultado.getString(6));
                Integer idCasa = resultado.getInt(7);
                Casa casa = casaService.buscarCasaPorId(idCasa);
                familia.setCasaFamilia(casa);
                familias.add(familia);
            }
            desconectarBase();
            return familias;
        } catch (Exception e) {
            throw e;
        }
    }
}
