package br.edu.ifba.saj.ads.pweb.projeto20232.entity;

import java.beans.Transient;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Comanda {
    public UUID id;
    public List<Cliente> clientes;
    //@Transient //perguntar para o pagamento
    public boolean contaFechada;//pagamento
    private List<Pedido> pedidos;
    public Pagamento pagamento;

    public Comanda(Cliente cliente) {
        this.clientes = new ArrayList<>();
        this.pedidos = new ArrayList<>();
    }

    public void adicionarPedido(Pedido pedido) {
        this.pedidos.add(pedido);
    }

    public void realizarPagamento(double valor) {
  
    }

    public double getTotalConta(){
        return 0d;
    }
}