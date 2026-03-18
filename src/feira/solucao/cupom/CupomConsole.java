package feira.solucao.cupom;

import feira.solucao.domain.CarrinhoCompra;
import feira.solucao.domain.ItemPedido;

public class CupomConsole implements ImpressoraCupom {

    @Override
    public void imprimir(CarrinhoCompra carrinho, double totalLiquido) {

        System.out.println("=== CUPOM ===");
        System.out.println("Cliente: " + carrinho.getClienteNome());

        for (ItemPedido item : carrinho.itens()) {
            System.out.println(
                item.getItem().getDescricao() +
                " x" + item.getQtd() +
                " = R$ " + item.calcularSubtotal()
            );
        }

        System.out.println("Total líquido: R$ " + totalLiquido);
        System.out.println("=============");
    }
}