/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estancias.persistencia;

import estancias.entidades.Casa;
import estancias.entidades.Cliente;
import estancias.entidades.Estancia;
import estancias.servicios.CasaService;
import estancias.servicios.ClienteService;
import java.util.ArrayList;

/**
 *
 * @author Sebastian
 */
public class EstanciaDAO extends DAO{
    private final ClienteService clienteService;
    private final CasaService casaService;

    public EstanciaDAO() {
        clienteService = new ClienteService();
        casaService = new CasaService();
    }
    
    public void guardarEstancia(Estancia estancia) throws Exception {
        try {
            if (estancia == null) {
                throw new Exception("Debe indicar una estancia.");
            }
            String sql = "INSERT INTO estancias(id_cliente, id_casa, nombre_huesped, fecha_desde, fecha_hasta) "
                    + "VALUES (" + estancia.getCliente().getIdCliente() + ", " + estancia.getCasa().getIdCasa() + ", '" + estancia.getNombreHuesped() + "', '" + estancia.getFechaDesde() + "', '" + estancia.getFechaHasta() + "')";
            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        } finally {
            desconectarBase();
        }
    }
    
    public ArrayList<Estancia> listarE() throws Exception{
        try {
            String sql = "SELECT id_cliente, id_casa FROM estancias";
            consultarBase(sql);
            ArrayList<Estancia> estancias = new ArrayList();
            Estancia estancia = null;
            
            while(resultado.next()){
                estancia = new Estancia();
                
                Integer idCliente = resultado.getInt(1);
                Cliente cliente = clienteService.buscarClientePorId(idCliente);
                estancia.setCliente(cliente);
                
                Integer idCasa = resultado.getInt(2);
                Casa casa = casaService.buscarCasaPorId(idCasa);
                estancia.setCasa(casa);
                
                estancias.add(estancia);
            }
            desconectarBase();
            return estancias;
        } catch (Exception e) {
            throw e;
        }
    }
    
    public ArrayList<Estancia> listarF() throws Exception{
        try {
            String sql = "SELECT * FROM estancias";
            consultarBase(sql);
            
            ArrayList<Estancia> estancias = new ArrayList();
            Estancia estancia = null;
            
            while(resultado.next()){
                estancia = new Estancia();
                estancia.setIdEstancia(resultado.getInt(1));
                Integer idCliente = resultado.getInt(2);
                Cliente cliente = clienteService.buscarClientePorId(idCliente);
                estancia.setCliente(cliente);
                Integer idCasa = resultado.getInt(3);
                Casa casa = casaService.buscarCasaPorId(idCasa);
                estancia.setCasa(casa);
                estancia.setNombreHuesped(resultado.getString(4));
                estancia.setFechaDesde(resultado.getDate(5).toLocalDate());
                estancia.setFechaHasta(resultado.getDate(6).toLocalDate());
                estancias.add(estancia);
            }
            desconectarBase();
            return estancias;
        } catch (Exception e) {
            throw e;
        }
    }
}
