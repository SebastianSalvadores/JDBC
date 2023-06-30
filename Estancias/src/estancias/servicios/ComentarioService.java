/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estancias.servicios;

import estancias.entidades.Comentario;
import estancias.persistencia.ComentarioDAO;
import java.util.ArrayList;

/**
 *
 * @author Sebastian
 */
public class ComentarioService {
    private final ComentarioDAO dao;

    public ComentarioService() {
        dao = new ComentarioDAO();
    }
    
    public ArrayList<Comentario> listarI() throws Exception{
        try {
            ArrayList<Comentario> comentarios = dao.listarI();
            return comentarios;
        } catch (Exception e) {
            throw e;
        }
    }
    
}
