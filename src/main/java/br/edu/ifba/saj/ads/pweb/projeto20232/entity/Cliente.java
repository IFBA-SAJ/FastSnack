package br.edu.ifba.saj.ads.pweb.projeto20232.entity;

import java.util.UUID;

import org.hibernate.annotations.GenericGenerator;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Cliente extends PanacheEntityBase {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    public UUID id;
    @NotBlank(message = "Nome não pode ser vazio")
    public String nome;
    @NotBlank(message = "CPF não pode ser vazio")
    public String cpf;
    public String endereco;

}