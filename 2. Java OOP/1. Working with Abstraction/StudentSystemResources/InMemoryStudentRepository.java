package StudentSystemResources;

import java.util.HashMap;
import java.util.Map;

public class InMemoryStudentRepository implements StudentRepository {

    private final Map<String, Student> map;

    public InMemoryStudentRepository(){
        this.map = new  HashMap<>();
    }

    @Override
    public boolean containsStudentWith(String name) {
        return map.containsKey(name);
    }

    @Override
    public Student findBy(String name) {
        return map.get(name);
    }

    @Override
    public void save(Student student) {
        map.put(student.getName(),student);
    }
}
