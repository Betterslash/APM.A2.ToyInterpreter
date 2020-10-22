package Model.stmt;

import Model.ProgramState;
import Model.Values.Value;
import Model.adt.IDict;
import Model.adt.IList;
import Model.except.MyException;
import Model.exp.Expression;

public class PrintStmt implements IStmt{
    Expression v;
    public PrintStmt(Expression value){
        this.v = value;
    }
    @Override
    public ProgramState execute(ProgramState state) throws MyException {
        IList<Value> output = state.getOut();
        IDict<String, Value> symTable = state.getSymTable();
        output.addOut(this.v.evaluate(symTable));
        return state;
    }

    @Override
    public String toString() {
        return "print " + v;
    }
}
