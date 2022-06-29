package com.example.exam25.model.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
public class UserEntity extends BaseEntity {

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "email", nullable = false)
    private String email;

    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<SongEntity> playlist;

    public UserEntity() {
    }

    public String getUsername() {
        return username;
    }

    public UserEntity setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserEntity setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserEntity setPassword(String password) {
        this.password = password;
        return this;
    }

    public List<SongEntity> getPlaylist() {
        return playlist;
    }

    public void setPlaylist(List<SongEntity> playlist) {
        this.playlist = playlist;
    }

    public void addSongToPlaylist(SongEntity song) {
        if (this.playlist.stream().noneMatch(s -> s.getId().equals(song.getId()))) {
            this.playlist.add(song);
        }
    }


    public void removeAllSongsFromPlaylist(){
        this.playlist.clear();
    }

    public boolean equals(Object o){
        if(this == o){
            return true;
        }
        if (o==null || getClass() != o.getClass()){
            return false;
        }
        UserEntity user = (UserEntity) o;

        return getId().equals(user.getId())
                && getUsername().equals(user.getUsername())
                && getPassword().equals(user.getPassword())
                && getEmail().equals((user.getEmail()));
    }

    public int hashCode(){
//        return Object.hash(getId(), getUsername(), getPassword(), getEmail());
        return 0;
    }
}








