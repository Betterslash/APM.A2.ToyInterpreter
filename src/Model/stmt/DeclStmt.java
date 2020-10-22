package Model.stmt;

import Model.ProgramState;
import Model.Types.Types;
import Model.Values.UnknownValue;
import Model.Values.Value;
import Model.adt.IDict;


public class DeclStmt implements IStmt{
    public String id;
    Types type;
    public DeclStmt(String id, Types type){
        this.id = id;
        this.type = type;
    }
    @Override
    public ProgramState execute(ProgramState state) {
        IDict<String, Value> symTable = state.getSymTable();
        Value v = new UnknownValue(this.type);
        symTable.add(this.id,v);
        return state;
    }

    @Override
    public String toString() {
        return type + " " +id ;
    }
}
