package Model.stmt;

import Model.ProgramState;
import Model.Types.BoolType;
import Model.Values.BoolValue;
import Model.Values.Value;
import Model.adt.IDict;
import Model.adt.IStack;
import Model.except.MyException;
import Model.exp.Expression;

public class IfStmt implements IStmt{
    Expression e1;
    IStmt thenStmt;
    IStmt elseStmt;
    public IfStmt(Expression e1, IStmt thenStmt, IStmt elseStmt){
        this.e1 = e1;
        this.elseStmt = elseStmt;
        this.thenStmt = thenStmt;
    }
    @Override
    public ProgramState execute(ProgramState state) throws MyException {
        IDict<String, Value> symTable = state.getSymTable();
        IStack<IStmt> exeStack = state.getExeStack();
        Value boolVal = e1.evaluate(symTable);
        if(boolVal.getType() instanceof BoolType){
            if(((BoolValue) boolVal).isValue()){
                exeStack.push(thenStmt);
            }
            else{
                exeStack.push(elseStmt);
            }
        }
        return state;
    }

    @Override
    public String toString() {
        return "If (" + e1 +
                ") then (" + thenStmt +
                ") else (" + elseStmt + ")";
    }
}
