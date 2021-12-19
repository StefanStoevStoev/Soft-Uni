package garage;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class GarageTests {

    private Car carNull;
    private Car car1;
    private Car car2;
    private Car car3;
    @Before
    public void initialCar(){
        carNull = null;
        car1 = new Car("Lada", 140, 2300.00);
        car2 = new Car("Shkoda", 160, 5300.00);
        car3 = new Car("Trabant", 120, 5300.00);
    }
    @Test
    public void test_Constructor(){
        List<Car> cars = new ArrayList<>();
        cars.add(car1);
        cars.add(car2);
        assertEquals(cars.get(0),car1);
        assertEquals(cars.get(1),car2);
    }
    @Test(expected = IllegalArgumentException.class)
    public void test_addCar_Null(){
        Garage garage = new Garage();
        garage.addCar(carNull);
    }
    @Test
    public void test_addCar() {

        Garage garage = new Garage();
        garage.addCar(car1);
        assertEquals(garage.getCars().get(0),car1);
    }
    @Test
    public void test_getCount(){
        Garage garage = new Garage();
        garage.addCar(car1);
        garage.addCar(car2);
        int count = garage.getCount();
        assertEquals(2,count);
    }
    @Test
    public void test_getCars(){
        Garage garage = new Garage();
        garage.addCar(car1);
        garage.addCar(car2);

        assertEquals(garage.getCars().get(0),car1);
        assertEquals(garage.getCars().get(1),car2);
    }
    @Test
    public void test_findAllCarsWithMaxSpeedAbove_Null(){
        Garage garage = new Garage();
        garage.addCar(car1);
        garage.addCar(car2);
        int maxSpeed = 180;
        List<Car> allCarsWithMaxSpeedAbove = garage.findAllCarsWithMaxSpeedAbove(maxSpeed);

        assertEquals(0,allCarsWithMaxSpeedAbove.size());
    }
    @Test
    public void test_findAllCarsWithMaxSpeedAbove_1(){
        Garage garage = new Garage();
        garage.addCar(car1);
        garage.addCar(car2);
        int maxSpeed = 140;
        List<Car> allCarsWithMaxSpeedAbove = garage.findAllCarsWithMaxSpeedAbove(maxSpeed);

        assertEquals(1,allCarsWithMaxSpeedAbove.size());
    }
    @Test
    public void test_findAllCarsWithMaxSpeedAbove_2(){
        Garage garage = new Garage();
        garage.addCar(car1);
        garage.addCar(car2);
        int maxSpeed = 139;
        List<Car> allCarsWithMaxSpeedAbove = garage.findAllCarsWithMaxSpeedAbove(maxSpeed);

        assertEquals(2,allCarsWithMaxSpeedAbove.size());
    }
    @Test
    public void test_getTheMostExpensiveCar_FirstCar(){
        Garage garage = new Garage();
        garage.addCar(car2);
        garage.addCar(car3);
        Car theMostExpensiveCar = garage.getTheMostExpensiveCar();

        assertEquals(0,Double.compare(car2.getPrice(),theMostExpensiveCar.getPrice()));
    }
    @Test
    public void test_getTheMostExpensiveCar_IfNoCars(){
        Garage garage = new Garage();
        Car car = garage.getTheMostExpensiveCar();
        assertNull(car);
    }
    @Test
    public void test_findAllCarsByBrand_IfNoCarsWithBrand(){
        Garage garage = new Garage();
        garage.addCar(car1);
        garage.addCar(car2);
        garage.addCar(car3);
        String brand = "Volvo";
        List<Car> allCarsByBrand = garage.findAllCarsByBrand(brand);
        assertEquals(0,allCarsByBrand.size());
    }
    @Test
    public void test_findAllCarsByBrand_1(){
        Garage garage = new Garage();
        garage.addCar(car1);
        garage.addCar(car2);
        garage.addCar(car3);
        String brand = "Lada";
        List<Car> allCarsByBrand = garage.findAllCarsByBrand(brand);
        assertEquals(1,allCarsByBrand.size());
    }
}