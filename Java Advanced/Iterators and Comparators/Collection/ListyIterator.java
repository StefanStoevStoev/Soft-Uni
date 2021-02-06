package Collection;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;
import java.util.function.Consumer;

public class ListyIterator implements Iterable<String> {

    private List<String> elements;
    private int index;

    public ListyIterator(String... values) {

        this.elements = Arrays.asList(values);
        this.index = 0;
    }

    public boolean move() {
        if (this.index == this.elements.size() - 1) {
            return false;
        }
        this.index++;
        return true;
    }

    public String getCurrentElement(){
        if(this.elements.size()==0){
            throw new UnsupportedOperationException("Invalid Operation!");
        }
        return this.elements.get(this.index);
    }

    public boolean hasNext() {
        return this.index < this.elements.size() - 1;
    }

    @Override
    public Iterator<String> iterator() {
        return elements.iterator();
    }
}
