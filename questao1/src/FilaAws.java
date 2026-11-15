package questao1;

// RF01
public class FilaAws implements FilaMensagens {

    private final String identificador;
    private final double custoFixo;

    public FilaAws(int sequencial, double custoFixo) {
        this.identificador = "sqs-" + sequencial;
        this.custoFixo = custoFixo;
    }

    @Override
    public String getIdentificador() {
        return identificador;
    }

    @Override
    public double custoMensal() {
        return custoFixo;
    }
}
