package GenericSwapMethodStrings;

public class Box<T> {
    T elements;
    public Box(T elements){
        this.elements = elements;
    }
    @Override
    public String toString() {

        return elements.getClass().getName() + ": " + elements;
    }
}
