package tech.martindev.aluraflix.controller;

import com.sun.istack.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.martindev.aluraflix.entities.VideosEntity;
import tech.martindev.aluraflix.service.VideosService;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@RestController
public class VideosController {

    private final VideosService videosService;

    public VideosController(VideosService videosService){
        this.videosService = videosService;
    }

    @ResponseStatus(HttpStatus.FOUND)
    @GetMapping(path = "/videos/{id}")
    public VideosEntity getVideo(@PathVariable @NotNull Long id) {
        return videosService.getVideo(id);
    }

    @ResponseStatus(HttpStatus.FOUND)
    @GetMapping(path = "/videos")
    public List<VideosEntity> getVideos(){
        return videosService.getVideos();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(path = "/videos")
    public void postVideo(@RequestBody @NotEmpty VideosEntity videosEntity){
        videosService.postVideo(videosEntity);
    }

    @PutMapping(path = "/videos/{id}")
    public ResponseEntity<VideosEntity> putVideo(@PathVariable @NotBlank Long id, @RequestBody VideosEntity videosEntity){
        return videosService.putVideo(id, videosEntity);
    }

    @DeleteMapping(path = "videos/{id}")
    public ResponseEntity<VideosEntity> deleteVideo(@PathVariable Long id){
        return videosService.deleteVideo(id);
    }
}
