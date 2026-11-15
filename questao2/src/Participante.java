package questao2;

// RF03 RF04 RNF01
public class Participante implements InteressadoLote, Licitante {

    private final String nome;

    public Participante(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public void lanceAceito(String nomeLote, double valor) {
        System.out.printf("[Participante %s] novo lance no lote \"%s\": R$ %.2f%n", nome, nomeLote, valor);
    }
}
