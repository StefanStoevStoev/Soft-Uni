package com.example.exam25.model.view;

import com.example.exam25.model.entity.enums.StyleEnum;

import java.math.BigDecimal;

public class SongsViewModel {
    private Long id;
    private String performer;
    private String title;
    private String duration;
    private String style;

    private double durationSeconds;

    public SongsViewModel() {
    }

    public Long getId() {
        return id;
    }

    public SongsViewModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getPerformer() {
        return performer;
    }

    public SongsViewModel setPerformer(String performer) {
        this.performer = performer;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public SongsViewModel setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getDuration() {
        return duration;
    }

    public SongsViewModel setDuration(String duration) {
        this.duration = duration;
        return this;
    }

    public String getStyle() {
        return style;
    }

    public SongsViewModel setStyle(String style) {
        this.style = style;
        return this;
    }

    public double getDurationSeconds() {
        return durationSeconds;
    }

    public SongsViewModel setDurationSeconds(double durationSeconds) {
        this.durationSeconds = durationSeconds;
        return this;
    }
}
