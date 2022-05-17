package bg.softuini.mobilele.model.entities;

import bg.softuini.mobilele.model.entities.enums.EngineEnum;
import bg.softuini.mobilele.model.entities.enums.TransmissionEnum;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name="offers")
public class OfferEntity  extends BaseEntity {
    @Enumerated(EnumType.STRING)
    private EngineEnum engine;
    private  String imageUrl;
    private int millage;
    private BigDecimal price;
    private int year;
    private String description;
    @Enumerated(EnumType.STRING)
    private TransmissionEnum transmission;
    @ManyToOne
    private ModelEntity model;

    @ManyToOne
    private UserEntity user;

    public EngineEnum getEngine() {
        return engine;
    }

    public OfferEntity setEngine(EngineEnum engine) {
        this.engine = engine;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public OfferEntity setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public int getMillage() {
        return millage;
    }

    public OfferEntity setMillage(int millage) {
        this.millage = millage;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public OfferEntity setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public TransmissionEnum getTransmission() {
        return transmission;
    }

    public OfferEntity setTransmission(TransmissionEnum transmission) {
        this.transmission = transmission;
        return this;
    }

    public ModelEntity getModel() {
        return model;
    }

    public OfferEntity setModel(ModelEntity model) {
        this.model = model;
        return this;
    }

    public UserEntity getUser() {
        return user;
    }

    public OfferEntity setUser(UserEntity user) {
        this.user = user;
        return this;
    }


    public int getYear() {
        return year;
    }

    public OfferEntity setYear(int year) {
        this.year = year;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public OfferEntity setDescription(String description) {
        this.description = description;
        return this;
    }

    @Override
    public String toString() {
        return "OfferEntity{" +
                "id=" + id +
                ", created=" + created +
                ", updated=" + updated +
                ", engine=" + engine +
                ", imageUrl='" + imageUrl + '\'' +
                ", millage=" + millage +
                ", price=" + price +
                ", year=" + year +
                ", description='" + description + '\'' +
                ", transmission=" + transmission +
                ", model=" + model +
                '}';
    }
}
