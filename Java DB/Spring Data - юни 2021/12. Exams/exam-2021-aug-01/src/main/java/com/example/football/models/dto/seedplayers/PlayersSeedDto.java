package com.example.football.models.dto.seedplayers;

import com.example.football.config.LocalDateAdapter;

import javax.persistence.Enumerated;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.LocalDate;

@XmlAccessorType(XmlAccessType.FIELD)
public class PlayersSeedDto {

    @XmlElement(name = "first-name")
    private String firstName;
    @XmlElement(name = "last-name")
    private String lastName;
    @XmlElement
    private String email;
    @XmlElement(name = "birth-date")
    @XmlJavaTypeAdapter(LocalDateAdapter.class)
    private LocalDate birthDate;
    @XmlElement
    private String position;
    @XmlElement
    private TownSeedDto town;
    @XmlElement
    private TeamSeedDto team;
    @XmlElement
    private StatSeedDto stat;

    public StatSeedDto getStat() {
        return stat;
    }

    public void setStat(StatSeedDto stat) {
        this.stat = stat;
    }

    @Size(min = 3)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    @Size(min = 3)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Email
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    @Enumerated
    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public TownSeedDto getTown() {
        return town;
    }

    public void setTown(TownSeedDto town) {
        this.town = town;
    }

    public TeamSeedDto getTeam() {
        return team;
    }

    public void setTeam(TeamSeedDto team) {
        this.team = team;
    }
}
