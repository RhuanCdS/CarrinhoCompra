package Base.Cliente;

public class Cliente {

    private String nome;
    private Byte idade;

    public Cliente(String nome, Byte idade){
        this.nome = nome;
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public Byte getIdade() {
        return idade;
    }
}
