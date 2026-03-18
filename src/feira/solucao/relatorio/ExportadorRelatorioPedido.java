package feira.solucao.relatorio;

import feira.solucao.domain.CarrinhoCompra;

public interface ExportadorRelatorioPedido {
    String exportar(CarrinhoCompra carrinho, double totalLiquido);
}