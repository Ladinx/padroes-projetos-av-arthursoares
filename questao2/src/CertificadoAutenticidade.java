package questao2;

// RF08
public class CertificadoAutenticidade extends ServicoAdicional {

    private static final double CUSTO_FIXO = 300.00;

    public CertificadoAutenticidade(ItemFatura item) {
        super(item, "Certificado de autenticidade");
    }

    @Override
    protected double getCustoAdicional() {
        return CUSTO_FIXO;
    }
}
