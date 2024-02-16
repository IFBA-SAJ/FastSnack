package br.edu.ifba.saj.ads.pweb.projeto20232.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
//fila gerada quando estiver algum produto sendo produzido
public class FilaAtendimento {
    public UUID id;
    public FilaEstabelecimento filaEstabelecimento;
    public String nome;
    private List<Pedido> pedidos;

    public FilaAtendimento(String nome) {
        this.nome = nome;
        this.pedidos = new ArrayList<>();
    }

    public void adicionarPedido(Pedido pedido) {
        this.pedidos.add(pedido);
    }
}