package L_3_Animals;

public class Cat extends Animal{

    public Cat(String name, String food) {
        super(name,food);
    }

    @Override
    public String explainSelf() {
        return String.format("%s%nMEEOW",super.explainSelf());
    }
}
