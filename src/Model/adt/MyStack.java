package Model.adt;

import java.util.Stack;

public class MyStack<T> implements IStack<T>{
    Stack<T> representation;
    public MyStack(){
        this.representation = new Stack<T>();
    }
    @Override
    public T pop() {
        return this.representation.pop();
    }

    @Override
    public void push(T item) {
        this.representation.push(item);
    }

    @Override
    public boolean isEmpty() {
        return this.representation.isEmpty();
    }
}
