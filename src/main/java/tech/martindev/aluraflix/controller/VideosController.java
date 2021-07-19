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

    /**
     * Recupera com método GET um vídeo e recebe em seu path a id do mesmo,
     * e retorna uma resposta de status HTTP do servidor, também realiza uma chamada
     * para a classe de serviços para realizar a regra de negócio
     *
     * @param id : Long
     * @return
     */
    @ResponseStatus(HttpStatus.FOUND)
    @GetMapping(path = "/videos/{id}")
    public VideosEntity getVideo(@PathVariable @NotNull Long id) {
        return videosService.getVideo(id);
    }

    /**
     * Recupera com método GET uma lista de vídeos e envia um pedido
     * para a classe Service realizar a regra de negócio.
     *
     * @return
     */
    @ResponseStatus(HttpStatus.FOUND)
    @GetMapping(path = "/videos")
    public List<VideosEntity> getVideos(){
        return videosService.getVideos();
    }

    /**
     * Realiza um requisição POST para criar o vídeo, recebendo no corpo em JSON os atributos
     * e com atributos titulo, descricao e URL
     * e realiza uma chamada para a classe de serviçõs realizar
     * a regra de negócio.
     *
     * @param videosEntity : videosEntity
     */
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(path = "/videos")
    public void postVideo(@RequestBody @NotEmpty VideosEntity videosEntity){
        videosService.postVideo(videosEntity);
    }

    /**
     * Recebe no path a ID do vídeo utilizando o método PUT com corpo em JSON
     * e com atributos titulo, descricao e URL
     * e realiza uma chamada para a classe de serviçõs realizar
     * a regra de negócio.
     *
     * @param id : Long
     * @param videosEntity : VideosEntity
     * @return
     */
    @PutMapping(path = "/videos/{id}")
    public ResponseEntity<VideosEntity> putVideo(@PathVariable @NotBlank Long id, @RequestBody VideosEntity videosEntity){
        return videosService.putVideo(id, videosEntity);
    }

    /**
     * Irá receber a ID via path com método DELETE e envia um pedido para a classe VideosService
     * para assim realizar a regra de negócio e deletar.
     *
     * @param id : Long
     * @return
     */
    @DeleteMapping(path = "videos/{id}")
    public ResponseEntity<VideosEntity> deleteVideo(@PathVariable Long id){
        return videosService.deleteVideo(id);
    }
}
