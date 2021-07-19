package tech.martindev.aluraflix.service;

import org.springframework.beans.BeanUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import tech.martindev.aluraflix.entities.VideosEntity;
import tech.martindev.aluraflix.repository.VideosRepository;

import javax.transaction.Transactional;
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

    @Transactional
    public void postVideo(VideosEntity videosEntity){
        videosRepository.save(videosEntity);
    }

    @Transactional
    public ResponseEntity<VideosEntity> putVideo(Long id, VideosEntity videosEntity){
        if (!videosRepository.existsById(id)) return ResponseEntity.notFound().build();
        VideosEntity video = videosRepository.findById(id).orElseThrow();
        BeanUtils.copyProperties(videosEntity, video, "id");
        videosRepository.save(video);
        return ResponseEntity.ok().build();
    }

    @Transactional
    public ResponseEntity<VideosEntity> deleteVideo(Long id){
        if (!videosRepository.existsById(id)) return ResponseEntity.notFound().build();
        videosRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
