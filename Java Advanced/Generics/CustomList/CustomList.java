package CustomList;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;

public class CustomList<T extends Comparable<T>> implements Iterable<T> {

    private static final int Initial_Capacity = 4;
    private Object[] elements;
    private int size;

    public CustomList() {
        this.elements = new Object[Initial_Capacity];
    }

    public void add(T element) {/////////////////////
        if (this.size == this.elements.length) {
            this.elements = grow();
        }
        this.elements[this.size++] = element;
    }

    public T get(int index) {
        ensureIndex(index);
        return getAt(index);
    }

    private void ensureIndex(int index) {/////////////////
        if (index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException("Index out of bound for: "
                    + index + " Array list size of: " + this.size);
        }
    }

    @SuppressWarnings("unchecked")
    private T getAt(int index) {
        return (T) this.elements[index];
    }

    private Object[] grow() {
        return Arrays.copyOf(this.elements, this.elements.length * 2);
    }

    public boolean contains(Object element) {//////////////

        return this.indexOf(element) >= 0;
    }

    public int indexOf(Object obj) {////////////////
        for (int k = 0; k < this.size; k++) {
            T at = this.getAt(k);
            if (at.equals(obj)) {
                return k;
            }
        }
        return -1;
    }

    public void swap(int first, int second) {////////////////
        ensureIndex(first);
        ensureIndex(second);
        Object temp = this.elements[first];
        this.elements[first] = this.elements[second];
        this.elements[second] = temp;
    }

    public int countGreaterThan(T element) {///////////////////////
        int count = 0;

        for (int k = 0; k < this.size; k++) {
            if (this.get(k).compareTo(element) > 0) {
                count++;
            }
        }
        return count;
    }

    @SuppressWarnings("unchecked")
    public T getMax() {//////////////////////////
        return Arrays.stream(this.elements)
                .limit(this.size)
                .map(e -> (T) e)
                .max(Comparator.comparing(e -> e))
                .orElse(null);
    }

    @SuppressWarnings("unchecked")
    public T getMin() {////////////////////////////
        return Arrays.stream(this.elements)
                .limit(this.size)
                .map(e -> (T) e)
                .min(Comparator.comparing(e -> e))
                .orElse(null);
    }

    public void print() {
        for (int i = 0; i < this.size; i++) {
            System.out.println(this.elements[i].toString());
        }
    }

    public T remove2(int index) {///////////
        ensureIndex(index);
        T at = this.getAt(index);

        this.elements[index] = null;
        shift(index);
        this.size--;

        if (this.size == this.elements.length / 2) {
            this.elements = srink();
        }
        return at;
    }

    private void shift(int index) {//////////////
        for (int k = index; k < this.size - 1; k++) {
            this.elements[k] = this.elements[k + 1];
        }
        this.elements[this.size - 1] = null;
    }

    public void sort() {
        Sorter<T> eSorter = new Sorter<T>();
        eSorter.sort(this);
    }
    public int size(){
        return this.size;
    }

    private Object[] srink() {///////////////
        return Arrays.copyOf(this.elements, this.elements.length / 2);
    }


    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {

            private  int index = 0;
            @Override
            public boolean hasNext() {
                return false;
            }

            @Override
            public T next() {
                return get(index++);
            }
        };
    }
}
