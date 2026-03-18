package feira.solucao.repository;

import feira.solucao.domain.CarrinhoCompra;
import java.util.*;

public class CarrinhoRepoMemoria implements CarrinhoRepo {
    private final List<CarrinhoCompra> base = new ArrayList<>();

    public void salvar(CarrinhoCompra c) {
        base.add(c);
    }

    public List<CarrinhoCompra> listar() {
        return Collections.unmodifiableList(base);
    }
}