package br.edu.ifba.saj.ads.pweb.projeto20232.entity;

import java.util.List;
import java.util.UUID;

public class Pagamento {
    public UUID id;
    public Comanda comanda;
    public List<ItemRateio> rateio;
    //para saber o pagamento parcial atual deve somar o valor de `valorPago` mais os valore do `rateio`
    //para alterar SituacaoPagamento para "PagamentoConcluido" o valor da soma de `valorPago` com `rateio` deve ser igual ao valor total da comanda
    public SituacaoPagamento situacaoPagamento;
    
}