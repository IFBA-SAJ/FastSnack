package br.edu.ifba.saj.ads.pweb.projeto20232.entity;

import java.beans.Transient;
import java.util.Currency;
import java.util.UUID;

public class Pedido {
    public UUID id;
    //@Transient
    public Currency valor;
    private Produto produto;
    private int quantidade;
    private String observacoes;
    public FilaAtendimento filaAtendimento;
}