package com.example.songr.controller;

import com.example.songr.Album;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.ArrayList;
import java.util.List;

@Controller
public class AlbumController {
    @GetMapping("/albums")
    public String albums(Model model) {

        List<Album> albums = new ArrayList<>();
        albums.add(new Album("Album 1", "Artist 1", 1, 100, "./assets/image1.png"));
        albums.add(new Album("Album 2", "Artist 2", 2, 200, "./assets/image2.png"));
        albums.add(new Album("Album 3", "Artist 3", 3, 300, "./assets/image3.png"));

        model.addAttribute("albums", albums);
        return "albums.html";

    }
}