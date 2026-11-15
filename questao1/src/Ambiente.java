package questao1;

import java.util.ArrayList;
import java.util.List;

// RNF01 RNF02
public class Ambiente {

    private final String nome;
    private final String provedor;
    private final String regiao;
    private final List<MaquinaVirtual> maquinas = new ArrayList<>();
    private final Armazenamento armazenamento;
    private final FilaMensagens fila;

    public Ambiente(String nome, FabricaProvedor fabrica, int quantidadeMaquinas, int gbArmazenamento) {
        this.nome = nome;
        this.provedor = fabrica.getNome();
        this.regiao = Configuracao.getInstance().getRegiao();
        for (int i = 0; i < quantidadeMaquinas; i++) {
            maquinas.add(fabrica.criarMaquinaVirtual());
        }
        this.armazenamento = fabrica.criarArmazenamento(gbArmazenamento);
        this.fila = fabrica.criarFila();
    }

    // RF04
    public double custoMensal() {
        double custo = 0.00;
        for (MaquinaVirtual maquina : maquinas) {
            custo += maquina.custoMensal();
        }
        return custo + armazenamento.custoMensal() + fila.custoMensal();
    }

    // RF06
    public void resumo() {
        StringBuilder quadro = new StringBuilder();
        quadro.append(String.format("Ambiente %s | %s | regiao %s%n", nome, provedor, regiao));
        for (MaquinaVirtual maquina : maquinas) {
            quadro.append(String.format("  maquina virtual: %s%n", maquina.getIdentificador()));
        }
        quadro.append(String.format("  armazenamento:   %s%n", armazenamento.getIdentificador()));
        quadro.append(String.format("  fila:            %s%n", fila.getIdentificador()));
        quadro.append(String.format("  custo mensal estimado: R$ %.2f%n", custoMensal()));
        System.out.print(quadro);
    }
}
