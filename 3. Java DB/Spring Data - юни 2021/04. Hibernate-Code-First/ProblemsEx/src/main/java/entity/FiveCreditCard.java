package entity;

import javax.persistence.*;

@Entity
@Table(name = "credit_card")
public class FiveCreditCard extends FiveBillingDetail{

    private FiveCardType cardType;
    private Integer expirationMonth;
    private Integer expirationYear;

    public FiveCreditCard() {
    }

    @Enumerated(EnumType.STRING)
    public FiveCardType getCardType() {
        return cardType;
    }

    public void setCardType(FiveCardType cardType) {
        this.cardType = cardType;
    }

    @Column(name = "expiration_month")
    public Integer getExpirationMonth() {
        return expirationMonth;
    }

    public void setExpirationMonth(Integer expirationMonth) {
        this.expirationMonth = expirationMonth;
    }

    @Column(name = "expiration_year")
    public Integer getExpirationYear() {
        return expirationYear;
    }

    public void setExpirationYear(Integer expirationYear) {
        this.expirationYear = expirationYear;
    }

}