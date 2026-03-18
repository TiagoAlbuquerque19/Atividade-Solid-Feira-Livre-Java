package feira.solucao.desconto;

import java.util.*;

public class MotorDesconto {
    private final Map<String, RegraPromo> regras = new HashMap<>();

    public MotorDesconto(List<RegraPromo> lista) {
        for (RegraPromo r : lista) {
            regras.put(r.getCodigo().toUpperCase(), r);
        }
    }

    public double aplicar(String cod, double total) {
        if (cod == null) throw new IllegalArgumentException("Código inválido");

        RegraPromo regra = regras.get(cod.toUpperCase());
        if (regra == null) throw new IllegalArgumentException("Desconto não encontrado");

        return regra.aplicar(total);
    }
}