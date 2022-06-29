package com.example.exam25.model.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "songs")
public class SongEntity extends BaseEntity{

    @Column(nullable = false)
    private String performer;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private int duration;


    private LocalDate releaseDate;

    @ManyToOne
    private StyleEntity style;

//    @ManyToMany
//    private List<UserEntity> userEntities;

    public SongEntity() {
    }

//    public List<UserEntity> getUserEntities() {
//        return userEntities;
//    }
//
//    public SongEntity setUserEntities(List<UserEntity> userEntities) {
//        this.userEntities = userEntities;
//        return this;
//    }

    public String getPerformer() {
        return performer;
    }

    public SongEntity setPerformer(String performer) {
        this.performer = performer;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public SongEntity setTitle(String title) {
        this.title = title;
        return this;
    }

    public int getDuration() {
        return duration;
    }

    public SongEntity setDuration(int duration) {
        this.duration = duration;
        return this;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public SongEntity setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
        return this;
    }

    public StyleEntity getStyle() {
        return style;
    }

    public SongEntity setStyle(StyleEntity style) {
        this.style = style;
        return this;
    }

    public String getDurationInMinutes() {
        long sum = this.getDuration();

        long MM = sum / 60;
        long SS = sum % 60;
        return String.format("%02d:%02d", MM, SS);
    }
}
