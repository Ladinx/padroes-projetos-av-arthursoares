package questao2;

// RF08
public class EmbalagemEspecial extends ServicoAdicional {

    private static final double CUSTO_FIXO = 180.00;

    public EmbalagemEspecial(ItemFatura item) {
        super(item, "Embalagem especial");
    }

    @Override
    protected double getCustoAdicional() {
        return CUSTO_FIXO;
    }
}
