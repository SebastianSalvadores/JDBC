/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estancias.persistencia;

import estancias.entidades.Cliente;

/**
 *
 * @author Sebastian
 */
public class ClienteDAO extends DAO{
    public Cliente buscarClientePorId(int id) throws Exception{
        try {
            String sql = "SELECT * FROM clientes WHERE id_cliente = " + id;
            consultarBase(sql);
            Cliente cliente = null;
            
            while(resultado.next()){
                cliente = new Cliente();
                cliente.setIdCliente(resultado.getInt(1));
                cliente.setNombre(resultado.getString(2));
                cliente.setCalle(resultado.getString(3));
                cliente.setNumero(resultado.getInt(4));
                cliente.setCodigoPostal(resultado.getString(5));
                cliente.setCiudad(resultado.getString(6));
                cliente.setPais(resultado.getString(7));
                cliente.setEmail(resultado.getString(8));
            }
            desconectarBase();
            return cliente;
        } catch (Exception e) {
            throw e;
        }
    }
}
