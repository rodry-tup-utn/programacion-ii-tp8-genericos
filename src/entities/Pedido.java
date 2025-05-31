package entities;

import java.time.LocalDate;
import java.util.*;

public class Pedido implements Comparable<Pedido>, Identificable<Integer> {
    private int id;
    private LocalDate fecha;
    private List<Producto<?>> listaProductos;

    public LocalDate getFecha() {
        return fecha;
    }

    public Pedido(int id, LocalDate fecha) {
        this.id = id;
        this.fecha = fecha;
        this.listaProductos = new ArrayList<>();
    }

    public void agregarProducto(Producto<?> producto){
        this.listaProductos.add(producto);
    }

    public void agregarVariosProductos(Producto<?>... productos){
        for (Producto<?> producto : productos){
            this.listaProductos.add(producto);
        }
    }

    public double calcularTotal(){
        double total = 0;
        for (Producto<?> producto : listaProductos){
            total += producto.getPrecio();
        }
        return total;
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "id=" + id +
                ", fecha=" + fecha +
                ", totalPedido=$" + calcularTotal() +
                '}';
    }

    @Override
    public int compareTo(Pedido pedido) {
        return Double.compare(this.calcularTotal(), pedido.calcularTotal());
    }

    @Override
    public Integer getid() {
        return id;
    }

    @Override
    public boolean tieneMismoId(Integer id) {
        return this.id == id;
    }
}
