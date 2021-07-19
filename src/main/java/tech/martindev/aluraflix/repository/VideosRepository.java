package tech.martindev.aluraflix.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tech.martindev.aluraflix.entities.VideosEntity;

@Repository
public interface VideosRepository extends JpaRepository<VideosEntity, Long> {
}
