package entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "visitation")
public class Visitation extends BaseEntity {

    private String date;
    private String comments;
    private Patient patient;

    public Visitation() {
    }

    @Column
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Column(name = "commens", columnDefinition = "TEXT")
    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    @ManyToOne
    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
}
