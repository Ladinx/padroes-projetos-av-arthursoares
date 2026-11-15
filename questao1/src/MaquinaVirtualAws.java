package questao1;

// RF01
public class MaquinaVirtualAws implements MaquinaVirtual {

    private final String identificador;
    private final double custoPorHora;

    public MaquinaVirtualAws(int sequencial, double custoPorHora) {
        this.identificador = "i-" + sequencial;
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
