package questao2;

// RF08 RNF03 RNF04
public interface ItemFatura {

    String getDescricao();

    double getCusto();

    double getValorVenda();

    void imprimir();
}
