/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tienda.servicios;

import java.util.ArrayList;
import java.util.Scanner;
import tienda.entidades.Producto;
import tienda.persistencia.ProductoDAO;

/**
 *
 * @author Sebastian
 */
public class ProductoService {
    private ProductoDAO dao;
    private Scanner leer;

    public ProductoService() {
        dao = new ProductoDAO();
        leer = new Scanner(System.in).useDelimiter("\n");
    }
    
    public void crearProducto() throws Exception{
        try {
            System.out.println("Ingrese nombre del producto:");
            String nombre = leer.next();
            if(nombre == null || nombre.trim().isEmpty()){
                throw new Exception("Debe ingresar un nombre de producto.");
            }
            System.out.println("Ingrese precio del producto:");
            double precio = leer.nextDouble();
            System.out.println("Ingrese codigo del fabricante:");
            int codigoFabricante = leer.nextInt();
            
            Producto producto = new Producto();
            producto.setNombre(nombre);
            producto.setPrecio(precio);
            producto.setCodigoFabricante(codigoFabricante);
            
            dao.guardarProducto(producto);
        } catch (Exception e) {
            throw e;
        }
        
    }
    
    public void eliminarProducto(int codigo){
        try {
            dao.eliminarProducto(codigo);
        } catch (Exception e) {
            throw e;
        }
    }
    
    public ArrayList<String> listarNombresProductos() throws Exception{
        try {
            ArrayList<String> nombresProductos = dao.listarNombresProductos();
            return nombresProductos;
        } catch (Exception e) {
            throw e;
        }
    }
    
    public ArrayList<Producto> listarNombrePrecioProductos() throws Exception{
        try {
            ArrayList<Producto> productos = dao.listarNombrePrecioProductos();
            return productos;
        } catch (Exception e) {
            throw e;
        }
    }
    
    public ArrayList<Producto> listarProductosRangoPrecio(int desde, int hasta) throws Exception{
        try {
            ArrayList<Producto> productos = dao.listarProductoRangoPrecio(desde, hasta);
            return productos;
        } catch (Exception e) {
            throw e;
        }
    }
    
    public ArrayList<Producto> listarPortatiles() throws Exception{
        try {
            ArrayList<Producto> portatiles = dao.listarPortatiles();
            return portatiles;
        } catch (Exception e) {
            throw e;
        }
    }
    
    public Producto nombrePrecioMasBarato() throws Exception{
        try {
            Producto producto = dao.nombrePrecioMasBarato();
            return producto;
        } catch (Exception e) {
            throw e;
        }
        
    }
    
    public Producto buscarProductoPorCodigo(int codigo) throws Exception{
        try {
            if(codigo < 0){
                throw new Exception("debe indicar el codigo");
            }
            Producto producto = dao.buscarProductoPorCodigo(codigo);
            if(producto == null){
                throw new Exception("No se encontro el producto.");
            }
            return producto;
        } catch (Exception e) {
            throw e;
        }
        
    }
    
    public void modificarProducto() throws Exception{
        try {
            System.out.println("Ingrese codigo del producto a modificar:");
            int codigo = leer.nextInt();
            Producto producto = buscarProductoPorCodigo(codigo);
            System.out.println("¿Desea modificar el nombre del producto? (S/N)");
            String resp;
            do{
                resp = leer.next();
                if(!resp.equalsIgnoreCase("S") && !resp.equalsIgnoreCase("N")){
                    System.out.println("respuesta incorrecta. Responda S o N");
                }
            }while(!resp.equalsIgnoreCase("S") && !resp.equalsIgnoreCase("N"));
            if(resp.equalsIgnoreCase("S")){
                System.out.println("Ingrese nuevo nombre:");
                String nombre = leer.next();
                producto.setNombre(nombre);
            }
            System.out.println("¿Desea modificar el precio del producto? (S/N)");
            do{
                resp = leer.next();
                if(!resp.equalsIgnoreCase("S") && !resp.equalsIgnoreCase("N")){
                    System.out.println("respuesta incorrecta. Responda S o N");
                }
            }while(!resp.equalsIgnoreCase("S") && !resp.equalsIgnoreCase("N"));
            if(resp.equalsIgnoreCase("S")){
                System.out.println("Ingrese nuevo precio:");
                double precio = leer.nextDouble();
                producto.setPrecio(precio);
            }
            System.out.println("¿Desea modificar el fabricante del producto? (S/N)");
            do{
                resp = leer.next();
                if(!resp.equalsIgnoreCase("S") && !resp.equalsIgnoreCase("N")){
                    System.out.println("respuesta incorrecta. Responda S o N");
                }
            }while(!resp.equalsIgnoreCase("S") && !resp.equalsIgnoreCase("N"));
            if(resp.equalsIgnoreCase("S")){
                System.out.println("Ingrese nuevo codigo de fabricante:");
                int codigoFabricante = leer.nextInt();
                producto.setCodigoFabricante(codigoFabricante);
            }
            
            dao.modificarProducto(producto);
        } catch (Exception e) {
            throw e;
        }
        
    }
}
