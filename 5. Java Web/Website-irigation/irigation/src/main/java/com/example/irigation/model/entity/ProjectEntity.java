package com.example.irigation.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "projects")
public class ProjectEntity extends BaseEntity{

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(columnDefinition = "TEXT")
    private String drawing;

    @ManyToOne
    private UserEntity user;

    private LocalDateTime created;

    public ProjectEntity() {
    }

    public String getDescription() {
        return description;
    }

    public ProjectEntity setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getDrawing() {
        return drawing;
    }

    public ProjectEntity setDrawing(String drawing) {
        this.drawing = drawing;
        return this;
    }

    public UserEntity getUser() {
        return user;
    }

    public ProjectEntity setUser(UserEntity user) {
        this.user = user;
        return this;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public ProjectEntity setCreated(LocalDateTime created) {
        this.created = created;
        return this;
    }
}
