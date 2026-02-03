package com.dantruong.my_mp3.controller;

import com.dantruong.my_mp3.entity.Music;
import com.dantruong.my_mp3.service.MusicService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


@Controller
public class MusicController {

    private final MusicService musicService;

    public MusicController(MusicService musicService) {
        this.musicService = musicService;
    }

    @GetMapping("/music/application")
    public String getForm(Model model){
      model.addAttribute("music", new Music());
        return "index";
    }



    @PostMapping("/create-music")
    public  String  createMusic(@ModelAttribute("music") Music music, @RequestParam MultipartFile file) throws IOException {
        String fileName = file.getOriginalFilename();
        Path fileNameAndPath = Paths.get("musicFile", fileName);
        Files.write(fileNameAndPath, file.getBytes());
        music.setMusicPath(fileName);
        musicService.InserMusic(music);
        return "redirect:/view";
    }




    // truc nang trong view

    @PostMapping("/delete/{id}")
    public String deleteMusic(@PathVariable("id") Integer id, Model model){
      String status = musicService.deleteMusic(id);
      model.addAttribute("status", status);
      return "redirect:/view";
    }

    @GetMapping("/view")
    public String viewMusicPage(@RequestParam(required = false) String keyWord, Model model) {
        if (keyWord != null && !keyWord.isEmpty()) {
            model.addAttribute("musicList", musicService.findMusic(keyWord));
            model.addAttribute("keyWord", keyWord);
        } else {
            model.addAttribute("musicList", musicService.showMusic());
        }
        return "view";
    }
}
