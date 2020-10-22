package Model.adt;

public interface IDict<T1,T2> {
    public void update(T1 id, T2 value);
    public T2 lookup(T1 id);
    public void add(T1 id,T2 value);
}
