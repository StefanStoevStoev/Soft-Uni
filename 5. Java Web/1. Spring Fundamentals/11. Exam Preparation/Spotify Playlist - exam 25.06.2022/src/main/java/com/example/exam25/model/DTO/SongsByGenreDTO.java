package com.example.exam25.model.DTO;

import java.util.List;

public class SongsByGenreDTO {

    private List<SongDTO> popSongs;
    private List<SongDTO> rockSongs;
    private List<SongDTO> jazzSongs;
    private List<SongDTO> currentUserSongs;

    public SongsByGenreDTO() {
    }

    public List<SongDTO> getPopSongs() {
        return popSongs;
    }

    public SongsByGenreDTO setPopSongs(List<SongDTO> popSongs) {
        this.popSongs = popSongs;
        return this;
    }

    public List<SongDTO> getRockSongs() {
        return rockSongs;
    }

    public SongsByGenreDTO setRockSongs(List<SongDTO> rockSongs) {
        this.rockSongs = rockSongs;
        return this;
    }

    public List<SongDTO> getJazzSongs() {
        return jazzSongs;
    }

    public SongsByGenreDTO setJazzSongs(List<SongDTO> jazzSongs) {
        this.jazzSongs = jazzSongs;
        return this;
    }

    public List<SongDTO> getCurrentUserSongs() {
        return currentUserSongs;
    }

    public SongsByGenreDTO setCurrentUserSongs(List<SongDTO> currentUserSongs) {
        this.currentUserSongs = currentUserSongs;
        return this;
    }
}
