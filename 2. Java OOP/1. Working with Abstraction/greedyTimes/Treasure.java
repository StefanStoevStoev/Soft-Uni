package greedyTimes;

import java.util.Iterator;
import java.util.Map;

public class Treasure implements Iterable<Treasure.Pair<String,Long>> {

    public static class Pair<K, V>{
        private K first;
        private V second;

        public Pair(K first, V second){
            this.first = first;
            this.second = second;
        }
        public K getFirst(){
            return first;
        }
        public V getSecond(){
            return second;
        }

    }
    private String[] goods;

    public Treasure(String[]goods){
        this.goods = goods;
    }

    @Override
    public Iterator<Treasure.Pair<String,Long>> iterator() {


        return new Iterator<>() {
            private int index = 0;
            @Override
            public boolean hasNext() {
                return index < goods.length;
            }

            @Override
            public Treasure.Pair<String, Long> next() {
                String item = goods[index++];
                Long value = Long.parseLong(goods[index++]);
                return new Treasure.Pair<>(item,value);
            }
        };
    }
}
