package vetClinic;

import java.util.ArrayList;
import java.util.List;

public class Clinic {
    private List<Pet> data;
    private int capacity;

    public Clinic(int capacity){
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }
    public void add(Pet pet){
        this.data.add(pet);
    }

    public boolean remove(String name){
        int count = 0;
        for (Pet datum : data) {
            if(datum.getName().equals(name)){
                data.remove(count);
                return true;
            }
            count += 1;
        }
        return false;
    }

    public Pet getPet(String name, String owner){
        for (Pet datum : data) {
            if (datum.getName().equals(name)&&datum.getOwner().equals(owner)){
                return datum;
            }
        }
        return null;
    }
    public Pet getOldestPet(){
        int maxAge = 0;
        Pet oldestPet = data.get(0);
        for (Pet datum : data) {

            if (datum.getAge()>maxAge){
                maxAge = datum.getAge();
                oldestPet = datum;
            }
        }
        return oldestPet;
    }
    public int getCount(){
        return data.size();
    }
    public String getStatistics(){
        String dataL = "The clinic has the following patients:\n";
        for (int k = 0; k < data.size(); k++) {
            dataL += String.format("%s %s%n", data.get(k).getName(), data.get(k).getOwner());
        }
        return dataL.toString().trim();
    }
}
