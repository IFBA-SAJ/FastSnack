package br.edu.ifba.saj.ads.pweb.projeto20232.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.annotations.GenericGenerator;

import java.util.List;
import java.util.UUID;

@Entity
public class Estabelecimento extends PanacheEntityBase {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    public UUID id;
    @NotBlank(message = "Razão social do estabelecimento não pode ser vazio")
    public String razaoSocial;

    @NotBlank(message = "Nome fantasia do estabelecimento não pode ser vazio")
    public String nomeFantasia;
    @NotBlank(message = "CNPJ do estabelecimento não pode ser vazio")
    public String cnpj;
    public String endereco;

    @OneToOne(mappedBy = "estabelecimento", cascade = CascadeType.ALL)
    public Cardapio cardapio;

//    private List<Comanda> comandas;
//    public List<FilaEstabelecimento> filasEstabelecimento;

    @JsonIgnore
    @OneToMany(mappedBy = "estabelecimento", cascade = CascadeType.ALL)
    public List<Produto> produtos;

    @JsonIgnore
    @OneToMany(mappedBy = "estabelecimento", cascade = CascadeType.ALL)
    public List<FilaEstabelecimento> filaEstabelecimentos;
}

