package questao1;

// RF01
public class ArmazenamentoAws implements Armazenamento {

    private final String identificador;
    private final double custoPorGb;
    private final int gb;

    public ArmazenamentoAws(int sequencial, double custoPorGb, int gb) {
        this.identificador = "s3://" + sequencial;
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
