package tech.martindev.aluraflix.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VideosEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @NotEmpty(message = "O título não pode estar vazio.")
    private String titulo;

    @Column
    @NotEmpty(message = "A descrição não pode estar vazia.")
    private String descricao;

    @Column
    @NotEmpty(message = "A URL não pode estar vazia.")
    private String url;

}
