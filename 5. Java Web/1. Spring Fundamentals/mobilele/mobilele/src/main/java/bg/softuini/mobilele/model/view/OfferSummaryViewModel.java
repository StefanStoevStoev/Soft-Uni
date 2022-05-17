package bg.softuini.mobilele.model.view;

import bg.softuini.mobilele.model.entities.ModelEntity;
import bg.softuini.mobilele.model.entities.enums.EngineEnum;
import bg.softuini.mobilele.model.entities.enums.TransmissionEnum;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;

public class OfferSummaryViewModel {

    private EngineEnum engine;
    private  String imageUrl;
    private int millage;
    private BigDecimal price;
    private int year;
    private TransmissionEnum transmission;

    public EngineEnum getEngine() {
        return engine;
    }

    public OfferSummaryViewModel setEngine(EngineEnum engine) {
        this.engine = engine;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public OfferSummaryViewModel setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public int getMillage() {
        return millage;
    }

    public OfferSummaryViewModel setMillage(int millage) {
        this.millage = millage;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public OfferSummaryViewModel setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public int getYear() {
        return year;
    }

    public OfferSummaryViewModel setYear(int year) {
        this.year = year;
        return this;
    }

    public TransmissionEnum getTransmission() {
        return transmission;
    }

    public OfferSummaryViewModel setTransmission(TransmissionEnum transmission) {
        this.transmission = transmission;
        return this;
    }
}
