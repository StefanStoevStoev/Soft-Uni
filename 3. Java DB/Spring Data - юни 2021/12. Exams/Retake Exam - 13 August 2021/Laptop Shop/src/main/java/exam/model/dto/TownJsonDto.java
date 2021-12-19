package exam.model.dto;

import com.google.gson.annotations.Expose;

import javax.validation.constraints.Size;

public class TownJsonDto {

    @Expose
    private String name;

    public TownJsonDto() {
    }

    @Size(min = 2)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
