package Model.stmt;

import Model.ProgramState;
import Model.except.MyException;

public interface IStmt {
    public ProgramState execute(ProgramState state) throws MyException;
}
