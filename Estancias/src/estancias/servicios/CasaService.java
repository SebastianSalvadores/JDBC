/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estancias.servicios;

import estancias.entidades.Casa;
import estancias.persistencia.CasaDAO;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author Sebastian
 */
public class CasaService {
    private CasaDAO dao;

    public CasaService() {
        dao = new CasaDAO();
    }
    
    
    public Casa buscarCasaPorId(Integer id) throws Exception{
        try {
            if (id == null){
                throw new Exception("debe indicar un Id para Casa");
            }
            Casa casa = dao.buscarCasaPorId(id);
            return casa;
        } catch (Exception e) {
            throw e;
        }
    }
    
    public ArrayList<Casa> listarB() throws Exception{
        try {
            ArrayList<Casa> casas = dao.listarB();
            return casas;
        } catch (Exception e) {
            throw e;
        }
    }
    
    public ArrayList<Casa> listarD(LocalDate fecha, int dias) throws Exception{
        try {
            ArrayList<Casa> casas = dao.listarD(fecha, dias);
            return casas;
        } catch (Exception e) {
            throw e;
        }
    }
    
    public ArrayList<Casa> listarCasasUK() throws Exception{
        try {
            ArrayList<Casa> casas = dao.listarCasasUK();
            return casas;
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void modificarPrecios(){
        try {
            ArrayList<Casa> casas = listarCasasUK();
            for (Casa casa : casas) {
                double precio = casa.getPrecioHabitacion();
                precio += precio * 0.5;
                casa.setPrecioHabitacion(precio);
                dao.modificarPrecio(casa);
            }
        } catch (Exception e) {
        }
    }
    
    public void contarCasasPorPais() throws Exception{
        try {
            dao.contarCasasPorPais();
        } catch (Exception e) {
            throw e;
        }
    }
}
