package Model.exp;

import Model.Values.Value;
import Model.adt.IDict;
import Model.adt.MyDict;

public class VarExp extends Expression{
    String id;
    public VarExp(String id){
        this.id = id;
    }
    @Override
    public Value evaluate(IDict<String, Value> symTable) {
        return symTable.lookup(id);
    }

    @Override
    public String toString() {
        return id;
    }
}
