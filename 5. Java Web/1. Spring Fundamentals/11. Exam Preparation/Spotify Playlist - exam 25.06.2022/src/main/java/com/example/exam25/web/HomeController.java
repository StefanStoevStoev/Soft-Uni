package com.example.exam25.web;

import com.example.exam25.model.entity.enums.StyleEnum;
import com.example.exam25.seasson.CurrentUser;
import com.example.exam25.service.SongService;
import com.example.exam25.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    private final CurrentUser currentUser;
    private final UserService userService;
    private final SongService songService;

    public HomeController(CurrentUser currentUser, UserService userService, SongService songService) {
        this.currentUser = currentUser;
        this.userService = userService;
        this.songService = songService;
    }

    @GetMapping("/home")
    private String getHome(Model model) {
        if (!currentUser.isLoggedIn()) {
            return "index";
        }

        if (!model.containsAttribute("userPlaylist")) {
            model.addAttribute("userPlaylist", this.userService.getPlaylist());
        }

        if (!model.containsAttribute("playlistDuration")) {
            model.addAttribute("playlistDuration", this.userService.getPlaylistDuration());
        }

        if (!model.containsAttribute("popSongs")) {
            model.addAttribute("popSongs", this.songService.getStyleSongs(StyleEnum.POP));
        }

        if (!model.containsAttribute("rockSongs")) {
            model.addAttribute("rockSongs", this.songService.getStyleSongs(StyleEnum.ROCK));
        }

        if (!model.containsAttribute("jazzSongs")) {
            model.addAttribute("jazzSongs", this.songService.getStyleSongs(StyleEnum.JAZZ));
        }

        return "home";
    }


    @GetMapping("/logout")
    public String logout() {
        currentUser.logout();
        return "index";
    }
}
