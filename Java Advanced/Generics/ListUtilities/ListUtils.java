package ListUtilities;

import java.util.ArrayList;
import java.util.List;

public class ListUtils<T> {
    ArrayList<T> listN;
    public ListUtils(){
        this.listN = new ArrayList<T>();
    }
    public static <T extends Comparable<T>> T getMin(List<T> list){
        if (list.size() == 0) throw new IllegalArgumentException();

        T min = list.get(0);

        for (T t : list) {
            if(t.compareTo(min)<0){
                min = t;
            }
        }
        return min;
    }

    public static <T extends Comparable<T>> T getMax(List<T> list){
        if (list.size() == 0) throw new IllegalArgumentException();

        T max = list.get(0);

        for (T t : list) {
            if(t.compareTo(max)>0){
                max = t;
            }
        }
        return max;
    }
}
