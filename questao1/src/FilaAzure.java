package questao1;

// RF02
public class FilaAzure implements FilaMensagens {

    private final String identificador;
    private final double custoFixo;

    public FilaAzure(int sequencial, double custoFixo) {
        this.identificador = "sb-" + sequencial;
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
