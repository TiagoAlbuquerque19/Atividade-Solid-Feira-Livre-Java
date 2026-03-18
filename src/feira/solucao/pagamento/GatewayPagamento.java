package feira.solucao.pagamento;

import java.util.*;

public class GatewayPagamento {
    private final Map<String, FormaPagamento> mapa = new HashMap<>();

    public GatewayPagamento(List<FormaPagamento> formas) {
        for (FormaPagamento f : formas) {
            mapa.put(f.getTipo().toUpperCase(), f);
        }
    }

    public void pagar(String tipo, double valor) {
        mapa.get(tipo.toUpperCase()).executar(valor);
    }
}