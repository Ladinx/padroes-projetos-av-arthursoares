package questao2;

// RF08
public class Venda implements ItemFatura {

    private final String nomeLote;
    private final double valorVenda;

    public Venda(String nomeLote, double valorVenda) {
        this.nomeLote = nomeLote;
        this.valorVenda = valorVenda;
    }

    @Override
    public String getDescricao() {
        return "Venda do lote \"" + nomeLote + "\"";
    }

    @Override
    public double getCusto() {
        return valorVenda;
    }

    @Override
    public double getValorVenda() {
        return valorVenda;
    }

    @Override
    public void imprimir() {
        System.out.printf("  Valor de venda: R$ %.2f%n", valorVenda);
    }
}
