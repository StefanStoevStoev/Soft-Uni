package GenericCountMethodDouble;

public class GenericBox6<T extends Comparable<T>> implements Comparable<GenericBox6<T>> {
    private T value;
    public GenericBox6(T value){
        this.value = value;
    }

    @Override
    public String toString() {
        return value.getClass().getName() + ": " + value;
    }

    @Override
    public int compareTo(GenericBox6<T> other) {
        return this.value.compareTo(other.value);
    }

    public T getValue() {
        return value;
    }
}
