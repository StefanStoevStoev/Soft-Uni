package bakery;

import java.util.ArrayList;

public class Bakery {
    private String name;
    private int capacity;
    private ArrayList<Employee> employees;

    public Bakery(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.employees = new ArrayList<>();
    }

    public void add(Employee employee) {
        if (this.employees.size() < this.capacity) {
            this.employees.add(employee);
        }
    }

    public boolean remove(String name) {
        return employees.removeIf(e -> e.getName().equals(name));
    }

    public Employee getOldestEmployee() {
        int maxAge = 0;
        Employee oldestEmployee = employees.get(0);

        for (Employee employee : employees) {

            if (employee.getAge()>maxAge){
                maxAge = employee.getAge();
                oldestEmployee = employee;
            }
        }
        return oldestEmployee;
    }
    public Employee getEmployee(String name){
        Employee nameEmployee = employees.get(0);
        for (Employee employee : employees) {
            if(employee.getName().equals(name)){
                nameEmployee = employee;
            }
        }
        return nameEmployee;
    }
    public int getCount(){
        return this.employees.size();
    }
    public String report(){
        String rep =String.format("Employees working at Bakery %s:%n",this.name);
        for (Employee employee : this.employees) {
            rep += String.format("%s%n",employee.toString());
        }
        return rep.toString().trim();
    }

}
