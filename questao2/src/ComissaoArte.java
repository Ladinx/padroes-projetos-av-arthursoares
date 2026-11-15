package questao2;

// RF06
public class ComissaoArte implements RegraComissao {

    private static final double PERCENTUAL = 0.20;

    @Override
    public double calcular(double valorVenda) {
        return valorVenda * PERCENTUAL;
    }
}
