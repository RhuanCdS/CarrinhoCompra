package Base;

import Base.Loja.ClasseAnonima.VerificacaoEstoque;
import Base.Loja.Estoque;
import Base.Loja.Produto;

public class Main{

    public static void main(String[] arg){
        Estoque e = Estoque.criarEstoque();

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

//        Produto arroz = new Produto("Arroz", 10.98, 2);
//        e.adicionarProduto(arroz);
//
//        Produto bala = new Produto("bala halls", 2.50, 15);
//        e.adicionarProduto(bala);
//
//        e.varificandoProdutos();
//        e.comprarProduto("arroz", 10);

    }

}
