package blueOrigin;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;

import static org.junit.Assert.*;

public class SpaceshipTests {
    private Astronaut astronaut1;
    private Astronaut astronaut2;
    private Astronaut astronaut3;
    @Before
    public void Before(){
        astronaut1 = new Astronaut("Gosho",20.00);
        astronaut2 = new Astronaut("Pesho",50.00);
        astronaut3 = new Astronaut("Kiro",80.00);
    }
    @Test
    public void Test_Constructor_Name(){//////
        String expected = "Gosho";
        String actual = astronaut1.getName();
        assertEquals(expected,actual);
    }
    @Test
    public void Test_Constructor_Capacity(){
        int expected = 12;
        Spaceship ss = new Spaceship("Gosho",12);
        int actual = ss.getCapacity();

        assertEquals(expected,actual);
    }
    @Test
    public void Test_Constructor_Astronauts(){
        Astronaut expected = astronaut1;
        Collection<Astronaut> actual = new ArrayList<>();
        actual.add(astronaut1);

        assertEquals(expected,actual.toArray()[0]);
    }
    @Test
    public void Test_GetCount(){
        int expected = 1;
        Spaceship actual = new Spaceship("gf",23);
        actual.add(astronaut1);
        int count = actual.getCount();
        assertEquals(expected,count);
    }
    @Test
    public void Test_GetName(){
        String expected = "gf";
        Spaceship actual = new Spaceship("gf",23);

        String count = actual.getName();
        assertEquals(expected,count);
    }
    @Test
    public void Test_GetCapacity(){
        int expected = 23;
        Spaceship actual = new Spaceship("Gofri",23);

        int count = actual.getCapacity();
        assertEquals(expected,count);
    }
    @Test
    public void Test_Add(){
        Collection<Astronaut> actual = new ArrayList<>();
        actual.add(astronaut1);
        assertEquals(astronaut1,actual.toArray()[0]);
    }
    @Test(expected = IllegalArgumentException.class)
    public void Test_Add_Size(){
        Spaceship actual = new Spaceship("Gofri",1);
        actual.add(astronaut1);
        actual.add(astronaut2);
    }
    @Test(expected = IllegalArgumentException.class)
    public void Test_Add_CapacityError(){
        Spaceship actual = new Spaceship("Gofri",1);
        actual.add(astronaut1);
        actual.add(astronaut2);
    }


    @Test(expected = IllegalArgumentException.class)
    public void Test_Add_Exists2(){
        Spaceship actual = new Spaceship("Gofri",5);
        actual.add(astronaut1);
        actual.add(astronaut1);
    }
    @Test
    public void Test_Remove(){
        Spaceship actual = new Spaceship("Gofri",1);
        actual.add(astronaut1);
        boolean gofri = actual.remove("Gosho");
        assertTrue(gofri);
    }
    @Test
    public void Test_Remove_Null(){
        Spaceship actual = new Spaceship("Gofri",1);
        boolean gofri = actual.remove("Gofriii");
        assertFalse(gofri);
    }
    @Test(expected = IllegalArgumentException.class)
    public void Test_setCapacity(){
        Spaceship actual = new Spaceship("Gofri",-1);

    }
    @Test(expected = NullPointerException.class)
    public void Test_setName_Null(){
        Spaceship actual = new Spaceship(null,1);

    }
    @Test(expected = NullPointerException.class)
    public void Test_setName_Empty(){
        Spaceship actual = new Spaceship("",1);

    }
    @Test(expected = NullPointerException.class)
    public void Test_setName_Space(){
        Spaceship actual = new Spaceship("  ",1);

    }
    @Test
    public void Test_Oxygen_Percentage(){
        double oxygenInPercentage = astronaut1.getOxygenInPercentage();
        double expected = 20.00;
        assertEquals(expected,oxygenInPercentage,0);
    }
}
