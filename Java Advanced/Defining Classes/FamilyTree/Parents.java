package FamilyTree;

public class Parents {
    private String nameParents;
    private String ageParents;

    public Parents(String nameParents,String ageParents){
        this.nameParents = nameParents;
        this.ageParents = ageParents;
    }
    @Override
    public String toString(){
        return String.format("%s %s",nameParents,ageParents);
    }
}
