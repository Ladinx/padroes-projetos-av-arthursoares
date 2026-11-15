package questao2;

import java.util.HashMap;
import java.util.Map;

// RF04
public class PainelLeiloeiro implements InteressadoLote {

    private final Map<String, Double> maiorLance = new HashMap<>();
    private final Map<String, Integer> totalLances = new HashMap<>();

    @Override
    public void lanceAceito(String nomeLote, double valor) {
        totalLances.merge(nomeLote, 1, Integer::sum);
        maiorLance.merge(nomeLote, valor, Double::max);
        System.out.printf("[Painel] %s: maior lance R$ %.2f (%d lance(s))%n",
                nomeLote, maiorLance.get(nomeLote), totalLances.get(nomeLote));
    }
}
