package questao2;

// RF06
public class ComissaoVeiculos implements RegraComissao {

    private static final double PERCENTUAL = 0.08;
    private static final double LIMITE = 5000.00;

    @Override
    public double calcular(double valorVenda) {
        return Math.min(valorVenda * PERCENTUAL, LIMITE);
    }
}
