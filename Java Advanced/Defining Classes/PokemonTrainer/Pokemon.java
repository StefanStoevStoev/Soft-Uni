package PokemonTrainer;

public class Pokemon {
//    name, an element and health
    private String name;
    private String element;
    private int health;

    public Pokemon(String name, String element, int health){
        this.name = name;
        this.element = element;
        this.health = health;
    }

    public void setHealth() {
        this.health -=10;
    }
    public int getHealth(){
        return health;
    }
    public String getElement(){
        return element;
    }

    public String getName() {
        return name;
    }
}
