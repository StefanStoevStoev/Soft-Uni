package exam.shop.model.entities;

import exam.shop.model.entities.enums.CategoryEnum;

import javax.persistence.*;

@Entity
@Table(name = "categories")
public class CategoryEntity extends BaseEntity{

    private CategoryEnum name;
    private String description;

    public CategoryEntity() {
    }

    public CategoryEntity(CategoryEnum name, String description) {
        this.name = name;
        this.description = description;
    }
    @Enumerated(EnumType.STRING)
    @Column(name = "name", unique = true)
    public CategoryEnum getName() {
        return name;
    }

    public CategoryEntity setName(CategoryEnum name) {
        this.name = name;
        return this;
    }
    @Column(name = "description", columnDefinition = "TEXT")
    public String getDescription() {
        return description;
    }

    public CategoryEntity setDescription(String description) {
        this.description = description;
        return this;
    }
}
