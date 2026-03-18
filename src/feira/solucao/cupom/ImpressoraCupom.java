package feira.solucao.cupom;

import feira.solucao.domain.CarrinhoCompra;

public interface ImpressoraCupom {
    void imprimir(CarrinhoCompra carrinho, double totalLiquido);
}