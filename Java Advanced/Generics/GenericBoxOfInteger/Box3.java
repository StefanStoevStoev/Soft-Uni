package GenericBoxOfInteger;

public class Box3<T> {

    private T value;

    public Box3(T value){
        this.value = value;
    }
    @Override
    public String toString() {
        return value.getClass().getName() + ": " + value;
    }
}
