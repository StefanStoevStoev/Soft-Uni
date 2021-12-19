package heroRepository;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class HeroRepositoryTests {

    private List<Hero> heroes;
    private Hero heroNull;
    private Hero hero1;
    private Hero hero2;
    private Hero hero3;

    @Before
    public void Before(){
        heroNull = new Hero(null, 3);
        hero1 = new Hero("Pesho", 5);
        hero2 = new Hero("Ivan", 7);
    }
    @Test
    public void test_Null_Hero(){
        Collection<Hero> heroes = new ArrayList<>();
        heroes.add(hero1);
        heroes.add(hero2);

        int expected = 2;
        int actual = heroes.size();
        assertEquals(expected,actual);
    }
    @Test
    public void test_Count_Hero2(){
        Collection<Hero> heroes = new ArrayList<>();
        HeroRepository hh = new HeroRepository();
        hh.create(hero1);
        hh.create(hero2);
        int count = hh.getCount();

        int expected = 2;
        int actual = hh.getCount();
        assertEquals(expected,actual);
    }
    @Test
    public void test_Create_Hero3(){
        Collection<Hero> heroes = new ArrayList<>();
        HeroRepository hh = new HeroRepository();
        String actual = hh.create(hero1);
        String expected = String.format("Successfully added hero %s with level %d", hero1.getName(), hero1.getLevel());

        assertEquals(expected,actual);
    }
    @Test(expected = IllegalArgumentException.class)
    public void test_Create_Add(){
        Collection<Hero> heroes = new ArrayList<>();
        HeroRepository hh = new HeroRepository();
        hh.create(hero1);
        hh.create(hero1);

    }
    @Test(expected = NullPointerException.class)
    public void test_Create_Null(){
        Collection<Hero> heroes = new ArrayList<>();
        HeroRepository hh = new HeroRepository();
        Hero hero = null;
        hh.create(hero);
    }
    @Test
    public void test_Remove(){
        Collection<Hero> heroes = new ArrayList<>();
        HeroRepository hh = new HeroRepository();
        heroes.add(hero1);
        heroes.add(hero2);
        heroes.add(hero3);
        heroes.remove(hero1);

        assertFalse(heroes.contains(hero1));
    }
    @Test(expected = NullPointerException.class)
    public void test_Remove_Null(){
        Collection<Hero> heroes = new ArrayList<>();
        HeroRepository hh = new HeroRepository();
        Hero hero = null;
        hh.create(hero);
    }

    @Test
    public void test_Get_HeroByLevel(){
        Collection<Hero> heroes = new ArrayList<>();
        HeroRepository hh = new HeroRepository();
        Hero her1 = new Hero("'ds",1);
        hh.create(her1);
        Hero her2 = new Hero("'fdf",2);
        hh.create(her2);

        assertEquals(her2, hh.getHeroWithHighestLevel());
    }
    @Test
    public void test_Get_Hero(){
        HeroRepository hh = new HeroRepository();
        Hero her1 = new Hero("ds",1);
        hh.create(her1);
        Hero hero = hh.getHero("ds");
        assertEquals(her1, hero);
    }
    @Test
    public void test_GetHeroes_Hero(){
        Collection<Hero> heroes = new ArrayList<>();
        heroes.add(hero1);

        HeroRepository hh = new HeroRepository();
        hh.create(hero1);

        assertEquals(hero1,hh.getHero("Pesho"));
    }
    @Test
    public void test_GetHeroes(){
        Hero[] heroes = new Hero[]{hero1,hero2};

        HeroRepository hh = new HeroRepository();
        hh.create(hero1);
        hh.create(hero2);
        Collection<Hero> heroes1 = hh.getHeroes();

        assertArrayEquals(heroes, heroes1.toArray());
    }
}
