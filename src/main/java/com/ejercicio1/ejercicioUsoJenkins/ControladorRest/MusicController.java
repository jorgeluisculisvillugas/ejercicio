package com.ejercicio1.ejercicioUsoJenkins.ControladorRest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ejercicio1.ejercicioUsoJenkins.ServicioYouTube.YouTubeService;

import java.io.IOException;
import java.util.List;

@RestController
public class MusicController {

    private final YouTubeService youTubeService;

    @Autowired
    public MusicController(YouTubeService youTubeService) {
        this.youTubeService = youTubeService;
    }

    @GetMapping("/search")
    public List<String> searchMusic(@RequestParam String query) {
        try {
            return youTubeService.searchVideos(query);
        } catch (IOException e) {
            e.printStackTrace();
            return List.of("Error: Unable to search videos.");
        }
    }
}

