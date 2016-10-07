package com.example.aluno.oceancoffee;

/**
 * Created by aluno on 07/10/2016.
 */

public class Pedido {
    private int quantidade;
    private int preco;
    private boolean hasCreme;
    private boolean hasChocolate;
    private String nome;

    public Pedido(int quantidade, int preco, boolean hasCreme, boolean hasChocolate, String nome) {
        this.quantidade = quantidade;
        this.preco = preco;
        this.hasCreme = hasCreme;
        this.hasChocolate = hasChocolate;
        this.nome = nome;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public int getPreco() {
        return preco;
    }

    public void setPreco(int preco) {
        this.preco = preco;
    }

    public boolean isHasCreme() {
        return hasCreme;
    }

    public void setHasCreme(boolean hasCreme) {
        this.hasCreme = hasCreme;
    }

    public boolean isHasChocolate() {
        return hasChocolate;
    }

    public void setHasChocolate(boolean hasChocolate) {
        this.hasChocolate = hasChocolate;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
