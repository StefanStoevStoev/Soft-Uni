package computers;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class ComputerManagerTests {
    private ComputerManager computerManager;
    private Computer computer ;
    private Computer computer2;

    @Before
    public void setUp() {
        this.computerManager = new ComputerManager();
        this.computer = new Computer("DELL", "A4322", 300.00);
        this.computer2 = new Computer("ASUS", "V7657", 677.00);
    }
    @Test(expected = UnsupportedOperationException.class)
    public void testGetComputers(){
        computerManager.getComputers().remove(0);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testNullAdd() {
        this.computerManager.addComputer(null);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testSecondAdd() {
        this.computerManager.addComputer(computer);
        this.computerManager.addComputer(computer);
    }
    @Test
    public void testAdd() {
        this.computerManager.addComputer(computer);
        assertEquals(1, this.computerManager.getCount());
    }
    @Test(expected = IllegalArgumentException.class)
    public void testGet() {
        this.computerManager.getComputer(null, "test_model");
    }
    @Test(expected = IllegalArgumentException.class)
    public void testGet2() {
        this.computerManager.getComputer("test_man",null);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testGetNonExisting() {
        this.computerManager.getComputer(computer.getManufacturer(),computer.getModel());
    }
    @Test
    public void testGetReturnsCorrect() {
        computerManager.addComputer(computer2);
        computerManager.addComputer(computer);
        Computer returned = this.computerManager.getComputer(computer.getManufacturer(),computer.getModel());
        assertNotNull(returned);
        assertEquals(computer.getManufacturer(), returned.getManufacturer());
        assertEquals(computer.getModel(), returned.getModel());
    }
    @Test
    public void testGetByMan() {
        computerManager.addComputer(computer2);
        computerManager.addComputer(computer);
        List<Computer> list = computerManager.getComputersByManufacturer(computer.getManufacturer());
        assertNotNull(list);
        assertEquals(list.get(0).getManufacturer(), computer.getManufacturer());
    }
    @Test
    public void testGetByManWhenEmpty() {
        List<Computer> list = computerManager.getComputersByManufacturer(computer.getManufacturer());
        assertNotNull(list);
        assertTrue(list.isEmpty());
    }
}