package halfLife;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class PlayerTests {

    @Test(expected = NullPointerException.class)
    public void userNameCannotBeNull() {
        Player username = new Player(null, 1);
        assertEquals("Cannot be null!", username.getUsername());
    }

    @Test(expected = NullPointerException.class)
    public void userNameCannotBeLowThanOneSymbol() {
        Player username = new Player("", 1);
        assertEquals("Cannot be null!", username.getUsername());
    }

    @Test(expected = IllegalArgumentException.class)
    public void userHealthCannotBeNegative() {
        Player username = new Player("Rami", -1);
        assertEquals("Health cannot be bellow zero!", username.getHealth());
    }

    @Test
    public void testConstructorCreateInstance() {
        Player player = new Player("Pesho", 100);
        assertNotNull(player);
    }

    @Test
    public void testGetUserName() {
        Player player = new Player("Pesho", 100);
        String actualName = player.getUsername();
        String expectedName = "Pesho";
        assertEquals(expectedName, actualName);
    }

    @Test
    public void testGetHealth() {
        Player player = new Player("Pesho", 100);
        int actualHealth = player.getHealth();
        int expectedHealth = 100;
        assertEquals(expectedHealth, actualHealth);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testSetHealth() {
        Player player = new Player("Pesho", -100);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testSetHealthPoint() {
        Player player = new Player("Pesho", -100);
        assertEquals("Health cannot be bellow zero!", player.getHealth());
    }

   @Test
    public void testTakeDamageBelowZero() {
        Player player = new Player("Pesho", 100);
        player.takeDamage(200);
        int actualHealth = player.getHealth();
        assertEquals(0,actualHealth);

    }
    @Test
    public void testTakeDamage() {
        Player player = new Player("Pesho", 100);
        player.takeDamage(20);
        int actualHealth = player.getHealth();
        int expectedHealth = 80;
        assertEquals(expectedHealth,actualHealth);
    }
    @Test
    public void testTakeDamageMoreThanHealth() {
        Player player = new Player("Pesho", 100);
        player.takeDamage(200);
        int actualHealth = player.getHealth();
        int expectedHealth = 0;
        assertEquals(expectedHealth,actualHealth);
    }
    @Test(expected = NullPointerException.class)
    public void testNullGun() {
        Player player = new Player("Pesho", 100);
        player.addGun(null);
        player.takeDamage(200);
    }
    @Test
    public void testAddGun() {
        Gun gun = new Gun("Rifle", 100);
        List<Gun> gunList = new ArrayList<>();
        gunList.add(gun);
        assertEquals(gunList.get(0),gun);
    }
    @Test
    public void testRemoveGun() {
        Player player = new Player("Pesho", 100);
        Gun gun = new Gun("Rifle", 100);
        Gun gun2 = new Gun("pistol", 10);
        player.addGun(gun);
        player.addGun(gun2);
        boolean actualResult = player.removeGun(gun);
        assertTrue(actualResult);
    }
    @Test
    public void testGetGun() {
        Gun gun = new Gun("Rifle", 100);
        Gun gun2 = new Gun("MM", 50);
        List<Gun> gunList = new ArrayList<>();
        gunList.add(gun);
        gunList.add(gun2);
        String nameGun = "Rifle";
        assertEquals(gunList.stream()
                .filter(p->p.getName().equals(nameGun))
                .findFirst().orElse(null),gun);
    }
    @Test
    public void testGetNullGun() {
        Player player = new Player("Pesho", 100);
        Gun gun = new Gun("Rifle", 100);
        Gun gun2 = new Gun("MM", 50);
        player.addGun(gun);
        player.addGun(gun2);
        String nameGun = "rerer";
        assertEquals(player.getGun(nameGun),null);
    }
}
