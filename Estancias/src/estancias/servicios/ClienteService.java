/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estancias.servicios;

import estancias.entidades.Cliente;
import estancias.persistencia.ClienteDAO;

/**
 *
 * @author Sebastian
 */
public class ClienteService {
    private final ClienteDAO dao;

    public ClienteService() {
        dao = new ClienteDAO();
    }
    
    public Cliente buscarClientePorId(Integer id) throws Exception{
        try {
            if(id == null){
                throw new Exception("Debe indicar un id para cliente");
            }
            Cliente cliente = dao.buscarClientePorId(id);
            return cliente;
        } catch (Exception e) {
            throw e;
        }
    }
    
}
