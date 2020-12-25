package FamilyTree;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private List<Children> children;
    private List<Parents> parents;

    public Person(){
        children = new ArrayList<>();
        parents = new ArrayList<>();
    }
    public List<Children> getChildren(){
        return children;
    }
    public List<Parents> getParents(){
        return parents;
    }
}
