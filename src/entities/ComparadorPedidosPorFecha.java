package entities;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.Date;

public class ComparadorPedidosPorFecha implements Comparator<Pedido> {

    @Override
    public int compare(Pedido pedido1, Pedido pedido2) {
        LocalDate fecha_1 = pedido1.getFecha();
        LocalDate fecha_2 = pedido2.getFecha();
        return fecha_1.compareTo(fecha_2);
    }
}
