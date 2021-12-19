package animals;

public class Animal {

    private String name;
    private int age;
    private String gender;
    private String sound;

    public Animal(String name, int age,  String sound, String gender){
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.sound = sound;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public String getSound() {
        return sound;
    }

    public String produceSound() {
        return this.sound = sound;
    }

    @Override
    public String toString(){
        return String.format("%s%n%s %d ",this.getClass().getSimpleName(),this.name, this.age);
    }
}
