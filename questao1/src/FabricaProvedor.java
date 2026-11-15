package questao1;

// RNF02 RNF03
public interface FabricaProvedor {

    String getNome();

    MaquinaVirtual criarMaquinaVirtual();

    Armazenamento criarArmazenamento(int gb);

    FilaMensagens criarFila();

    // RF04
    double custoMensalEstimado(int quantidadeMaquinas, int gbArmazenamento);
}
