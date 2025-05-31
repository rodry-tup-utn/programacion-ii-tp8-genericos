package entities;

public class Producto <T> implements Identificable<T>{
    private T id;
    private String nombre;
    private double precio;

    public Producto(T id, String nombre, double precio) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
    }

    public T getId() {
        return id;
    }

    public void setId(T id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return id + " - " + nombre + " - $" + precio;
    }

    @Override
    public T getid() {
        return id;
    }

    @Override
    public boolean tieneMismoId(T id) {
        return this.id.equals(id);
    }
}
