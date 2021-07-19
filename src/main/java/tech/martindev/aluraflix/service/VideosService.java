package tech.martindev.aluraflix.service;

import org.springframework.stereotype.Service;
import tech.martindev.aluraflix.entities.VideosEntity;
import tech.martindev.aluraflix.repository.VideosRepository;

import java.util.List;

@Service
public class VideosService {
    private final VideosRepository videosRepository;

    public VideosService(VideosRepository videosRepository){
        this.videosRepository = videosRepository;
    }

    public VideosEntity getVideo(Long id){
        return videosRepository.findById(id).stream().findFirst().orElseThrow();
    }

    public List<VideosEntity> getVideos(){
        return videosRepository.findAll();
    }

    public void postVideo(VideosEntity videosEntity){
        videosRepository.save(videosEntity);
    }

    public void putVideo(Long id, VideosEntity videosEntity){
        videosRepository.findById(id).ifPresent(videos -> {
            videosRepository.save(videosEntity);
        });
    }

    public void deleteVideo(Long id){
        videosRepository.findById(id).orElseThrow();
        videosRepository.deleteById(id);
    }
}
