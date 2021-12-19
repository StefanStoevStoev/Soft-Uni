package farmville;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;

public class FarmvilleTests {
    @Test
    public void testAnimalType(){
        Animal animal = new Animal("mamal", 12.6);

        String expected = "mamal";
        String actual = animal.getType();

        Assert.assertEquals(expected,actual);
    }
    @Test
    public void testAnimalEnergy(){
        Animal animal = new Animal("mamal", 12.6);

        double expected = 12.6;
        double actual = animal.getEnergy();

        Assert.assertEquals(expected,actual,0.0);
    }
    @Test
    public void testFarmGetCount(){
        Farm farm = new Farm("pxol", 12);

        Collection<Animal> animal = new ArrayList<>();

        Animal animal1 = new Animal("mamal", 12.6);
        Animal animal2 = new Animal("feline", 50);
        animal.add(animal1);
        animal.add(animal2);

        int expected = 2;
        int actual = farm.getCount();

        Assert.assertEquals(expected,actual,2);
    }

    @Test
    public void testFarmGetName(){
        Farm farm = new Farm("pxol", 12);

        String expected = "pxol";
        String actual = farm.getName();

        Assert.assertEquals(expected,actual);
    }

    @Test
    public void testFarmGetCapacity(){
        Farm farm = new Farm("pxol", 12);

        int expected = 12;
        int actual = farm.getCapacity();

        Assert.assertEquals(expected,actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFarmAddWrongCapacity(){
        Farm farm = new Farm("pxol", 1);

        Collection<Animal> animal = new ArrayList<>();

        Animal animal1 = new Animal("mamal", 12.6);
        Animal animal2 = new Animal("feline", 50);

        farm.add(animal1);
        farm.add(animal2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFarmAddRepeatAnimal(){
        Farm farm = new Farm("pxol", 2);

        Collection<Animal> animal = new ArrayList<>();

        Animal animal1 = new Animal("mamal", 12.6);
        Animal animal2 = new Animal("feline", 50);

        farm.add(animal1);
        farm.add(animal1);
    }
    @Test
    public void testFarmRemoveAnimal(){
        Farm farm = new Farm("pxol", 2);

        Collection<Animal> animal = new ArrayList<>();

        Animal animal1 = new Animal("mamal", 12.6);
        Animal animal2 = new Animal("feline", 50);

        farm.add(animal1);
        farm.add(animal2);
        farm.remove(animal1.getType());

        int expected = 1;
        int actual = farm.getCount();
        Assert.assertEquals(expected,actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFarmCapacityBelowZero(){
        Farm farm = new Farm("pxol", -2);
    }

    @Test(expected = NullPointerException.class)
    public void testFarmNameNull(){
        Farm farm = new Farm(null, 2);
    }

    @Test(expected = NullPointerException.class)
    public void testFarmNameSpace(){
        Farm farm = new Farm(" ", 2);
    }

    @Test
    public void testFarmNotRemoveAnimal(){
        Farm farm = new Farm("pxol", 2);

        Collection<Animal> animal = new ArrayList<>();

        Animal animal1 = new Animal("mamal", 12.6);
        Animal animal2 = new Animal("feline", 50);

        farm.add(animal1);
        farm.add(animal2);
        farm.remove(animal1.getType());
        farm.remove(animal1.getType());

        int expected = 1;
        int actual = farm.getCount();
        Assert.assertEquals(expected,actual);
    }
}
