package StudentSystemResources;

public interface StudentRepository {
    /**
     * Check weather the repository contains a student with the given name.
     * @param name of student to look for.
     * @return true if student is found, fals otherwise.
     */
    boolean containsStudentWith(String name);

    /**
     * Given a student name, return the student from the repository.
     * @param name of the student to fetch.
     * @return the student with the given name, uf present.
     * null if not present.
     */
    Student findBy(String name);

    /**
     * Add student to the repository.
     * @param student to be persisted.
     */
    void save(Student student);

}

