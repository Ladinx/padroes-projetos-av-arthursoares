package questao1;

// RF02
public class ArmazenamentoAzure implements Armazenamento {

    private final String identificador;
    private final double custoPorGb;
    private final int gb;

    public ArmazenamentoAzure(int sequencial, double custoPorGb, int gb) {
        this.identificador = "blob://" + sequencial;
        this.custoPorGb = custoPorGb;
        this.gb = gb;
    }

    @Override
    public String getIdentificador() {
        return identificador;
    }

    @Override
    public double custoMensal() {
        return custoPorGb * gb;
    }
}
