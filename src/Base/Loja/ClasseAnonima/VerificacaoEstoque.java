package Base.Loja.ClasseAnonima;

import Base.Loja.Produto;

@FunctionalInterface
public interface VerificacaoEstoque {
    void verificarProdutos(Produto p);
}
