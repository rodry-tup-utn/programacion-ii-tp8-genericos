package entities;

import java.util.ArrayList;
import java.util.List;

public class Carrito <T extends Producto<?>>{
    private List<T> productos;

    public Carrito() {
        this.productos = new ArrayList<>();
    }

    public List<T> getProductos() {
        return productos;
    }

    public void setProductos(List<T> productos) {
        this.productos = productos;
    }

    public void agregarVariosProductos(T... productos){
        for (T producto : productos){
            this.productos.add(producto);
        }
    }

    public void agregarProducto(T producto){
        this.productos.add(producto);
    }

    public void eliminarProducto(T producto){
        if (this.productos.remove(producto)){
            System.out.println("Se eliminó el producto " + producto.getNombre());
        } else {
            System.out.println("No se encontró el producto en el carrito");
        }
    }

    public double obtenerTotal(){
        double total = 0;
        for (T producto : productos){
            total += producto.getPrecio();
        }
        return total;
    }

    public void mostrarProductos(){
        System.out.println("Productos en carrito");
        for (T producto : productos){
            System.out.println(producto);
        }
    }
}
