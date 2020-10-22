package Model.exp;

import Model.Values.BoolValue;
import Model.Values.Value;
import Model.adt.IDict;
import Model.except.MyException;

public class LogExp extends Expression{
    Expression right;
    Expression left;
    char op;
    @Override
    public Value evaluate(IDict<String, Value> symTable) throws MyException {
        BoolValue vL = (BoolValue) this.left.evaluate(symTable);
        BoolValue vR = (BoolValue) this.right.evaluate(symTable);
        return switch (this.op) {
            case '&' -> new BoolValue(vL.isValue() & vR.isValue());
            case '|' -> new BoolValue(vL.isValue() || vR.isValue());
            default -> new BoolValue(false);
        };
    }
}
