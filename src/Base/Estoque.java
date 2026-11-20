package Base;

import java.util.HashMap;

public class Estoque {

    private static Estoque instancia;

    private final HashMap<String, Produto> estoque = new HashMap<>();

    private Estoque(){}
}
