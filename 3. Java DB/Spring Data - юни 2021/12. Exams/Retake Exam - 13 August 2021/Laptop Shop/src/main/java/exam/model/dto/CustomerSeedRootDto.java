package exam.model.dto;

import com.google.gson.annotations.Expose;
import exam.model.dto.shopseed.TownDto;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

public class CustomerSeedRootDto {

    @Expose
    private String firstName;
    @Expose
    private String lastName;
    @Expose
    private String email;
    @Expose
    private String registeredOn;
    @Expose
    private TownJsonDto town;

    public CustomerSeedRootDto() {
    }
    @Email(regexp = "^\\S+@\\S+\\.\\S+$")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Size(min = 2)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Size(min = 2)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    public String getRegisteredOn() {
        return registeredOn;
    }

    public void setRegisteredOn(String registeredOn) {
        this.registeredOn = registeredOn;
    }

    public TownJsonDto getTown() {
        return town;
    }

    public void setTown(TownJsonDto town) {
        this.town = town;
    }
}
