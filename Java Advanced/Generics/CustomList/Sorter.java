package CustomList;

public class Sorter <T extends Comparable<T>>{
    public void sort(CustomList<T> elements){
        for (int i = 0; i <elements.size(); i++) {
            T elem = elements.get(i);
            for (int k = 0; k < elements.size()-1; k++) {
                if(elem.compareTo(elements.get(k))<0){
                    elements.swap(i,k);
                }
            }
            
        }
    }

}
