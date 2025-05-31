package entities;

import java.util.Collection;
import java.util.Iterator;

public class Buscador<T extends Identificable, K>{
    public T buscar(Collection<? extends T> elementos, K id){
        T elementoEncontrado = null;
        Iterator<? extends T> it = elementos.iterator();
        while(it.hasNext() && elementoEncontrado == null) {
            T elementoActual  = it.next();
            if (elementoActual.tieneMismoId(id)){
                elementoEncontrado = elementoActual;
            }
        }
        return elementoEncontrado;
    }
}
