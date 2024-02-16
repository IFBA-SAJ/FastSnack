package br.edu.ifba.saj.ads.pweb.projeto20232.entity;

import java.util.Currency;

public class ItemRateio {
    public Pedido pedido;
    public Cliente cliente;
    public Currency valor;

    //@Transient
    public Currency valorPago; //obtido por `valor` ou pelo valor do pedido
    /*
new ItemRateio(null, "Leandro", 200);
new ItemRateio(pizza1, "Yuri", null);pizza1.valor
new ItemRateio(pizza2, "Yuri", null);pizza2.valor
     */


}


