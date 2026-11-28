package Base;

import Base.Cliente.Cliente;
import Base.Loja.CriandoProdutos;
import Base.Loja.Estoque;

public class Main{

    public static void main(String[] arg){

        CriandoProdutos.montarEstoque();

        Cliente jp = new Cliente("Cleber", 21);
        jp.adicionarProdutoCarrinho("café", 3);
        jp.adicionarProdutoCarrinho("refrigerante", 5);
        jp.adicionarProdutoCarrinho("leite", 12);
        jp.adicionarProdutoCarrinho("arroz", 5);
        jp.verificarCarrinho();

        jp.removerProdutoCarrinho("arroz");
        jp.verificarCarrinho();



    }

}
