package akisselplayer.com.demo.domain.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;


@Getter
@Setter
@Entity
@Table(name = "edicao")
public class Edicao
{
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private long id;
    private int numero;
    private int ano;
    private Date data_inicial;
    private Date data_final;
    private String cidade;

    @ManyToOne
    private Evento evento;

    // getters e setters utilizando lombok.

}
