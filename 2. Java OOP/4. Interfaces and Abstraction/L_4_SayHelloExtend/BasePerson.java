package L_4_SayHelloExtend;

public abstract class BasePerson implements Person{

    //BasePerson(name)
    //+getName(): String
    //-setName(): void

    private String name;

    protected BasePerson(String name) {
        this.name = name;
    }

    private void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }
}
