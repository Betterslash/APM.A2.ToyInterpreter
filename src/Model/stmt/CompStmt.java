package Model.stmt;

import Model.ProgramState;
import Model.adt.IStack;
import Model.except.MyException;

public class CompStmt implements IStmt{
    IStmt st1;
    IStmt st2;
    public CompStmt(IStmt st1, IStmt st2){
        this.st1 = st1;
        this.st2 = st2;
    }
    @Override
    public ProgramState execute(ProgramState state) throws MyException {
        IStack<IStmt> exeStack = state.getExeStack();
        exeStack.push(this.st2);
        exeStack.push(this.st1);
        return state;
    }

    @Override
    public String toString() {
        return  this.st1.toString() +" ; "+ this.st2.toString();
    }
}
