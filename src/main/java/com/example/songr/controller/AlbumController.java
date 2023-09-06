package com.example.songr.controller;

import com.example.songr.models.Album;
import com.example.songr.repository.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
public class AlbumController {

//    @GetMapping("/albums")
//    public String albums(Model model) {
//
//        List<Album> albums = new ArrayList<>();
//        albums.add(new Album("Album 1", "Artist 1", 1, 100, "./assets/image1.png"));
//        albums.add(new Album("Album 2", "Artist 2", 2, 200, "./assets/image2.png"));
//        albums.add(new Album("Album 3", "Artist 3", 3, 300, "./assets/image3.png"));
//
//        model.addAttribute("albums", albums);
//        return "albums.html";
//
//    }

    @Autowired
    AlbumRepository albumRepository;

    @GetMapping("/albums")
    public String getAllAlbums(Model model){
        List<Album> albumList = albumRepository.findAll();
        model.addAttribute("albums",albumList);
        return "albums.html";
    }


    @PostMapping("/add-new-album")
    public RedirectView addAlbum(String title, String artist, String songCountStr, String lengthStr, String imageUrl){

        int songCount ;
        int length;
        try {
            songCount = Integer.parseInt(songCountStr);
            length = Integer.parseInt(lengthStr);
        } catch (NumberFormatException e) {
            return new RedirectView("/errorHandle");
        }

        Album newAlbum = new Album(title , artist , songCount , length , imageUrl);
        albumRepository.save(newAlbum);
        return new RedirectView("/albums");
    }

//    @DeleteMapping("/delete/{albumId}")
//    public RedirectView deleteAlbum(@PathVariable Long albumId){
//        albumRepository.deleteById(albumId);
//        return new RedirectView("/albums");
//    }

    @GetMapping("/errorHandle")
    public String error(Model model){
        return "errorInavlidInput.html";
    }


}