package Base.Loja;

import Base.Loja.ClasseAnonima.VerificacaoEstoque;

public class CriandoProdutos {

        public static void montarEstoque() {
            Estoque e = Estoque.criarEstoque();

            //adicionando as verificações nos produtos usando lambda
            e.adicionarVerificacao(str -> {
                System.out.println("Produto " + str.getNome() + " com quantidade baixa. Adicione mais estoque!!!");
                System.out.println("Qtd: " + str.getQtd());
            });

            //adicionando as verificações nos produtos usando classes anônimas
            e.adicionarVerificacao(new VerificacaoEstoque() {
                private int totalAviso = 0;

                @Override
                public void verificarProdutos(Produto p) {
                    totalAviso++;
                    System.out.println("[AVISO] " + totalAviso + " produtos com estoque baixo.");
                }
            });

            e.adicionarProduto(new Produto("Arroz", 10.98, 25));
            e.adicionarProduto(new Produto("bala halls", 2.50, 15));
            e.adicionarProduto(new Produto("suco", 8.50, 50));
            e.adicionarProduto(new Produto("Feijão", 7.90, 20));
            e.adicionarProduto(new Produto("Macarrão", 4.50, 30));
            e.adicionarProduto(new Produto("Óleo", 6.80, 12));
            e.adicionarProduto(new Produto("Café", 12.90, 8));
            e.adicionarProduto(new Produto("Leite", 5.20, 40));
            e.adicionarProduto(new Produto("Biscoito", 3.75, 25));
            e.adicionarProduto(new Produto("Refrigerante", 7.50, 18));

        }
}
