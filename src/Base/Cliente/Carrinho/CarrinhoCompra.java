package Base.Cliente.Carrinho;

import Base.Loja.Estoque;

import java.util.ArrayList;
import java.util.List;

public class CarrinhoCompra {

    private final List<ItemCarrinho> carrinho = new ArrayList<>();

    private final Estoque estoque = Estoque.criarEstoque();

    private double valorTotal(){
        double total = 0;
        for (ItemCarrinho item : carrinho) {
            total += item.getSubTotal();
        }
        return total;
    }

    public void adicionarProdutoCarrinho(String nomeProduto, int qtd){

       ItemCarrinho p = estoque.comprarProduto(nomeProduto, qtd);
       carrinho.add(p);

    }

    public void removerProdutoCarrinho(String nomeProduto){

        for (int i = 0; i < carrinho.size(); i++){
            ItemCarrinho item = carrinho.get(i);
            if(carrinho.get(i).getNome().toUpperCase().equals(nomeProduto.toUpperCase())){
                estoque.retornarProduto(item);
                carrinho.remove(i);
                return;
            }
        }

    }

    public void verificarCarrinho(){

        System.out.println("============= Seu Carrinho: ==============\n");
        for (ItemCarrinho n: carrinho){
            System.out.printf("Produto: %s | Preço: %.2f%n", n.getNome(), n.getPreco());
            System.out.println("Quantidade: " + n.getQtd());
        }

        System.out.println("\n========================================\n");
        System.out.println("Valor total do carrinho: ");
        System.out.printf("R$ %.2f%n", valorTotal());
    }

}
