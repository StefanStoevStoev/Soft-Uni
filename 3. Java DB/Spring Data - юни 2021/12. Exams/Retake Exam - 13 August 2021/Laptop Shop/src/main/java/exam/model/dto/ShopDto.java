package exam.model.dto;

import com.google.gson.annotations.Expose;

import javax.validation.constraints.Size;

public class ShopDto {

    @Expose
    private String name;

    public ShopDto() {
    }

    @Size(min = 4)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
