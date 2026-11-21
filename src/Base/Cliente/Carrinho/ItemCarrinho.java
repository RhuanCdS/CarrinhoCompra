package Base.Cliente.Carrinho;

public class ItemCarrinho {

    private String nome;
    private double preco;
    private Integer qtd;

    public ItemCarrinho(String nome, double preco, Integer qtd){
        this.nome = nome;
        this.preco = preco;
        this.qtd = qtd;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public Integer getQtd() {
        return qtd;
    }

    public double getSubTotal(){
        return this.qtd * this.preco;
    }

}
