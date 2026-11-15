package questao1;

// Padroes de Projeto: Abstract Factory e Singleton
// RF08
public class Main {

    public static void main(String[] args) throws InterruptedException {
        Provisionador provisionador = new Provisionador();

        System.out.println("====== Dois provisionamentos simultaneos na Aws ======");
        Thread thread1 = new Thread(() -> provisionador.provisionar(
                new Solicitacao("vendas-api", new FabricaAws(), 2, 100)));
        Thread thread2 = new Thread(() -> provisionador.provisionar(
                new Solicitacao("rh-batch", new FabricaAws(), 1, 50)));
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();

        System.out.println("====== Provisionamento no Azure ======");
        provisionador.provisionar(new Solicitacao("financeiro-web", new FabricaAzure(), 3, 200));

        System.out.println("====== Provisionamento recusado por orcamento ======");
        provisionador.provisionar(new Solicitacao("data-lake", new FabricaAws(), 30, 500));

        System.out.println("====== Historico de auditoria ======");
        for (String registro : Auditoria.getInstance().getRegistros()) {
            System.out.println("  " + registro);
        }
    }
}
