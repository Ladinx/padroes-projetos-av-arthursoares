package questao1;

import java.util.concurrent.atomic.AtomicInteger;

// RF01 RNF03
public class FabricaAws implements FabricaProvedor {

    private static final double CUSTO_MAQUINA_HORA = 0.10;
    private static final double CUSTO_ARMAZENAMENTO_GB = 0.023;
    private static final double CUSTO_FILA = 0.40;

    private final AtomicInteger maquinas = new AtomicInteger();
    private final AtomicInteger armazenamentos = new AtomicInteger();
    private final AtomicInteger filas = new AtomicInteger();

    @Override
    public String getNome() {
        return "Aws";
    }

    @Override
    public MaquinaVirtual criarMaquinaVirtual() {
        return new MaquinaVirtualAws(maquinas.incrementAndGet(), CUSTO_MAQUINA_HORA);
    }

    @Override
    public Armazenamento criarArmazenamento(int gb) {
        return new ArmazenamentoAws(armazenamentos.incrementAndGet(), CUSTO_ARMAZENAMENTO_GB, gb);
    }

    @Override
    public FilaMensagens criarFila() {
        return new FilaAws(filas.incrementAndGet(), CUSTO_FILA);
    }

    @Override
    public double custoMensalEstimado(int quantidadeMaquinas, int gbArmazenamento) {
        return quantidadeMaquinas * CUSTO_MAQUINA_HORA * MaquinaVirtual.HORAS_MES
                + gbArmazenamento * CUSTO_ARMAZENAMENTO_GB
                + CUSTO_FILA;
    }
}
