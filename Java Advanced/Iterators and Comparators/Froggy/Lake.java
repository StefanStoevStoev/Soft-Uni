package Froggy;

import java.util.Iterator;

public class Lake implements Iterable<Integer> {

private int[] stones;

    public Lake(int...stones) {
        this.stones=stones;
    }

    public class Frog implements Iterator<Integer> {

        private int index = 0;

        @Override
        public boolean hasNext() {
            return index<stones.length;
        }

        @Override
        public Integer next() {
            int value;
            if(index >=stones.length){
                index = 1;
            }
            value = stones[this.index];
            this.index += 2;
            if(this.index%2==0&&!hasNext()){
                this.index = 1;
            }
            return value;
        }
    }
    @Override
    public Iterator<Integer> iterator(){
        return new Frog();
    }

}
