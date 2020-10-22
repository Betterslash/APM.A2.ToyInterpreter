package Model.stmt;

import Model.ProgramState;
import Model.Types.Types;
import Model.Values.Value;
import Model.adt.IDict;
import Model.except.MyException;
import Model.exp.Expression;

public class AssignStmt implements IStmt{
    String id;
    Expression exp;
    public AssignStmt(String id, Expression exp){
        this.exp = exp;
        this.id = id;
    }
    @Override
    public ProgramState execute(ProgramState state) throws MyException {
        IDict<String , Value> symTable = state.getSymTable();
            Value val = this.exp.evaluate(symTable);
            try{
            Types type = symTable.lookup(id).getType();
            if (val.getType().equals(type)) {
                symTable.update(id, val);
            }
        }catch (Exception e){
            throw new MyException("There's no variable like this stored!");
        }
        return state;
    }

    @Override
    public String toString() {
        return id + " = " + exp;
    }
}
