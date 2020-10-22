package Model.Values;

import Model.Types.Types;

public class UnknownValue implements Value{
    Types type;
    public UnknownValue(Types type){
        this.type = type;
    }
    @Override
    public Types getType() {
        return this.type;
    }

    @Override
    public String toString() {
        return this.type + "@UnknownValue";
    }
}
