package br.edu.ifba.saj.ads.pweb.projeto20232.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.annotations.GenericGenerator;

import java.util.Currency;
import java.util.UUID;

@Entity
public class Produto extends PanacheEntityBase {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    public UUID id;
    @NotBlank(message = "Codigo do produto não pode ser vazio")
    public String codigo;
    @NotBlank(message = "Nome do produto não pode ser vazio")
    public String nome;
    @Min(value = 0, message = "Valor minimo é 0")
    public float preco;
    @NotBlank(message = "Descrição do produto não pode ser vazio")
    public String descricao;
    @ManyToOne
    public FilaEstabelecimento filaEstabelecimento;

    @ManyToOne
    public Estabelecimento estabelecimento; //para produtos produzidos por um estabelecimento

    @JsonIgnore
    @ManyToOne
    public Combo combo;

    @JsonIgnore
    @ManyToOne
    public Cardapio cardapio;
}