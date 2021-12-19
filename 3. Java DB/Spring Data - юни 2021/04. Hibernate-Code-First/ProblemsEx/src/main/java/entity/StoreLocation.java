package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "store_location")
public class StoreLocation extends BaseEntity {

    private String locationName;
    private Set<Sale> sale;

    public StoreLocation() {
        this.sale = new HashSet<>();
    }

    @Column(name = "location_name", nullable = false, unique = true)
    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    @OneToMany(mappedBy = "storeLocationId")
    public Set<Sale> getSale() {
        return sale;
    }

    public void setSale(Set<Sale> sale) {
        this.sale = sale;
    }
}
