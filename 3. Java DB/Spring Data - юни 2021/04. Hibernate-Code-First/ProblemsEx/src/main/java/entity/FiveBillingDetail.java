package entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "billing_details")
@Inheritance(strategy = InheritanceType.JOINED)
public class FiveBillingDetail extends BaseEntity {

    private String number;
    private FiveUsers owner;

    public FiveBillingDetail() {
    }

    @Column(nullable = false,unique = true)
    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @ManyToOne
    public FiveUsers getOwner() {
        return owner;
    }

    public void setOwner(FiveUsers owner) {
        this.owner = owner;
    }

}
