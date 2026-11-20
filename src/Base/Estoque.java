package Base;

import java.util.HashMap;

public class Estoque {

    private static Estoque instancia;

    private final HashMap<String, Produto> estoque = new HashMap<>();

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

        if(!estoque.containsKey(p)){
            throw new IllegalArgumentException("Produto não encontrado no estoque.");
        }

        Produto atual = estoque.get(p);

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

}
