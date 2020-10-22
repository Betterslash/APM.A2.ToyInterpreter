package Model.exp;

import Model.Values.Value;
import Model.adt.IDict;
import Model.adt.MyDict;
import Model.except.MyException;

public abstract class Expression {
    public abstract Value evaluate(IDict<String,Value> symTable) throws MyException;
}
