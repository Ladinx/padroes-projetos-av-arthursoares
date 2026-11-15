package questao1;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

// RF07 RNF05
public class Auditoria {

    private static final DateTimeFormatter FORMATO = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    private static volatile Auditoria instancia;
    private final List<String> registros = new ArrayList<>();

    private Auditoria() {
    }

    public static Auditoria getInstance() {
        if (instancia == null) {
            synchronized (Auditoria.class) {
                if (instancia == null) {
                    instancia = new Auditoria();
                }
            }
        }
        return instancia;
    }

    public synchronized void registrar(String nomeAmbiente, String provedor, String resultado) {
        registros.add(String.format("%s | %-16s | %-6s | %s",
                LocalDateTime.now().format(FORMATO), nomeAmbiente, provedor, resultado));
    }

    public synchronized List<String> getRegistros() {
        return List.copyOf(registros);
    }
}
