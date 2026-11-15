package questao1;

import java.util.concurrent.atomic.AtomicInteger;

// RF02 RNF03
public class FabricaAzure implements FabricaProvedor {

    private static final double CUSTO_MAQUINA_HORA = 0.12;
    private static final double CUSTO_ARMAZENAMENTO_GB = 0.02;
    private static final double CUSTO_FILA = 0.50;

    private final AtomicInteger maquinas = new AtomicInteger();
    private final AtomicInteger armazenamentos = new AtomicInteger();
    private final AtomicInteger filas = new AtomicInteger();

    @Override
    public String getNome() {
        return "Azure";
    }

    @Override
    public MaquinaVirtual criarMaquinaVirtual() {
        return new MaquinaVirtualAzure(maquinas.incrementAndGet(), CUSTO_MAQUINA_HORA);
    }

    @Override
    public Armazenamento criarArmazenamento(int gb) {
        return new ArmazenamentoAzure(armazenamentos.incrementAndGet(), CUSTO_ARMAZENAMENTO_GB, gb);
    }

    @Override
    public FilaMensagens criarFila() {
        return new FilaAzure(filas.incrementAndGet(), CUSTO_FILA);
    }

    @Override
    public double custoMensalEstimado(int quantidadeMaquinas, int gbArmazenamento) {
        return quantidadeMaquinas * CUSTO_MAQUINA_HORA * MaquinaVirtual.HORAS_MES
                + gbArmazenamento * CUSTO_ARMAZENAMENTO_GB
                + CUSTO_FILA;
    }
}
