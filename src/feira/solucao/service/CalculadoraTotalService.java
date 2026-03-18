package feira.solucao.service;

import feira.solucao.domain.CarrinhoCompra;

public class CalculadoraTotalService {
    public double calcularTotal(CarrinhoCompra carrinho) {
        return carrinho.calcularTotalBruto();
    }
}