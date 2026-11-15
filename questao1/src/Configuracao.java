package questao1;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

// RF05 RNF04
public class Configuracao {

    private static final String ARQUIVO = "config.properties";

    private final String regiao;
    private final double orcamentoMensal;

    private Configuracao() {
        Properties propriedades = new Properties();
        try (InputStream entrada = new FileInputStream(ARQUIVO)) {
            propriedades.load(entrada);
        } catch (IOException erro) {
            throw new IllegalStateException("Nao foi possivel ler " + ARQUIVO + ".", erro);
        }
        this.regiao = propriedades.getProperty("regiao");
        this.orcamentoMensal = Double.parseDouble(propriedades.getProperty("orcamento.mensal"));
    }

    private static class Holder {
        private static final Configuracao INSTANCIA = new Configuracao();
    }

    public static Configuracao getInstance() {
        return Holder.INSTANCIA;
    }

    public String getRegiao() { return regiao; }
    public double getOrcamentoMensal() { return orcamentoMensal; }
}
