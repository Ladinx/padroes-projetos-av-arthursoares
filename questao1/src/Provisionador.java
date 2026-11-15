package questao1;

// RNF02 RNF06
public class Provisionador {

    // RF05 RF07
    public Ambiente provisionar(Solicitacao solicitacao) {
        FabricaProvedor fabrica = solicitacao.getFabrica();
        double custo = fabrica.custoMensalEstimado(
                solicitacao.getQuantidadeMaquinas(), solicitacao.getGbArmazenamento());
        double orcamento = Configuracao.getInstance().getOrcamentoMensal();

        if (custo > orcamento) {
            Auditoria.getInstance().registrar(solicitacao.getNomeAmbiente(), fabrica.getNome(),
                    String.format("RECUSADO (custo R$ %.2f acima do orcamento de R$ %.2f)", custo, orcamento));
            return null;
        }

        Ambiente ambiente = new Ambiente(solicitacao.getNomeAmbiente(), fabrica,
                solicitacao.getQuantidadeMaquinas(), solicitacao.getGbArmazenamento());
        ambiente.resumo();
        Auditoria.getInstance().registrar(solicitacao.getNomeAmbiente(), fabrica.getNome(), "ACEITO");
        return ambiente;
    }
}
