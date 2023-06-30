/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estancias.persistencia;

import estancias.entidades.Casa;
import estancias.entidades.Comentario;
import estancias.servicios.CasaService;
import java.util.ArrayList;

/**
 *
 * @author Sebastian
 */
public class ComentarioDAO extends DAO{
    private final CasaService casaService;

    public ComentarioDAO() {
        casaService = new CasaService();
    }
    
    
    public ArrayList<Comentario> listarI() throws Exception{
        try {
            String sql = "SELECT * FROM comentarios WHERE comentario LIKE '%limpia%'";
            consultarBase(sql);
            ArrayList<Comentario> comentarios = new ArrayList();
            Comentario comentario = null;
            while(resultado.next()){
                comentario = new Comentario();
                comentario.setIdComentario(resultado.getInt(1));
                Integer idCasa = resultado.getInt(2);
                Casa casa = casaService.buscarCasaPorId(idCasa);
                comentario.setCasa(casa);
                comentario.setComentario(resultado.getString(3));
                comentarios.add(comentario);
            }
            desconectarBase();
            return comentarios;
        } catch (Exception e) {
            throw e;
        }
    }
            
            
}
