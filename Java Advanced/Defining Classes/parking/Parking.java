package parking;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Parking {
    private List<Car> data;
    private String type;
    private int capacity;

    public Parking(String type, int capacity) {
        this.type = type;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Car car) {
        if(this.data.size()<this.capacity){
            this.data.add(car);
        }
    }

    public List<Car> getData() {
        return data;
    }

    public void setData(List<Car> data) {
        this.data = data;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public boolean remove(String manufacturer, String model) {

        return data.removeIf(e->e.getModel().equals(model)&&e.getManufacturer().equals(manufacturer));
    }
    public Car getLatestCar(){

        return this.data.stream().max(Comparator.comparing(Car::getYear)).orElse(null);
    }
    public Car getCar(String manufacturer, String model){
         for (Car datum : this.data) {
            if(datum.getManufacturer().equals(manufacturer)&&datum.getModel().equals(model)){
                return datum;
            }
        }
         return null;
    }
    public int getCount(){
        return this.data.size();
    }
    public String getStatistics(){
        String dataL =String.format("The cars are parked in %s:%n",this.type);
        for (Car datum : this.data) {
            dataL += String.format("%s%n",datum.toString());
        }
        return dataL.toString().trim();
    }
}
