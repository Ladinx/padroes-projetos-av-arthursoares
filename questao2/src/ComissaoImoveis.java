package questao2;

// RF06
public class ComissaoImoveis implements RegraComissao {

    private static final double PERCENTUAL = 0.03;
    private static final double FIXO = 1500.00;

    @Override
    public double calcular(double valorVenda) {
        return valorVenda * PERCENTUAL + FIXO;
    }
}
