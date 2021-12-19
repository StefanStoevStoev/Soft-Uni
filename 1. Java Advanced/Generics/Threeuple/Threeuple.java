package Threeuple;

public class Threeuple <T1,T2,T3>{
    private T1 item1;
    private T2 item2;
    private T3 item3;
    public Threeuple(T1 item1, T2 item2,T3 item3) {
        this.item1 = item1;
        this.item2 = item2;
        this.item3 = item3;
    }

    public T1 getItem1() {
        return item1;
    }
    public T2 getItem2() {
        return item2;
    }
    public T3 getItem3(){return item3;}

    public static boolean drunkOrNot(String drunk){
        if(drunk.equals("drunk")){
            return true;
        }
        return false;
    }

    @Override
    public String toString(){
        String first = "" + item1;
        String second = "" + item2;
        String third = "" + item3;
        return String.format("%s -> %s -> %s",first,second,third);
    }
}
