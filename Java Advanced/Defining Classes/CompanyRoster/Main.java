package CompanyRoster;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());

        Map<String, Department> mapDepartments = new HashMap<>();

        while (n-- > 0) {
            String[] token = scan.nextLine().split("\\s+");

            String name = token[0];
            double salary = Double.parseDouble(token[1]);
            String position = token[2];
            String department = token[3];

            Employee employee;
            if (token.length == 4) {
                employee = new Employee(name, salary, position, department);
            } else if (token.length == 6) {
                String mail = token[4];
                int age = Integer.parseInt(token[5]);
                employee = new Employee(name, salary, position, department, mail, age);
            } else {
                try {
                    int age = Integer.parseInt(token[4]);
                    employee = new Employee(name, salary, position, department, age);
                } catch (Exception ex) {
                    String mail = token[4];
                    employee = new Employee(name, salary, position, department, mail);
                }
            }
            Department depart = new Department(department);
            mapDepartments.putIfAbsent(department,depart);
            mapDepartments.get(department).getEmployees().add(employee);
        }
        Department maxDepart = mapDepartments
                .entrySet()
                .stream()
                .max(Comparator.comparingDouble(e->e.getValue().takeAvSalary()))
                .get()
                .getValue();

        System.out.printf("Highest Average Salary: %s%n",maxDepart.getName());

        maxDepart.getEmployees()
                .stream()
                .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                .forEach(System.out::println);
    }
}
