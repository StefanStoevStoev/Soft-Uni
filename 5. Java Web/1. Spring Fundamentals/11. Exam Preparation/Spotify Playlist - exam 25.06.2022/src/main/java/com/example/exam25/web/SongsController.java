package com.example.exam25.web;

import com.example.exam25.model.DTO.SongDTO;
import com.example.exam25.model.entity.SongEntity;
import com.example.exam25.service.SongService;
import com.example.exam25.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class SongsController {

    private final SongService songService;
    private final UserService userService;
    private final HttpSession httpSession;

    public SongsController(SongService songService, UserService userService, HttpSession httpSession) {
        this.songService = songService;
        this.userService = userService;
        this.httpSession = httpSession;
    }

    @GetMapping("add")
    public String addSong() {
        if (this.httpSession.getAttribute("name") != null) {
            return "redirect:/";
        }
        return "song-add";
    }

    @PostMapping("add")
    public String addSong(@Valid SongDTO songDTO,
                           BindingResult bindingResult,
                           RedirectAttributes redirectAttributes) {

        if (this.httpSession.getAttribute("name") != null) {
            return "redirect:/";
        }

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("songDTO", songDTO);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.songDTO", bindingResult);
            return "redirect:/add";
        }
        this.songService.addSong(songDTO);

        return "redirect:/home";
    }

    @GetMapping("/save/{id}")
    public String saveSong(@PathVariable("id") Long songId){
        if (this.httpSession.getAttribute("name") != null) {
            return "redirect:/";
        }
        SongEntity songEntity = this.songService.getById(songId);
        this.userService.saveSong(songEntity);
        return "redirect:/home";
    }

    @GetMapping("clear")
    public String clearPlaylist(){
        if (this.httpSession.getAttribute("name") != null) {
            return "/";
        }
        this.userService.cleanPlaylist();
        return "redirect:/home";
    }

    @ModelAttribute("songDTO")
    private SongDTO initForm() {
        return new SongDTO();
    }
}
