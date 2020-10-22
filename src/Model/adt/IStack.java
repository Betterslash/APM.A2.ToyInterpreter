package Model.adt;

public interface IStack<T>{
    public T pop();
    public void push(T item);
    public boolean isEmpty();
}
