package questao2;

import java.util.List;

// Padroes de Projeto: Observer, Strategy e Decorator
// RF11
public class Main {

    public static void main(String[] args) {
        Participante ana = new Participante("Ana");
        Participante bruno = new Participante("Bruno");
        Participante carla = new Participante("Carla");
        PainelLeiloeiro painel = new PainelLeiloeiro();
        Auditor auditor = new Auditor();

        Lote quadro = new Lote("Quadro a Oleo", "Arte", 10000.00, 12000.00, new ComissaoArte());
        Lote notebook = new Lote("Notebook Gamer", "Eletronicos", 5000.00, 6500.00, new ComissaoEletronicos());

        for (InteressadoLote interessado : List.of(ana, bruno, carla, painel, auditor)) {
            quadro.acompanhar(interessado);
            notebook.acompanhar(interessado);
        }

        System.out.println("====== Lances no lote \"Quadro a Oleo\" (Arte) ======");
        quadro.darLance(bruno, 10500.00);
        quadro.darLance(ana, 12600.00);
        quadro.darLance(carla, 11500.00);
        quadro.darLance(bruno, 13500.00);

        System.out.println("====== Lances no lote \"Notebook Gamer\" (Eletronicos) ======");
        notebook.darLance(ana, 5250.00);
        notebook.darLance(bruno, 6000.00);
        notebook.darLance(carla, 5800.00);

        System.out.println("====== Ana deixa de acompanhar os dois lotes ======");
        quadro.deixarDeAcompanhar(ana);
        notebook.deixarDeAcompanhar(ana);
        notebook.darLance(carla, 6300.00);

        System.out.println("====== Campanha: regra de Eletronicos aplicada ao lote de Arte ======");
        quadro.setRegraComissao(new ComissaoEletronicos());

        System.out.println("====== Encerramento dos lotes ======");
        quadro.encerrar();
        notebook.encerrar();
        notebook.darLance(carla, 7000.00);

        System.out.println("====== Fatura do comprador ======");
        Fatura fatura = new Fatura(new EntregaExpressa(new EntregaExpressa(
                new EmbalagemEspecial(new CertificadoAutenticidade(
                        new SeguroTransporte(new Venda(quadro.getNome(), quadro.getValorVenda())))))));
        fatura.imprimir();

        System.out.println("====== Acerto do vendedor ======");
        System.out.printf("  Valor de venda:      R$ %.2f%n", quadro.getValorVenda());
        System.out.printf("  Comissao da casa:    R$ %.2f%n", quadro.getComissao());
        System.out.printf("  Liquido do vendedor: R$ %.2f%n", quadro.getValorVenda() - quadro.getComissao());

        System.out.println("====== Registro de lances do auditor ======");
        for (String registro : auditor.getRegistros()) {
            System.out.println("  " + registro);
        }
    }
}
