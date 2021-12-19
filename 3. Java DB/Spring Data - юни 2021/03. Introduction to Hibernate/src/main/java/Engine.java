import entities.Address;
import entities.Employee;
import entities.Project;
import entities.Town;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.stream.Stream;

public class Engine implements Runnable {

    private final EntityManager entityManager;
    private final BufferedReader bufferedReader;

    public Engine(EntityManager entityManager) {
        this.entityManager = entityManager;
        this.bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    }

    @Override
    public void run() {
        System.out.println("Select exercise number:");

        try {
            int exNumber = Integer.parseInt(bufferedReader.readLine());

            switch (exNumber) {
                case 2 -> problemTwo();
                case 3 -> problemThree();
                case 4 -> problemFour();
                case 5 -> problemFive();
                case 6 -> problemSix();
                case 7 -> problemSeven();
                case 8 -> problemEight();
                case 9 -> problemNine();
                case 10 -> problemTen();
                case 11 -> problemEleven();
                case 12 -> problemTwelve();
                case 13 -> problemThirteen();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
    }

    private void problemThirteen() throws IOException {
        System.out.println("Enter the town name:");
        String townName= bufferedReader.readLine();
        Town town = entityManager.createQuery(
                "SELECT t FROM Town t WHERE t.name = :t_name",Town.class)
                .setParameter("t_name", townName)
                .getSingleResult();



        int townsCount = removeAddressesByTownId(town.getId());

        entityManager.getTransaction().begin();
        entityManager.remove(town);
        entityManager.getTransaction().commit();

        System.out.printf("%d address in %s deleted", townsCount, townName);
    }

    @SuppressWarnings("unchecked")
    private void problemTwelve() {

        List<Object[]> resultList = entityManager.createNativeQuery("SELECT d.name, MAX(e.salary) as 'm' FROM departments d " +
                        "JOIN employees e on d.id = e.department_id \n" +
                "GROUP BY d.name\n" +
                "HAVING `m` < 30000 or `m` > 70000;")
                .getResultList();
        for (Object[] objects : resultList) {
            System.out.println(objects[0] + " " + objects[1]);
        }

    }

    private void problemEleven() throws IOException {

        System.out.println("Enter start letters of employee first name:");

        String  reader = bufferedReader.readLine();

        entityManager.createQuery("SELECT e FROM Employee e " +
                "WHERE e.firstName LIKE :names", Employee.class)
                .setParameter("names", reader + "%")
                .getResultList()
                .forEach(employee -> {
                    System.out.printf("%s %s - %s - ($%.2f)%n",
                            employee.getFirstName(),
                            employee.getLastName(),
                            employee.getJobTitle(),
                            employee.getSalary());
                });
    }

    private void problemTen() {

        entityManager.getTransaction().begin();

        int i = entityManager.createQuery("UPDATE Employee e SET e.salary = e.salary * 1.12 " +
                "WHERE e.department.id IN " +
                "(1, 2, 4, 11)")
                .executeUpdate();

        entityManager.getTransaction().commit();

        Stream<Employee> resultStream = entityManager.createQuery("SELECT e FROM Employee e WHERE e.department.id IN" +
                        " (1, 2, 4, 11)"
                , Employee.class)
                .getResultStream();

        resultStream
                .forEach(empl -> {
                    System.out.printf("%s %s ($%.2f)%n"
                            , empl.getFirstName()
                            , empl.getLastName()
                            , empl.getSalary());
                });
    }

    private void problemNine() {

        List<Project> resultList = entityManager.
                createQuery("SELECT p FROM Project p order by p.startDate DESC", Project.class)
                .setMaxResults(10).getResultList();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.s");

        resultList.stream().sorted(Comparator.comparing(Project::getName))
                .forEach(project -> {

                    System.out.printf("Project name: %s%n", project.getName());
                    System.out.printf("\tProject Description: %s%n", project.getDescription());
                    System.out.printf("\tProject Start Date: %s%n", formatter.format(project.getStartDate()));
                    System.out.printf("\tProject End Date: %s%n", project.getEndDate() == null ? null : formatter.format(project.getEndDate()));
                });
    }

    private void problemEight() throws IOException {
        System.out.println("Enter employee id:");

        int id = Integer.parseInt(bufferedReader.readLine());

        Employee employee = entityManager.find(Employee.class, id);

        System.out.printf("%s %s - %s%n", employee.getFirstName(),
                employee.getLastName(), employee.getJobTitle());

        employee.getProjects()
                .stream()
                .sorted(Comparator.comparing(Project::getName))
                .forEach(rr -> {
                    System.out.printf("\t%s%n", rr.getName());
                });
    }

    private void problemSeven() {
        List<Address> resultList = entityManager.createQuery(
                "SELECT a FROM Address a ORDER BY a.employees.size DESC", Address.class)
                .setMaxResults(10)
                .getResultList();

        resultList.forEach(address -> {
            System.out.printf("%s, %s - %d employees%n"
                    , address.getText()
                    , address.getTown() == null
                            ? "Unknown" : address.getTown().getName()
                    , address.getEmployees().size());
        });
    }

    private void problemSix() throws IOException {
        System.out.println("Enter employee last name:");
        String lastName = bufferedReader.readLine();

        Employee employee = entityManager.createQuery("SELECT e FROM Employee e " +
                "WHERE e.lastName = :l_name", Employee.class)
                .setParameter("l_name", lastName)
                .getSingleResult();
        Town town = employee.getAddress().getTown();

        Address address = createAddress("Vitoshka 15",town);

        entityManager.getTransaction().begin();
        employee.setAddress(address);
        entityManager.getTransaction().commit();
    }

    private void problemFive() {
        List<Employee> resultList = entityManager.createQuery("SELECT e FROM Employee e " +
                "WHERE e.department.name = :d_name " +
                "ORDER BY e.salary, e.id", Employee.class)
                .setParameter("d_name", "Research and Development")
                .getResultList();

        for (Employee empl : resultList) {
            System.out.printf("%s %s from %s - $%.2f%n", empl.getFirstName(),
                    empl.getLastName(), empl.getDepartment().getName()
                    , empl.getSalary());
        }
    }

    private void problemFour() {
        List<String> resultList = entityManager.createQuery("SELECT e.firstName FROM Employee e " +
                "WHERE e.salary > 50000", String.class).getResultList();
        for (String ss : resultList) {
            System.out.println(ss);
        }
    }

    private void problemThree() throws IOException {
        System.out.println("Enter employee name:");
        String[] nameEmplyoee = bufferedReader.readLine().split("\\s+");
        String firstName = nameEmplyoee[0];
        String lastName = nameEmplyoee[1];

        Long singleResult = entityManager.createQuery("SELECT count(e) FROM Employee e " +
                        "where e.firstName = :f_name AND e.lastName = :l_name",
                Long.class).
                setParameter("f_name", firstName)
                .setParameter("l_name", lastName)
                .getSingleResult();

        System.out.println(singleResult == 0 ? "No" : "Yes");
    }

    private void problemTwo() {
        entityManager.getTransaction().begin();

        Query query = entityManager.createQuery("UPDATE Town t SET" +
                " t.name = UPPER(t.name) WHERE length(t.name) <= 5");

        System.out.println(query.executeUpdate());

        entityManager.getTransaction().commit();
    }

    private Address createAddress(String addressText, Town townId) {
        Address address = new Address();
        address.setText(addressText);
        address.setTown(townId);

        entityManager.getTransaction().begin();
        entityManager.persist(address);
        entityManager.getTransaction().commit();
        return address;
    }

    private int removeAddressesByTownId(Integer id) {


        List<Address> resultList = entityManager.createQuery("SELECT a FROM Address a " +
                "WHERE a.town.id = :p_id",Address.class)
                .setParameter("p_id", id)
                .getResultList();

        entityManager.getTransaction().begin();
        resultList.forEach(entityManager::remove);
        entityManager.getTransaction().commit();

        return resultList.size();
    }
}
