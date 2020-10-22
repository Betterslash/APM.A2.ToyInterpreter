package Model.adt;

import java.util.HashMap;

public class MyDict<T1,T2> implements IDict<T1, T2>{
    HashMap<T1, T2> representation;
    public MyDict(){
        this.representation = new HashMap<T1, T2>();
    }
    @Override
    public void update(T1 id, T2 value) {
        this.representation.put(id,value);
    }

    @Override
    public T2 lookup(T1 id) {
        return this.representation.get(id);
    }

    @Override
    public void add(T1 id, T2 value) {
        this.representation.put(id,value);
    }
}
