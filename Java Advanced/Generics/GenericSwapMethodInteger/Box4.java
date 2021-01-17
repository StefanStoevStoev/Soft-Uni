package GenericSwapMethodInteger;

import java.util.ArrayList;
import java.util.List;

public class Box4<T> {
    T elements;
    public Box4(T elements){
        this.elements = elements;
    }
    @Override
    public String toString() {

        return elements.getClass().getName() + ": " + elements;
    }
}
