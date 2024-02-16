package br.edu.ifba.saj.ads.pweb.projeto20232.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.annotations.GenericGenerator;

import java.util.Currency;
import java.util.List;
import java.util.UUID;

@Entity
public class Combo extends PanacheEntityBase {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    public UUID id;
    @NotBlank(message = "Nome do combo obrigatório")
    public String nome;
    @NotBlank(message = "Descrição do combo obrigatória")
    public String descricao;
    @Min(value = 0, message = "Valor minimo é 0")
    public float preco;

    @JsonIgnore
    @OneToMany(mappedBy = "combo", cascade = CascadeType.ALL)
    public List<Produto> produtos;

    @ManyToOne
    public Cardapio cardapio;
}