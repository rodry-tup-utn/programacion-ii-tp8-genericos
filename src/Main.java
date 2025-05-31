import entities.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.prefs.BackingStoreException;


public class Main {
    public static void main(String[] args) {

        //Kata 1 Creacion de productos, agregarlos a un lista y mostrarlos
        System.out.println("\n *** Kata 1 Productos*** \n");

        Producto<String> panificado = new Producto<>("SKU-334", "Coca Cola 2Lts", 3500.0);
        Producto<Integer> gaseosa = new Producto<>(12332, "Pan Casero de Campo", 1500.0);
        Producto<Integer> fideos = new Producto<>(2234, "Fideos Tirabuzon", 1400);
        Producto<Integer> arroz = new Producto<>(2234, "Arroz Tio Carlos 500g", 1400);
        Producto<String> facturas = new Producto<>("SKU-312", "Fideos Tirabuzon", 1400);

        ArrayList<Producto<?>> listaProductos = new ArrayList<>();
        listaProductos.add(panificado);
        listaProductos.add(gaseosa);
        listaProductos.add(fideos);
        listaProductos.add(arroz);
        listaProductos.add(facturas);
        for (Producto producto : listaProductos){
            System.out.println(producto);
        }

        //Kata 2 Implementar Clase Carrito
        System.out.println("\n *** Kata 2 Implementacion de Carrito*** \n");
        Carrito<Producto<?>> carritoCompras = new Carrito<>();
        carritoCompras.agregarVariosProductos(panificado, gaseosa, facturas);
        carritoCompras.mostrarProductos();
        System.out.println("El total del carrito es de $" + carritoCompras.obtenerTotal());

        System.out.println("\n *** Kata 3 Implementacion de Pedido*** \n");

        Pedido pedido1 = new Pedido(1, LocalDate.of(2025, 05,12));
        Pedido pedido2 = new Pedido(2, LocalDate.now());
        Pedido pedido3 = new Pedido(3, LocalDate.of(2025, 05, 20));

        pedido3.agregarVariosProductos(gaseosa, arroz, fideos);
        pedido1.agregarVariosProductos(panificado, gaseosa);
        pedido2.agregarVariosProductos(arroz, arroz, facturas, fideos);

        System.out.println(pedido1);
        System.out.println("Pedido 1 Total: $" + pedido1.calcularTotal());
        System.out.println(pedido2);
        System.out.println("Pedido 2 Total: $" + pedido2.calcularTotal());
        System.out.println(pedido3);
        System.out.println("Pedido 3 Total: $" + pedido3.calcularTotal());

        ArrayList<Pedido> listaDePedidos = new ArrayList<>();
        listaDePedidos.add(pedido1);
        listaDePedidos.add(pedido2);
        listaDePedidos.add(pedido3);

        //Ordenar pedidos por total
        System.out.println("Lista de pedidos ordenados por total");
        Collections.sort(listaDePedidos);
        System.out.println(listaDePedidos);

        //Ordenar pedidos por fecha
        System.out.println("Lista de pedidos por fecha");
        Collections.sort(listaDePedidos, new ComparadorPedidosPorFecha());
        System.out.println(listaDePedidos);

        //Buscar elemento por id en pedido
        System.out.println("****Buscar pedido con buscador generico ***");
        Buscador<Pedido, Integer> buscadorPedidos = new Buscador();
        Pedido pedidoEncontrado = buscadorPedidos.buscar(listaDePedidos, 4);
        System.out.println("Pedido encontrado:" + pedidoEncontrado);
    }
}
