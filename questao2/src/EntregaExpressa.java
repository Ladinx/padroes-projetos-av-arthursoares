package questao2;

// RF08
public class EntregaExpressa extends ServicoAdicional {

    private static final double CUSTO_FIXO = 450.00;

    public EntregaExpressa(ItemFatura item) {
        super(item, "Entrega expressa");
    }

    @Override
    protected double getCustoAdicional() {
        return CUSTO_FIXO;
    }
}
