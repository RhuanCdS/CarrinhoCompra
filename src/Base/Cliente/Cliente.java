package Base.Cliente;

import Base.Cliente.Carrinho.CarrinhoCompra;
import Base.Cliente.Carrinho.ItemCarrinho;

public class Cliente {

    private String nome;
    private int idade;

    private final CarrinhoCompra carrinhoCompra;

    public Cliente(String nome, int idade){
        this.nome = nome;
        this.idade = idade;
        carrinhoCompra = new CarrinhoCompra();
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }


    public void adicionarProdutoCarrinho(String nomeProduto, int qtd){

        carrinhoCompra.adicionarProdutoCarrinho(nomeProduto, qtd);

    }

    public void removerProdutoCarrinho(String nomeProduto){
        carrinhoCompra.removerProdutoCarrinho(nomeProduto);
    }

    public void verificarCarrinho(){
        carrinhoCompra.verificarCarrinho();
    }
}
