package Base.Loja;

import java.util.HashMap;
import java.util.LinkedList;

import Base.Cliente.Carrinho.ItemCarrinho;
import Base.Loja.ClasseAnonima.VerificacaoEstoque;

public class Estoque {

    private static Estoque instancia;

    private final HashMap<String, Produto> estoque = new HashMap<>();
    private final LinkedList<VerificacaoEstoque> verificacaoEstoques = new LinkedList<>();

    private Estoque(){}

    public static Estoque criarEstoque(){

        if(instancia == null){
            instancia = new Estoque();
        }

        return instancia;
    }

    public void adicionarProduto(Produto p){

        if(estoque.containsKey(p.getNome().toUpperCase())){
            throw new IllegalArgumentException("Produto já cadastrado.");
        }

        estoque.put(p.getNome().toUpperCase(), p);
    }

    public ItemCarrinho comprarProduto(String p, int qtd){

        if(!estoque.containsKey(p.toUpperCase())){
            throw new IllegalArgumentException("Produto não encontrado no estoque.");
        }

        Produto atual = estoque.get(p.toUpperCase());

        if(atual.getQtd() < qtd){

            throw new IllegalArgumentException(
                    "Quantidade indisponível. Temos apenas " + atual.getQtd() +
                    " unidades de " + atual.getNome() + " em estoque."
            );

        }

        estoque.compute(atual.getNome().toUpperCase(), (chave, atualP) -> {
            if (atualP == null) return null;

            int novaQtd = atualP.getQtd() - qtd;
            atualP.setQtd(novaQtd);

            return novaQtd == 0 ? null : atualP;
        });

        return new ItemCarrinho(atual.getNome(), atual.getPreco(), qtd);
    }

    public void retornarProduto(ItemCarrinho item){

        estoque.compute(item.getNome().toUpperCase(), (chave, atualP) -> {

            if (atualP == null){
                return new Produto(item.getNome(), item.getPreco(), item.getQtd());
            }

            int novaQtd = atualP.getQtd() + item.getQtd();
            atualP.setQtd(novaQtd);

            return atualP;
        });
    }

    public void excluirProduto(String p){
        if(!estoque.containsKey(p.toUpperCase())){
            throw new IllegalArgumentException("Produto não encontrado no estoque.");
        }

        estoque.remove(p.toUpperCase());
    }

    public void adicionarVerificacao(VerificacaoEstoque v){
        verificacaoEstoques.add(v);
    }

    public void varificandoProdutos(){

        estoque.forEach((k, v) -> {
            if(v.getQtd() < 3){
                for (VerificacaoEstoque verificacao: verificacaoEstoques){
                    verificacao.verificarProdutos(v);
                }
            }

        });
    }

    public void listarProdutos(){
        estoque.forEach((k, v) -> {
            System.out.println("\nNome: " + estoque.get(k).getNome());
            System.out.println("Quantidade: " + estoque.get(k).getQtd());
        });
    }

}
