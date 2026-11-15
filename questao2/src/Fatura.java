package questao2;

// RF09 RNF04
public class Fatura {

    private final ItemFatura item;

    public Fatura(ItemFatura item) {
        this.item = item;
    }

    public void imprimir() {
        System.out.printf("Fatura: %s%n", item.getDescricao());
        item.imprimir();
        System.out.printf("  Total a pagar: R$ %.2f%n", item.getCusto());
    }
}
