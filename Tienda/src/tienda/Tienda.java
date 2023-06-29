/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tienda;

import java.util.ArrayList;
import java.util.Scanner;
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
            Scanner leer = new Scanner(System.in).useDelimiter("\n");
            int opc;
            do {                
                System.out.println("Ejercicio 1 de JDBC - MENU"
                        + "\n1. Lista el nombre de todos los productos que hay en la tabla producto."
                        + "\n2. Lista los nombres y los precios de todos los productos de la tabla producto."
                        + "\n3. Listar aquellos productos que su precio esté entre 120 y 202."
                        + "\n4. Buscar y listar todos los Portátiles de la tabla producto."
                        + "\n5. Listar el nombre y el precio del producto más barato."
                        + "\n6. Ingresar un producto a la base de datos."
                        + "\n7. Ingresar un fabricante a la base de datos"
                        + "\n8. Editar un producto con datos a elección."
                        + "\n9. Salir");
                System.out.println("Seleccione una opcion:");
                opc = leer.nextInt();
                switch (opc) {
                    case 1:
                        ArrayList<String> nombresProductos = productoService.listarNombresProductos();
                        for (String nombre : nombresProductos) {
                            System.out.println(nombre);
                        }
                        System.out.println("");
                        break;
                    case 2:
                        ArrayList<Producto> NPproductos = productoService.listarNombrePrecioProductos();
                        for (Producto producto : NPproductos) {
                            System.out.println("Nombre: " + producto.getNombre() + ", Precio: " + producto.getPrecio());
                        }
                        System.out.println("");
                        break;
                    case 3:
                        ArrayList<Producto> productosR = productoService.listarProductosRangoPrecio(120, 202);
                        for (Producto producto : productosR) {
                            System.out.println(producto.toString());
                        }
                        System.out.println("");
                        break;
                    case 4:
                        ArrayList<Producto> portatiles = productoService.listarPortatiles();
                        for (Producto portatil : portatiles) {
                            System.out.println(portatil.toString());
                        }
                        System.out.println("");
                        break;
                    case 5:
                        Producto producto = productoService.nombrePrecioMasBarato();
                        System.out.println("Nombre: " + producto.getNombre() + ", Precio: " + producto.getPrecio());
                        System.out.println("");
                        break;
                    case 6:
                        productoService.crearProducto();
                        break;
                    case 7:
                        fabricanteService.crearFabricante();
                        break;
                    case 8:
                        productoService.modificarProducto();
                        break;
                    case 9:
                        break;
                    default:
                        System.out.println("opcion incorrecta.");
                        System.out.println("");
                }
            } while (opc != 9);
//            fabricanteService.eliminarFabricante("Nikon");
//            productoService.eliminarProducto(14);

            
        } catch (Exception e) {
            throw e;
        }
    }
    
}
