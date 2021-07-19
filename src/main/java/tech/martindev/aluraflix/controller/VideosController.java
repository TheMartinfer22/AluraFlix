package tech.martindev.aluraflix.controller;

import com.sun.istack.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import tech.martindev.aluraflix.entities.VideosEntity;
import tech.martindev.aluraflix.service.VideosService;

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
    public void postVideo(@RequestBody @NotNull VideosEntity videosEntity){
        videosService.postVideo(videosEntity);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping(path = "/videos/{id}")
    public void putVideo(@PathVariable @NotNull Long id, @RequestBody @NotNull VideosEntity videosEntity){
        videosService.putVideo(id, videosEntity);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(path = "videos/{id}")
    public void deleteVideo(@PathVariable @NotNull Long id){
        videosService.deleteVideo(id);
    }
}
