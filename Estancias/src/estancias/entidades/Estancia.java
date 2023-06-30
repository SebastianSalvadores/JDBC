/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estancias.entidades;

import java.time.LocalDate;

/**
 *
 * @author Sebastian
 */
public class Estancia {
    private int idEstancia;
    private Cliente cliente;
    private Casa casa;
    private String nombreHuesped;
    private LocalDate fechaDesde;
    private LocalDate fechaHasta;

    public Estancia() {
    }

    public Estancia(int idEstancia, Cliente cliente, Casa casa, String nombreHuesped, LocalDate fechaDesde, LocalDate fechaHasta) {
        this.idEstancia = idEstancia;
        this.cliente = cliente;
        this.casa = casa;
        this.nombreHuesped = nombreHuesped;
        this.fechaDesde = fechaDesde;
        this.fechaHasta = fechaHasta;
    }

    public int getIdEstancia() {
        return idEstancia;
    }

    public void setIdEstancia(int idEstancia) {
        this.idEstancia = idEstancia;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Casa getCasa() {
        return casa;
    }

    public void setCasa(Casa casa) {
        this.casa = casa;
    }

    public String getNombreHuesped() {
        return nombreHuesped;
    }

    public void setNombreHuesped(String nombreHuesped) {
        this.nombreHuesped = nombreHuesped;
    }

    public LocalDate getFechaDesde() {
        return fechaDesde;
    }

    public void setFechaDesde(LocalDate fechaDesde) {
        this.fechaDesde = fechaDesde;
    }

    public LocalDate getFechaHasta() {
        return fechaHasta;
    }

    public void setFechaHasta(LocalDate fechaHasta) {
        this.fechaHasta = fechaHasta;
    }

    @Override
    public String toString() {
        return "Estancia{" + "idEstancia=" + idEstancia + ", idCliente=" + cliente.getIdCliente() + ", idCasa=" + casa.getIdCasa() + ", nombreHuesped=" + nombreHuesped + ", paisHuesped=" + cliente.getPais() + ", ciudadHuesped=" + cliente.getCiudad() + ", fechaDesde=" + fechaDesde + ", fechaHasta=" + fechaHasta + ", " + casa + '}';
    }

}
