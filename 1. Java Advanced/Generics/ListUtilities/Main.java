package ListUtilities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
//        List<Integer> integers = new ArrayList<>();
//        Collections.addAll(integers,1,2,18,2,-1);
//        Integer maxInteger = ListUtils.getMax(integers);
//        System.out.println(maxInteger);

        List<String> strings = new ArrayList<>();
        Collections.addAll(strings,"a","b","c");
        String minStr = ListUtils.getMin(strings);
        if(minStr.equals(null)){
            System.out.println("IllegalArgumentException");
            return;
        }
        System.out.println(minStr);
    }
}
