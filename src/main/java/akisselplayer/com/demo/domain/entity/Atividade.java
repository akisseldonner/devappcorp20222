package akisselplayer.com.demo.domain.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "atividade")
public class Atividade {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private long id;

    private String nome;
    private Enum tipo;
    private String descricao;
    private Date data;

    private Date hora_inicial;
    private Date hora_final;

    // getters e setters utilizando lombok.
}
