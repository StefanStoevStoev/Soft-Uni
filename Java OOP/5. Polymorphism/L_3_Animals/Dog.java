package L_3_Animals;

public class Dog extends Animal{

    public Dog(String name, String food) {
        super(name,food);

    }

    @Override
    public String explainSelf() {
        return String.format("%s%nDJAAF",super.explainSelf());
    }
}
