package entities;

public interface Identificable<T> {
    public abstract T getid();
    public boolean tieneMismoId(T id);
}
