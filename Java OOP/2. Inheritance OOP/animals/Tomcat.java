package animals;

public class Tomcat extends Cat {

    private static final String SOUND_TOMCAT = "MEOW";
    private static final String GENDER_TOMCAT = "Male";

    public Tomcat(String name, int age) {
        super(name, age, SOUND_TOMCAT);
        super.produceSound();
    }

    @Override
    public String getGender() {
        return GENDER_TOMCAT;
    }
}
