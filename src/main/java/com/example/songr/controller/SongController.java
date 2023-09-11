package com.example.songr.controller;

import com.example.songr.exception.AlbumNotFoundException;
import com.example.songr.models.Album;
import com.example.songr.models.Song;
import com.example.songr.repository.AlbumRepository;
import com.example.songr.repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
public class SongController {

    @Autowired
    AlbumRepository albumRepository;
    @Autowired
    SongRepository songRepository;

    @GetMapping("/get-all-songs")
    public String getAllSongs(Model model) {
        List<Song> song = songRepository.findAll();
        model.addAttribute("song", song);
        return "songs.html";
    }

    @PostMapping("/add-song")
    public RedirectView addSongToAlbum(String titleSong, int length, int trackNumber, Long albumId) {

        Album album = albumRepository.
                findById(albumId).
                orElseThrow(() -> new AlbumNotFoundException("No Album With this Id"));

        Song song = new Song(titleSong, length, trackNumber, album);
        songRepository.save(song);
        return new RedirectView("/albums");
    }

    @GetMapping("/albumSongDetails/{id}")
    public String getAlbumAndSongDetails(@PathVariable Long id, Model model) {

        Album album = albumRepository.findById(id).orElseThrow(() -> new AlbumNotFoundException("Error ...!"));
        model.addAttribute("album", album);
        model.addAttribute("songs", album.getSongList());

        return "albumSongDetails.html";
    }
}
