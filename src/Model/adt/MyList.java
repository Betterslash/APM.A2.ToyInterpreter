package Model.adt;

import java.util.ArrayList;

public class MyList<T> implements IList<T>{
    ArrayList<T> representation;
    public MyList(){
        this.representation = new ArrayList<T>();
    }
    @Override
    public void addOut(T item) {
        this.representation.add(item);
    }

    @Override
    public T getOut() {
        return this.representation.get(this.representation.size() - 1);
    }
}
