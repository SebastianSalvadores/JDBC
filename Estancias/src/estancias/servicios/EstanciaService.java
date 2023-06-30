/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estancias.servicios;

import estancias.entidades.Casa;
import estancias.entidades.Cliente;
import estancias.entidades.Estancia;
import estancias.persistencia.EstanciaDAO;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Sebastian
 */
public class EstanciaService {
    private final EstanciaDAO dao;
    private final ClienteService clienteService;
    private final CasaService casaService;
    private final Scanner leer;

    public EstanciaService() {
        dao = new EstanciaDAO();
        clienteService = new ClienteService();
        casaService = new CasaService();
        leer = new Scanner(System.in).useDelimiter("\n");
    }
    
    public ArrayList<Estancia> listarE() throws Exception{
        try {
            ArrayList<Estancia> estancias = dao.listarE();
            return estancias;
        } catch (Exception e) {
            throw e;
        }
    }
    
    public ArrayList<Estancia> listarF() throws Exception{
        try {
            ArrayList<Estancia> estancias = dao.listarF();
            return estancias;
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void guardarEstancia(){
        try {
            Estancia estancia = new Estancia();
            System.out.println("Ingrese id del cliente que realiza la estancia:");
            int idCliente = leer.nextInt();
            Cliente cliente = clienteService.buscarClientePorId(idCliente);
            estancia.setCliente(cliente);
            
            System.out.println("Ingrese id de la casa a reservar:");
            int idCasa = leer.nextInt();
            Casa casa = casaService.buscarCasaPorId(idCasa);
            estancia.setCasa(casa);
            
            estancia.setNombreHuesped(estancia.getCliente().getNombre());
            
            System.out.println("Ingrese fecha a reservar:");
            System.out.println("Ingrese dia:");
            int dia = leer.nextInt();
            System.out.println("Ingrese mes:");
            int mes = leer.nextInt();
            System.out.println("Ingrese año:");
            int anio = leer.nextInt();
            LocalDate fecha = LocalDate.of(anio, mes, dia);
            LocalDate fechaDesde = estancia.getCasa().getFechaDesde();
            LocalDate fechaHasta = estancia.getCasa().getFechaHasta();
            
            if(fecha.isBefore(fechaDesde) || fecha.isAfter(fechaHasta)){
                throw new Exception("La fecha elegida no esta disponible en la casa seleccionada.");
            }
            estancia.setFechaDesde(fecha);
            System.out.println("Ingrese cantidad de dias:");
            int cantDias = leer.nextInt();
            int tiempoMinimo = estancia.getCasa().getTiempoMinimo();
            int tiempoMaximo = estancia.getCasa().getTiempoMaximo();
            if(tiempoMinimo > cantDias || tiempoMaximo < cantDias){
                throw new Exception("La cantidad de dias no esta disponible.");
            }
            LocalDate fecha2 = fecha.plusDays(cantDias);
            if(fecha2.isAfter(fechaHasta)){
                throw new Exception("La cantidad de dias supera la fecha de disponibilidad.");
            }
            estancia.setFechaHasta(fecha2);
            
            dao.guardarEstancia(estancia);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
