package Model;

import Model.Values.Value;
import Model.adt.IDict;
import Model.adt.IList;
import Model.adt.IStack;
import Model.stmt.IStmt;

public class ProgramState {
    IDict<String, Value> symTable;
    IStack<IStmt> exeStack;
    IList<Value> out;
    IStmt originalProgram;
    public ProgramState(IDict<String, Value> symTable, IStack<IStmt> exeStack, IList<Value> out, IStmt originalProgram){
        this.exeStack = exeStack;
        this.originalProgram = originalProgram;
        this.out = out;
        this.symTable = symTable;
    }

    public IDict<String, Value> getSymTable() {
        return symTable;
    }

    public IList<Value> getOut() {
        return out;
    }

    public IStack<IStmt> getExeStack() {
        return exeStack;
    }
}
