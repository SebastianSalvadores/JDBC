/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tienda;

import java.util.ArrayList;
import tienda.entidades.Producto;
import tienda.servicios.FabricanteService;
import tienda.servicios.ProductoService;

/**
 *
 * @author Sebastian
 */
public class Tienda {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        FabricanteService fabricanteService = new FabricanteService();
        ProductoService productoService = new ProductoService();
        
        try {
//            fabricanteService.crearFabricante();
//            fabricanteService.eliminarFabricante("TEST");
//            productoService.crearProducto();
//            productoService.eliminarProducto(12);
//            ArrayList<String> nombresProductos = productoService.listarNombresProductos();
//            for (String nombre : nombresProductos) {
//                System.out.println(nombre);
//            }
//            ArrayList<Producto> productos = productoService.listarNombrePrecioProductos();
//            for (Producto producto : productos) {
//                System.out.println("Nombre: " + producto.getNombre() + ", Precio: " + producto.getPrecio());
//            }
//            ArrayList<Producto> productos = productoService.listarProductosRangoPrecio(120, 202);
//            for (Producto producto : productos) {
//                System.out.println(producto.toString());
//            }
            ArrayList<Producto> portatiles = productoService.listarPortatiles();
            for (Producto portatil : portatiles) {
                System.out.println(portatil.toString());
            }
        } catch (Exception e) {
            throw e;
        }
    }
    
}
