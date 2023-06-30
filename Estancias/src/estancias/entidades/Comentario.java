/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estancias.entidades;

/**
 *
 * @author Sebastian
 */
public class Comentario {
    private int idComentario;
    private Casa casa;
    private String comentario;

    public Comentario() {
    }

    public Comentario(int idComentario, Casa casa, String comentario) {
        this.idComentario = idComentario;
        this.casa = casa;
        this.comentario = comentario;
    }

    public int getIdComentario() {
        return idComentario;
    }

    public void setIdComentario(int idComentario) {
        this.idComentario = idComentario;
    }

    public Casa getCasa() {
        return casa;
    }

    public void setCasa(Casa casa) {
        this.casa = casa;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    @Override
    public String toString() {
        return "Comentario{" + "idComentario=" + idComentario + ", comentario=" + comentario + "} " + casa ;
    }

    
    
}
