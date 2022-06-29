package com.example.exam25.model.DTO;

import com.example.exam25.model.entity.enums.StyleEnum;
import org.springframework.expression.spel.ast.Selection;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Enumerated;
import javax.validation.constraints.*;
import java.time.LocalDate;

public class SongDTO {

    @NotBlank(message = "Title cannot be empty.")
    @Size(min = 3, max = 20)
    private String performer;

    @NotBlank(message = "Title cannot be empty.")
    @Size(min = 2, max = 20)
    private String title;

    @PastOrPresent
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate releaseDate;

    @Positive
    private int duration;

    public String durationInMinutes;

    @NotNull
    @Enumerated
    private StyleEnum style;

    public SongDTO() {
    }

    public String getPerformer() {
        return performer;
    }

    public SongDTO setPerformer(String performer) {
        this.performer = performer;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public SongDTO setTitle(String title) {
        this.title = title;
        return this;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public SongDTO setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
        return this;
    }

    public int getDuration() {
        return duration;
    }
    public SongDTO setDuration(int duration) {
        this.duration = duration;
        return this;
    }

    public SongDTO setDurationInMinutes(String durationInMinutes) {
        this.durationInMinutes = durationInMinutes;
        return this;
    }

    public String getDurationInMinutes() {
        long sum = this.getDuration();

        long MM = sum / 60;
        long SS = sum % 60;
        return String.format("%02d:%02d", MM, SS);
    }



    public StyleEnum getStyle() {
        return style;
    }

    public SongDTO setStyle(StyleEnum style) {
        this.style = style;
        return this;
    }
}
