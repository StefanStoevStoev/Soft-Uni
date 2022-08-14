package com.example.irrigation2.model.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "projects")
public class ProjectEntity extends BaseEntity {

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(columnDefinition = "TEXT")
    private String drawing;

    @ManyToMany
    private List<UserEntity> user;

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

    public List<UserEntity> getUser() {
        return user;
    }

    public ProjectEntity setUser(List<UserEntity> user) {
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
