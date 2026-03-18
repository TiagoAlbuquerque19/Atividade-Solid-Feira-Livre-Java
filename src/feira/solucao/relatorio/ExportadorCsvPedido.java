package feira.solucao.relatorio;

import feira.solucao.domain.CarrinhoCompra;
import feira.solucao.domain.ItemPedido;

public class ExportadorCsvPedido implements ExportadorRelatorioPedido {

    @Override
    public String exportar(CarrinhoCompra carrinho, double totalLiquido) {
        StringBuilder csv = new StringBuilder();
        csv.append("cliente,produto,quantidade,subtotal\n");

        for (ItemPedido item : carrinho.itens()) {
            csv.append(carrinho.getClienteNome()).append(",")
               .append(item.getItem().getDescricao()).append(",")
               .append(item.getQtd()).append(",")
               .append(item.calcularSubtotal()).append("\n");
        }

        csv.append("TOTAL,,,").append(totalLiquido);
        return csv.toString();
    }
}