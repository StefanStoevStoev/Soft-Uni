package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "sale")
public class Sale extends BaseEntity {

    private Product productId;
    private Customer customerId;
    private StoreLocation storeLocationId;
    private LocalDateTime date;

    public Sale() {
    }

    @ManyToOne
    public Product getProductId() {
        return productId;
    }

    public void setProductId(Product productId) {
        this.productId = productId;
    }

    @ManyToOne
    public Customer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Customer customerId) {
        this.customerId = customerId;
    }

    @ManyToOne
    public StoreLocation getStoreLocationId() {
        return storeLocationId;
    }

    public void setStoreLocationId(StoreLocation storeLocationId) {
        this.storeLocationId = storeLocationId;
    }

    @Column(name = "date")
    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}
