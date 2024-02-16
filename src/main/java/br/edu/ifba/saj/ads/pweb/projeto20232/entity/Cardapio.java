package br.edu.ifba.saj.ads.pweb.projeto20232.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.List;
import java.util.UUID;
@Entity
public class Cardapio extends PanacheEntityBase {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    public UUID id;
    @OneToOne
    public Estabelecimento estabelecimento;
    @OneToMany(mappedBy = "cardapio", cascade = CascadeType.ALL)
    public List<Combo> combos;
    @OneToMany(mappedBy = "cardapio", cascade = CascadeType.ALL)
    public List<Produto> produtos;

}