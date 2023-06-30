/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estancias.persistencia;

import estancias.entidades.Casa;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author Sebastian
 */
public class CasaDAO extends DAO{
    public Casa buscarCasaPorId(int id) throws Exception{
        try {
            
            String sql = "SELECT * FROM casas WHERE id_casa = " + id;
            consultarBase(sql);
            Casa casa = null;
            while(resultado.next()){
                casa = new Casa();
                casa.setIdCasa(resultado.getInt(1));
                casa.setCalle(resultado.getString(2));
                casa.setNumero(resultado.getInt(3));
                casa.setCodigoPostal(resultado.getString(4));
                casa.setCiudad(resultado.getString(5));
                casa.setPais(resultado.getString(6));
                casa.setFechaDesde(resultado.getDate(7).toLocalDate());
                casa.setFechaHasta(resultado.getDate(8).toLocalDate());
                casa.setTiempoMinimo(resultado.getInt(9));
                casa.setTiempoMaximo(resultado.getInt(10));
                casa.setPrecioHabitacion(resultado.getDouble(11));
                casa.setTipoVivienda(resultado.getString(12));
            }
            desconectarBase();
            return casa;
        } catch (Exception e) {
            throw e;
        }
    }
    
    public ArrayList<Casa> listarB() throws Exception{
        try {
            String sql = "SELECT * FROM casas WHERE fecha_desde >= '2020-08-01' AND fecha_hasta <= '2020-08-31'";
            consultarBase(sql);
            ArrayList<Casa> casas = new ArrayList();
            Casa casa = null;
            
            while(resultado.next()){
                casa = new Casa();
                casa.setIdCasa(resultado.getInt(1));
                casa.setCalle(resultado.getString(2));
                casa.setNumero(resultado.getInt(3));
                casa.setCodigoPostal(resultado.getString(4));
                casa.setCiudad(resultado.getString(5));
                casa.setPais(resultado.getString(6));
                casa.setFechaDesde(resultado.getDate(7).toLocalDate());
                casa.setFechaHasta(resultado.getDate(8).toLocalDate());
                casa.setTiempoMinimo(resultado.getInt(9));
                casa.setTiempoMaximo(resultado.getInt(10));
                casa.setPrecioHabitacion(resultado.getDouble(11));
                casa.setTipoVivienda(resultado.getString(12));
                casas.add(casa);
            }
            desconectarBase();
            return casas;
        } catch (Exception e) {
            throw e;
        }
    }
    
    public ArrayList<Casa> listarD(LocalDate fecha, int dias) throws Exception{
        try {
            String sql = "SELECT * FROM casas WHERE fecha_desde <= '" + fecha + "' AND fecha_hasta >= '" + fecha + "' AND tiempo_minimo <= " + dias + " AND tiempo_maximo >= " + dias + " AND '" + fecha.plusDays(dias) + "' <= fecha_hasta";
            consultarBase(sql);
            ArrayList<Casa> casas = new ArrayList();
            Casa casa = null;
            
            while(resultado.next()){
                casa = new Casa();
                casa.setIdCasa(resultado.getInt(1));
                casa.setCalle(resultado.getString(2));
                casa.setNumero(resultado.getInt(3));
                casa.setCodigoPostal(resultado.getString(4));
                casa.setCiudad(resultado.getString(5));
                casa.setPais(resultado.getString(6));
                casa.setFechaDesde(resultado.getDate(7).toLocalDate());
                casa.setFechaHasta(resultado.getDate(8).toLocalDate());
                casa.setTiempoMinimo(resultado.getInt(9));
                casa.setTiempoMaximo(resultado.getInt(10));
                casa.setPrecioHabitacion(resultado.getDouble(11));
                casa.setTipoVivienda(resultado.getString(12));
                casas.add(casa);
            }
            desconectarBase();
            return casas;
        } catch (Exception e) {
            throw e;
        }
    }
    
    public ArrayList<Casa> listarCasasUK() throws Exception{
        try {
            String sql = "SELECT * FROM casas WHERE pais = 'reino unido'";
            consultarBase(sql);
            ArrayList<Casa> casas = new ArrayList();
            Casa casa = null;
            
            while(resultado.next()){
                casa = new Casa();
                casa.setIdCasa(resultado.getInt(1));
                casa.setCalle(resultado.getString(2));
                casa.setNumero(resultado.getInt(3));
                casa.setCodigoPostal(resultado.getString(4));
                casa.setCiudad(resultado.getString(5));
                casa.setPais(resultado.getString(6));
                casa.setFechaDesde(resultado.getDate(7).toLocalDate());
                casa.setFechaHasta(resultado.getDate(8).toLocalDate());
                casa.setTiempoMinimo(resultado.getInt(9));
                casa.setTiempoMaximo(resultado.getInt(10));
                casa.setPrecioHabitacion(resultado.getDouble(11));
                casa.setTipoVivienda(resultado.getString(12));
                casas.add(casa);
            }
            desconectarBase();
            return casas;
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void modificarPrecio(Casa casa) throws Exception{
        try {
            if(casa == null){
                throw new Exception("debe indicar una casa");
            }
            String sql = "UPDATE casas SET precio_habitacion = " + casa.getPrecioHabitacion() + " WHERE id_casa = " + casa.getIdCasa();
            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        } finally {
            desconectarBase();
        }
    }
    
    public void contarCasasPorPais() throws Exception{
        try {
            String sql = "SELECT COUNT(id_casa), pais FROM casas GROUP BY pais";
            consultarBase(sql);
            while(resultado.next()){
                System.out.println("Pais: " + resultado.getString(2) + ", cantidad: " + resultado.getInt(1));
            }
            desconectarBase();
        } catch (Exception e) {
            throw e;
        }
    }
}
