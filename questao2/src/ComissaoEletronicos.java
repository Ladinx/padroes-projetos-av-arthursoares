package questao2;

// RF06
public class ComissaoEletronicos implements RegraComissao {

    private static final double PERCENTUAL = 0.12;
    private static final double MINIMO = 50.00;

    @Override
    public double calcular(double valorVenda) {
        return Math.max(valorVenda * PERCENTUAL, MINIMO);
    }
}
