package questao1;

// RF03
public class Solicitacao {

    private final String nomeAmbiente;
    private final FabricaProvedor fabrica;
    private final int quantidadeMaquinas;
    private final int gbArmazenamento;

    public Solicitacao(String nomeAmbiente, FabricaProvedor fabrica, int quantidadeMaquinas, int gbArmazenamento) {
        this.nomeAmbiente = nomeAmbiente;
        this.fabrica = fabrica;
        this.quantidadeMaquinas = quantidadeMaquinas;
        this.gbArmazenamento = gbArmazenamento;
    }

    public String getNomeAmbiente() { return nomeAmbiente; }
    public FabricaProvedor getFabrica() { return fabrica; }
    public int getQuantidadeMaquinas() { return quantidadeMaquinas; }
    public int getGbArmazenamento() { return gbArmazenamento; }
}
