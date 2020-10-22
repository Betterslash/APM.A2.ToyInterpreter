package Repository;

import Model.ProgramState;

public interface IRepository {
    void addToRepository(ProgramState state);
    ProgramState getPrgState();
}
