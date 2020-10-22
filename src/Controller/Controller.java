package Controller;

import Model.ProgramState;
import Model.adt.IStack;
import Model.adt.MyStack;
import Model.except.MyException;
import Model.stmt.IStmt;
import Repository.IRepository;

public class Controller {
    IRepository repository;
    public Controller(IRepository repository){
        this.repository = repository;
    }
    public void add(ProgramState programState){
        this.repository.addToRepository(programState);
    };
    public ProgramState getCrtPrg(){
        return this.repository.getPrgState();
    }
    public ProgramState oneStep(ProgramState state) throws MyException {
        IStack<IStmt> exeStack = state.getExeStack();
        if(exeStack.isEmpty()){
            throw new MyException("Execution stack is empty!");
        }
        IStmt currStmt = exeStack.pop();
        return currStmt.execute(state);
    }
    public void allStep() throws MyException {
        ProgramState state = this.repository.getPrgState();
        while(!state.getExeStack().isEmpty()){
            oneStep(state);
        }
    }
}
