package exam.model.dto.shopseed;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import java.math.BigDecimal;

@XmlAccessorType(XmlAccessType.FIELD)
public class ShopSeedDto {

    private String address;
    @XmlElement(name = "employee-count")
    private String employeeCount;
    @XmlElement
    private BigDecimal income;
    @XmlElement
    private String name;
    @XmlElement(name = "shop-area")
    private Integer shopArea;
    @XmlElement
    private TownDto town;

    public ShopSeedDto() {
    }

    @Size(min = 4)
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Min(1)
    @Max(50)
    public String getEmployeeCount() {
        return employeeCount;
    }

    public void setEmployeeCount(String employeeCount) {
        this.employeeCount = employeeCount;
    }

    @Min(20000)
    public BigDecimal getIncome() {
        return income;
    }

    public void setIncome(BigDecimal income) {
        this.income = income;
    }

    @Size(min = 4)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Min(150)
    public Integer getShopArea() {
        return shopArea;
    }

    public void setShopArea(Integer shopArea) {
        this.shopArea = shopArea;
    }


    public TownDto getTown() {
        return town;
    }

    public void setTown(TownDto town) {
        this.town = town;
    }
}
