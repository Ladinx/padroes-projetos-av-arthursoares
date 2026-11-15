package questao2;

import java.util.ArrayList;
import java.util.List;

// RF01 RF03 RF05 RNF01
public class Lote {

    private final String nome;
    private final String categoria;
    private final double precoInicial;
    private final double precoReserva;
    private final List<InteressadoLote> acompanhantes = new ArrayList<>();
    private RegraComissao regraComissao;
    private double lanceAtual;
    private Licitante arrematante;
    private int totalLances;
    private boolean encerrado;
    private boolean vendido;

    public Lote(String nome, String categoria, double precoInicial, double precoReserva,
            RegraComissao regraComissao) {
        this.nome = nome;
        this.categoria = categoria;
        this.precoInicial = precoInicial;
        this.precoReserva = precoReserva;
        this.regraComissao = regraComissao;
        this.lanceAtual = precoInicial;
    }

    public String getNome() { return nome; }
    public String getCategoria() { return categoria; }
    public double getLanceAtual() { return lanceAtual; }
    public boolean isVendido() { return vendido; }

    // RF03
    public void acompanhar(InteressadoLote interessado) {
        acompanhantes.add(interessado);
    }

    // RF03
    public void deixarDeAcompanhar(InteressadoLote interessado) {
        acompanhantes.remove(interessado);
    }

    // RF02
    public boolean darLance(Licitante licitante, double valor) {
        if (encerrado) {
            System.out.printf("Lance recusado: o lote \"%s\" ja foi encerrado.%n", nome);
            return false;
        }
        if (valor < lanceAtual * 1.05) {
            System.out.printf("Lance recusado: R$ %.2f nao e pelo menos 5%% maior que o lance atual de R$ %.2f.%n",
                    valor, lanceAtual);
            return false;
        }
        lanceAtual = valor;
        arrematante = licitante;
        totalLances++;
        notificar(licitante);
        return true;
    }

    // RF03
    private void notificar(Licitante autor) {
        for (InteressadoLote interessado : acompanhantes) {
            if (interessado != autor) {
                interessado.lanceAceito(nome, lanceAtual);
            }
        }
    }

    // RF07
    public void setRegraComissao(RegraComissao regraComissao) {
        this.regraComissao = regraComissao;
    }

    // RF05
    public void encerrar() {
        encerrado = true;
        vendido = totalLances > 0 && lanceAtual >= precoReserva;
        if (vendido) {
            System.out.printf("Lote \"%s\" VENDIDO para %s por R$ %.2f.%n",
                    nome, arrematante.getNome(), lanceAtual);
        } else {
            System.out.printf("Lote \"%s\" NAO VENDIDO (lance atual de R$ %.2f ficou abaixo da reserva de R$ %.2f).%n",
                    nome, lanceAtual, precoReserva);
        }
    }

    public double getValorVenda() {
        return vendido ? lanceAtual : 0.00;
    }

    // RF06
    public double getComissao() {
        return regraComissao.calcular(getValorVenda());
    }
}
