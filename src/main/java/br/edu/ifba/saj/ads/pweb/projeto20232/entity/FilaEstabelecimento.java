package br.edu.ifba.saj.ads.pweb.projeto20232.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
//fila cadastrada pelo dono do estabelecimento
@Entity
public class FilaEstabelecimento extends PanacheEntityBase {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    public UUID id;
    public String nome;

    @JsonIgnore
    @OneToMany(mappedBy = "filaEstabelecimento", cascade = CascadeType.ALL)
    public List<Produto> produtos;

    @ManyToOne
    public Estabelecimento estabelecimento;
//    public FilaAtendimento filaAtendimento;
}