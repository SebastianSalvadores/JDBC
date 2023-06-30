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
public class Familia {
    private int idFamilia;
    private String nombre;
    private int edadMinima;
    private int edadMaxima;
    private int numHijos;
    private String email;
    private Casa casaFamilia;

    public Familia() {
    }

    public Familia(int idFamilia, String nombre, int edadMinima, int edadMaxima, int numHijos, String email, Casa casaFamilia) {
        this.idFamilia = idFamilia;
        this.nombre = nombre;
        this.edadMinima = edadMinima;
        this.edadMaxima = edadMaxima;
        this.numHijos = numHijos;
        this.email = email;
        this.casaFamilia = casaFamilia;
    }

    public int getIdFamilia() {
        return idFamilia;
    }

    public void setIdFamilia(int idFamilia) {
        this.idFamilia = idFamilia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdadMinima() {
        return edadMinima;
    }

    public void setEdadMinima(int edadMinima) {
        this.edadMinima = edadMinima;
    }

    public int getEdadMaxima() {
        return edadMaxima;
    }

    public void setEdadMaxima(int edadMaxima) {
        this.edadMaxima = edadMaxima;
    }

    public int getNumHijos() {
        return numHijos;
    }

    public void setNumHijos(int numHijos) {
        this.numHijos = numHijos;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Casa getCasaFamilia() {
        return casaFamilia;
    }

    public void setCasaFamilia(Casa casaFamilia) {
        this.casaFamilia = casaFamilia;
    }

    @Override
    public String toString() {
        return "Familia{" + "idFamilia=" + idFamilia + ", nombre=" + nombre + ", edadMinima=" + edadMinima + ", edadMaxima=" + edadMaxima + ", numHijos=" + numHijos + ", email=" + email + ", casaFamilia=" + casaFamilia + '}';
    }
    
}
