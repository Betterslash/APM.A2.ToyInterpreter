package Model.Values;

import Model.Types.IntType;
import Model.Types.Types;

public class IntValue implements Value{
    int value;
    public IntValue(int value){
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return Integer.toString(this.value);
    }

    @Override
    public Types getType() {
        return new IntType();
    }
}
