package com.example.football.models.dto.seedstats;

import javax.validation.constraints.Min;
import javax.validation.constraints.Positive;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "stat")
@XmlAccessorType(XmlAccessType.FIELD)
public class StatsSeedDto {

    @XmlElement
    private Float passing;
    @XmlElement
    private Float shooting;
    @XmlElement
    private Float endurance;

    @Positive
    @Min(1)
    public Float getPassing() {
        return passing;
    }

    public void setPassing(Float passing) {
        this.passing = passing;
    }
    @Positive
    @Min(1)
    public Float getShooting() {
        return shooting;
    }

    public void setShooting(Float shooting) {
        this.shooting = shooting;
    }

    @Positive
    @Min(1)
    public Float getEndurance() {
        return endurance;
    }

    public void setEndurance(Float endurance) {
        this.endurance = endurance;
    }
}
