package FamilyTree;

public class Children {
    private String nameChildren;
    private String ageChildren;

    public Children(String nameChildren, String ageChildren){
        this.nameChildren = nameChildren;
        this.ageChildren = ageChildren;
    }
    @Override
    public String toString(){
        return String.format("%s %s",this.nameChildren,this.ageChildren);
    }
}
