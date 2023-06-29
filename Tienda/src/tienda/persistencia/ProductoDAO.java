/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tienda.persistencia;

import java.util.ArrayList;
import tienda.entidades.Producto;

/**
 *
 * @author Sebastian
 */
public final class ProductoDAO extends DAO {

    public void guardarProducto(Producto producto) throws Exception {
        try {
            if (producto == null) {
                throw new Exception("Debe indicar un producto.");
            }
            String sql = "INSERT INTO producto(nombre, precio, codigo_fabricante) VALUES ('" + producto.getNombre() + "', " + producto.getPrecio() + ", " + producto.getCodigoFabricante() + ");";
            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        } finally {
            desconectarBase();
        }
    }

    public void eliminarProducto(int codigo) {
        try {
            String sql = "DELETE FROM producto WHERE codigo = " + codigo + ";";
            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        } finally {
            desconectarBase();
        }
    }

    public ArrayList<String> listarNombresProductos() throws Exception {
        try {
            String sql = "SELECT nombre FROM producto";
            consultarBase(sql);
            String nombreProducto;
            ArrayList<String> nombresProductos = new ArrayList();

            while (resultado.next()) {
                nombreProducto = resultado.getString(1);
                nombresProductos.add(nombreProducto);
            }

            desconectarBase();

            return nombresProductos;

        } catch (Exception e) {
            throw e;
        }
    }

    public ArrayList<Producto> listarNombrePrecioProductos() throws Exception {
        try {
            ArrayList<Producto> productos = new ArrayList();
            Producto producto = null;
            String sql = "SELECT nombre, precio FROM producto";
            consultarBase(sql);

            while (resultado.next()) {
                producto = new Producto();
                producto.setNombre(resultado.getString(1));
                producto.setPrecio(resultado.getDouble(2));
                productos.add(producto);
            }

            desconectarBase();

            return productos;
        } catch (Exception e) {
            throw e;
        }
    }

    public ArrayList<Producto> listarProductoRangoPrecio(int desde, int hasta) throws Exception {
        try {
            ArrayList<Producto> productos = new ArrayList();
            Producto producto = null;
            String sql = "SELECT * FROM producto WHERE precio >= " + desde + " AND precio <= " + hasta;
            consultarBase(sql);

            while (resultado.next()) {
                producto = new Producto();
                producto.setCodigo(resultado.getInt(1));
                producto.setNombre(resultado.getString(2));
                producto.setPrecio(resultado.getDouble(3));
                producto.setCodigoFabricante(resultado.getInt(4));
                productos.add(producto);
            }

            desconectarBase();

            return productos;
        } catch (Exception e) {
            throw e;
        }
    }

    public ArrayList<Producto> listarPortatiles() throws Exception {
        try {
            ArrayList<Producto> portatiles = new ArrayList<>();
            Producto producto = null;
            String sql = "SELECT * FROM producto WHERE nombre LIKE '%portatil%'";
            consultarBase(sql);

            while (resultado.next()) {
                producto = new Producto();
                producto.setCodigo(resultado.getInt(1));
                producto.setNombre(resultado.getString(2));
                producto.setPrecio(resultado.getDouble(3));
                producto.setCodigoFabricante(resultado.getInt(4));
                portatiles.add(producto);
            }

            desconectarBase();

            return portatiles;

        } catch (Exception e) {
            throw e;
        }
    }

    public Producto nombrePrecioMasBarato() throws Exception {
        try {
            Producto producto = null;
            String sql = "SELECT nombre, precio FROM producto WHERE precio = (SELECT MIN(precio) FROM producto)";
            consultarBase(sql);

            while (resultado.next()) {
                producto = new Producto();
                producto.setNombre(resultado.getString(1));
                producto.setPrecio(resultado.getDouble(2));
            }
            desconectarBase();
            return producto;
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void modificarProducto(Producto producto) throws Exception{
        try {
            if(producto == null){
                throw new Exception("Debe indicar un producto.");
            }
            String sql = "UPDATE producto SET nombre = '" + producto.getNombre() + "', precio = " + producto.getPrecio() + ", codigo_fabricante = " + producto.getCodigoFabricante() + 
                    " WHERE codigo = " + producto.getCodigo();
            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        }finally{
            desconectarBase();
        }
    }
    
    public Producto buscarProductoPorCodigo(int codigo) throws Exception{
        try {
            Producto producto = null;
            String sql = "SELECT * FROM producto WHERE codigo = " + codigo;
            consultarBase(sql);
            while(resultado.next()){
                producto = new Producto();
                producto.setCodigo(resultado.getInt(1));
                producto.setNombre(resultado.getString(2));
                producto.setPrecio(resultado.getDouble(3));
                producto.setCodigoFabricante(resultado.getInt(4));
            }
            desconectarBase();
            return producto;
        } catch (Exception e) {
            throw e;
        }
    }
}
