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

        estoque.put(p.getNome(), p);
    }

    public void comprarProduto(Produto p, int qtd){

        if(!estoque.containsKey(p.getNome())){
            throw new IllegalArgumentException("Produto não encontrado no estoque.");
        }

        int qtdAtualProduto = p.getQtd();

        if(qtdAtualProduto < qtd){

            throw new IllegalArgumentException(
                    "Quantidade indisponível. Temos apenas " + p.getQtd() +
                    "unidades de " + p.getNome() + " em estoque."
            );

        }else{

            estoque.compute(p.getNome(), (chave, atualP) -> {
                if(atualP == null) return null;

                int novaQtd = atualP.getQtd() - qtd;
                atualP.setQtd(novaQtd);

                return novaQtd == 0? null : atualP;
            });

        }

    }

    public void excluirProduto(){

    }

}
