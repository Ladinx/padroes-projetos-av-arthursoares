package questao1;

// RF02
public class MaquinaVirtualAzure implements MaquinaVirtual {

    private final String identificador;
    private final double custoPorHora;

    public MaquinaVirtualAzure(int sequencial, double custoPorHora) {
        this.identificador = "vm-" + sequencial;
        this.custoPorHora = custoPorHora;
    }

    @Override
    public String getIdentificador() {
        return identificador;
    }

    @Override
    public double custoMensal() {
        return custoPorHora * HORAS_MES;
    }
}
