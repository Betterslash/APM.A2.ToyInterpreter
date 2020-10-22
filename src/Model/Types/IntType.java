package Model.Types;

public class IntType implements Types{
    @Override
    public boolean equals(Object obj) {
        return obj instanceof IntType;
    }

    @Override
    public String toString() {
        return "int";
    }
}
