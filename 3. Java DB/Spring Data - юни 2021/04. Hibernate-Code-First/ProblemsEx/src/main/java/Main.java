import entity.Diagnose;
import entity.MedicalInsurance;
import entity.Patient;
import entity.Visitation;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {

    private static final EntityManager entityManager = Persistence
            .createEntityManagerFactory("softuni")
            .createEntityManager();

    public static void main(String[] args) throws ParseException, IOException {

        System.out.println("Problem Four, Doctor can fill information ina cases:");
        System.out.println("If you want to input new patient to the system, enter 1");
        System.out.println("If you want fill data for the patient from Visitation enter 2");
        System.out.println("If you want fill data for the patient Diagnose enter 3:");

        int reader = Integer.parseInt(readerConsole());

        switch (reader) {
            case 1 -> fillDataForThePatient();
            case 2 -> patientWriteInformationOfVisitations();
            case 3 -> patientWriteInformationOfDiagnose();
        }
    }

    private static void patientWriteInformationOfDiagnose() throws IOException {

        System.out.println("Write patient id:");
        Patient patient = new Patient();
        Long id = Long.parseLong(readerConsole());
        patient.setId(id);

        System.out.println("Diagnose name:");
        String name = readerConsole();

        System.out.println("Diagnose comments:");
        String comments = readerConsole();

        entityManager.getTransaction().begin();

        Diagnose diagnose = new Diagnose();
        diagnose.setPatient(patient);
        diagnose.setName(name);
        diagnose.setComments(comments);
        entityManager.persist(diagnose);

        entityManager.getTransaction().commit();

    }

    private static void patientWriteInformationOfVisitations() throws IOException {

        System.out.println("Write patient id:");
        Patient patient = new Patient();
        Long id = Long.parseLong(readerConsole());
        patient.setId(id);

        System.out.println("Write visitation date:");
        String date = readerConsole();

        System.out.println("Write visitation comments:");
        String comments = readerConsole();

        entityManager.getTransaction().begin();

        Visitation visitation = new Visitation();
        visitation.setPatient(patient);
        visitation.setDate(date);
        visitation.setComments(comments);
        entityManager.persist(visitation);

        entityManager.getTransaction().commit();

    }

    private static void fillDataForThePatient() throws ParseException, IOException {

        System.out.println("Input first name:");
        String firstName = readerConsole();

        System.out.println("Input last name:");
        String lastName = readerConsole();

        System.out.println("Input date of birth in format yyyy-mm-dd:");
        String dateOfBirth = takeDateOfBirth();
        Date date = new SimpleDateFormat("yyyy-MM-dd").parse(dateOfBirth);

        System.out.println("Input address:");
        String address = readerConsole();

        System.out.println("Input email:");
        String email = takeEmail();

        System.out.println("Input medical insurance(yes/no):");
        MedicalInsurance medicalInsurance = MedicalInsurance.valueOf(readerConsole());

        entityManager.getTransaction().begin();

        Patient patient = new Patient();
        patient.setFirstName(firstName);
        patient.setLastName(lastName);
        patient.setDateOfBirth(dateOfBirth);
        patient.setAddress(address);
        patient.setEmail(email);
        patient.setMedicalInsurance(medicalInsurance);
        entityManager.persist(patient);

        entityManager.getTransaction().commit();
    }

    private static String takeEmail() throws IOException {

        while (true){
            String read = readerConsole();
            if (!read.contains("@")&&!read.contains(".")){
                System.out.println("Plese, enter valid email:");
            }else {
                return read;
            }
        }
    }

    private static String takeDateOfBirth() throws IOException {
        while (true) {

            String dateOfBirth = readerConsole();
            String[] read = dateOfBirth.split("-");
            if (read.length != 3) {
                System.out.println("Please, follow the example format.");
                continue;
            }

            String year = read[0];
            if (Integer.parseInt(year) < 1900 ||
                    Integer.parseInt(year) > 2021) {
                System.out.println("Please, enter valid year.");
                continue;
            }

            String month = read[1];
            if (Integer.parseInt(month) < 1 ||
                    Integer.parseInt(month) > 12) {
                System.out.println("Please, enter valid month.");
                continue;
            }
            String day = read[2];
            if (Integer.parseInt(month) < 1 ||
                    Integer.parseInt(month) > 31) {
                System.out.println("Please, enter valid day of month.");
                continue;
            }
            return dateOfBirth;
        }
    }

    private static String readerConsole() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        return reader.readLine();
    }
}
