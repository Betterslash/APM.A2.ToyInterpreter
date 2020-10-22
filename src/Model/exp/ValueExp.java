package Model.exp;

import Model.Values.Value;
import Model.adt.IDict;
import Model.adt.MyDict;

public class ValueExp extends Expression{
    Value value;
    public ValueExp(Value value){
        this.value = value;
    }
    @Override
    public Value evaluate(IDict<String, Value> symTable) {
        return this.value;
    }

    @Override
    public String toString() {
        return value.toString();
    }
}
