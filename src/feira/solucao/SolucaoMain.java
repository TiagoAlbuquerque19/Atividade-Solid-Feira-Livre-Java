package feira.solucao;

import feira.solucao.cupom.CupomConsole;
import feira.solucao.cupom.ImpressoraCupom;
import feira.solucao.desconto.*;
import feira.solucao.domain.CarrinhoCompra;
import feira.solucao.domain.Item;
import feira.solucao.entrega.*;
import feira.solucao.notificacao.Notificador;
import feira.solucao.notificacao.NotificadorZap;
import feira.solucao.pagamento.*;
import feira.solucao.relatorio.*;
import feira.solucao.repository.*;
import feira.solucao.service.*;

import java.util.Arrays;

public class SolucaoMain {

    public static void main(String[] args) {

        CarrinhoRepo repository = new CarrinhoRepoMemoria();

        MotorDesconto motorDesconto = new MotorDesconto(Arrays.asList(
                new PromoNenhuma(),
                new PromoFidelidade(),
                new PromoQueima(),
                new PromoDomingo()
        ));

        GatewayPagamento pagamento = new GatewayPagamento(Arrays.asList(
                new PixMetodo(),
                new CartaoMetodo(),
                new BoletoMetodo()
        ));

        ImpressoraCupom impressora = new CupomConsole();
        Notificador notificador = new NotificadorZap();
        ExportadorRelatorioPedido exportador = new ExportadorCsvPedido();

        CheckoutFinal checkout = new CheckoutFinal(
                repository,
                motorDesconto,
                pagamento,
                impressora,
                notificador,
                exportador
        );

        CarrinhoCompra carrinho = new CarrinhoCompra("Maria da Feira");

        carrinho.adicionar(new Item("Tomate", 8.0), 2);
        carrinho.adicionar(new Item("Cenoura", 6.5), 3);

        ResultadoCompra resultado = checkout.fechar(
                carrinho,
                "CLIENTE_FIEL",
                "PIX",
                "85999990000"
        );

        System.out.println("Total bruto: R$ " + resultado.getBruto());
        System.out.println("Total líquido: R$ " + resultado.getLiquido());
        System.out.println("CSV:\n" + resultado.getCsv());

        CalculadoraPrazoEntrega normal = new EntregaNormal();
        CalculadoraPrazoEntrega expressa = new EntregaExpressa();

        System.out.println("Prazo normal (30km): " + normal.calcularPrazoDias(30) + " dia(s)");
        System.out.println("Prazo expresso (30km): " + expressa.calcularPrazoDias(30) + " dia(s)");
    }
}