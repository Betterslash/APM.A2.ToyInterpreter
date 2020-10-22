package Repository;

import Model.ProgramState;

import java.util.ArrayList;

public class Repository implements IRepository{
    ArrayList<ProgramState> listOfPrograms;
    public Repository(){
        listOfPrograms = new ArrayList<ProgramState>();
    }
    @Override
    public void addToRepository(ProgramState state) {
        this.listOfPrograms.add(state);
    }
    @Override
    public ProgramState getPrgState() {
        return this.listOfPrograms.get(this.listOfPrograms.size() - 1);
    }
}
