package feira.solucao.repository;

import feira.solucao.domain.CarrinhoCompra;
import java.util.List;

public interface CarrinhoRepo {
    void salvar(CarrinhoCompra carrinho);
    List<CarrinhoCompra> listar();
}