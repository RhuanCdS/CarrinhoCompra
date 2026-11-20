package Base.Loja;

import java.util.HashMap;
import java.util.LinkedList;

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

        if(estoque.containsKey(p.getNome())){
            throw new IllegalArgumentException("Produto já cadastrado.");
        }

        estoque.put(p.getNome().toUpperCase(), p);
    }

    public void comprarProduto(String p, int qtd){

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

        estoque.compute(atual.getNome(), (chave, key) -> {
            if(key == null) return null;

            int novaQtd = atual.getQtd() - qtd;
            key.setQtd(novaQtd);

            return novaQtd == 0? null : key;
        });

    }

    public void excluirProduto(String p){
        if(!estoque.containsKey(p)){
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

}
