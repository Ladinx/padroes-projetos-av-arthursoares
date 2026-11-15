package questao2;

// RNF03
public abstract class ServicoAdicional implements ItemFatura {

    private final ItemFatura item;
    private final String nome;

    protected ServicoAdicional(ItemFatura item, String nome) {
        this.item = item;
        this.nome = nome;
    }

    @Override
    public String getDescricao() {
        return item.getDescricao() + " + " + nome;
    }

    @Override
    public double getCusto() {
        return item.getCusto() + getCustoAdicional();
    }

    @Override
    public double getValorVenda() {
        return item.getValorVenda();
    }

    protected abstract double getCustoAdicional();

    public String getNome() {
        return nome;
    }

    public ItemFatura getItem() {
        return item;
    }

    // RNF04
    @Override
    public void imprimir() {
        item.imprimir();
        System.out.printf("  %-30s R$ %.2f%n", nome, getCustoAdicional());
    }
}
