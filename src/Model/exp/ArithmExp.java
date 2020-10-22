package Model.exp;

import Model.Types.IntType;
import Model.Values.IntValue;
import Model.Values.Value;
import Model.adt.IDict;
import Model.adt.MyDict;
import Model.except.MyException;

public class ArithmExp extends Expression{
    Expression left;
    Expression right;
    char op;
    public ArithmExp(char op,Expression l, Expression r){
        this.left = l;
        this.right = r;
        this.op = op;
    }
    @Override
    public Value evaluate(IDict<String, Value> symTable) throws MyException {
        if(!left.evaluate(symTable).getType().equals(new IntType()))
        {
            throw new MyException("The left operand in not integer!");
        }
        if(!right.evaluate(symTable).getType().equals(new IntType()))
        {
            throw new MyException("The right operand in not integer!");
        }
        IntValue le = (IntValue)this.left.evaluate(symTable);
        IntValue ri = (IntValue)this.right.evaluate(symTable);
        switch (op) {
            case '+' : return new IntValue(le.getValue() + ri.getValue());
            case '-' : return new IntValue(le.getValue() - ri.getValue());
            case '*' : return new IntValue(le.getValue() * ri.getValue());
            case '/' : {
                if(ri.getValue() == 0){
                    throw new MyException("Division by 0!");
                }
                return new IntValue(le.getValue() / ri.getValue());
            }
        };
        throw new MyException("Wrong operator!");
    }

    @Override
    public String toString() {
        return "("+left+" "+op+" "+right + ")";
    }
}
