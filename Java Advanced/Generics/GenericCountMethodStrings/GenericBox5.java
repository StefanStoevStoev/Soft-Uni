package GenericCountMethodStrings;

public class GenericBox5<T extends Comparable<T>> implements Comparable<T> {
    private T value;
    public GenericBox5(T value){
        this.value = value;
    }

    @Override
    public String toString() {
        return value.getClass().getName() + ": " + value;
    }

    @Override
    public int compareTo(T other) {
        return this.value.compareTo(other);
    }

    public T getValue() {
        return value;
    }
}
