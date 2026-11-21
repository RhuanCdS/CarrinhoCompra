package Base;

import Base.Cliente.Carrinho.CarrinhoCompra;
import Base.Cliente.Cliente;
import Base.Loja.ClasseAnonima.VerificacaoEstoque;
import Base.Loja.Estoque;
import Base.Loja.Produto;

public class Main{

    public static void main(String[] arg){

        Estoque e = Estoque.criarEstoque();

        //adicionando as verificações nos produtos usando classes anônimas
        e.adicionarVerificacao(new VerificacaoEstoque() {
            @Override
            public void verificarProdutos(Produto p) {
                    System.out.println("Produto " + p.getNome() + " com quantidade baixa. Adicione mais estoque!!!");
                    System.out.println("Qtd: " + p.getQtd());
            }
        });

        e.adicionarVerificacao(new VerificacaoEstoque() {
            private int totalAviso = 0;

            @Override
            public void verificarProdutos(Produto p) {
                totalAviso++;
                System.out.println("[AVISO] " + totalAviso + " produtos com estoque baixo.");
            }
        });


        Produto arroz = new Produto("Arroz", 10.98, 25);
        e.adicionarProduto(arroz);

        Produto bala = new Produto("bala halls", 2.50, 15);
        e.adicionarProduto(bala);

        Produto suco = new Produto("suco", 8.50, 50);
        e.adicionarProduto(suco);

        Produto feijao = new Produto("Feijão", 7.90, 20);
        e.adicionarProduto(feijao);

        Produto macarrao = new Produto("Macarrão", 4.50, 30);
        e.adicionarProduto(macarrao);

        Produto oleo = new Produto("Óleo", 6.80, 12);
        e.adicionarProduto(oleo);

        Produto cafe = new Produto("Café", 12.90, 8);
        e.adicionarProduto(cafe);

        Produto leite = new Produto("Leite", 5.20, 40);
        e.adicionarProduto(leite);

        Produto biscoito = new Produto("Biscoito", 3.75, 25);
        e.adicionarProduto(biscoito);

        Produto refrigerante = new Produto("Refrigerante", 7.50, 18);
        e.adicionarProduto(refrigerante);

        e.listarProdutos();
        System.out.printf("");

        Cliente jp = new Cliente("jp", 15);
        jp.adicionarProdutoCarrinho("café", 3);
        jp.adicionarProdutoCarrinho("refrigerante", 5);
        jp.adicionarProdutoCarrinho("leite", 12);
        jp.adicionarProdutoCarrinho("arroz", 5);
        jp.verificarCarrinho();

        System.out.printf("\n===============================\n");

        e.listarProdutos();

        jp.removerProdutoCarrinho("arroz");
        jp.verificarCarrinho();

        System.out.printf("\n===============================\n");
        e.listarProdutos();


    }

}
