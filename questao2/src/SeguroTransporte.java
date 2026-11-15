package questao2;

// RF08
public class SeguroTransporte extends ServicoAdicional {

    private static final double PERCENTUAL = 0.015;

    public SeguroTransporte(ItemFatura item) {
        super(item, "Seguro de transporte");
    }

    @Override
    protected double getCustoAdicional() {
        return getValorVenda() * PERCENTUAL;
    }
}
