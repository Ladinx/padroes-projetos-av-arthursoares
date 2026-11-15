package questao2;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

// RF04
public class Auditor implements InteressadoLote {

    private static final DateTimeFormatter FORMATO = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    private final List<String> registros = new ArrayList<>();

    @Override
    public void lanceAceito(String nomeLote, double valor) {
        registros.add(String.format("%s | %-16s | R$ %.2f",
                LocalDateTime.now().format(FORMATO), nomeLote, valor));
    }

    public List<String> getRegistros() {
        return List.copyOf(registros);
    }
}
