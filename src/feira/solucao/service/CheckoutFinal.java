package feira.solucao.service;

import feira.solucao.cupom.ImpressoraCupom;
import feira.solucao.desconto.MotorDesconto;
import feira.solucao.domain.CarrinhoCompra;
import feira.solucao.notificacao.Notificador;
import feira.solucao.pagamento.GatewayPagamento;
import feira.solucao.relatorio.ExportadorRelatorioPedido;
import feira.solucao.repository.CarrinhoRepo;

public class CheckoutFinal {

    private final CarrinhoRepo repo;
    private final MotorDesconto desconto;
    private final GatewayPagamento pagamento;
    private final ImpressoraCupom impressora;
    private final Notificador notificador;
    private final ExportadorRelatorioPedido exportador;

    public CheckoutFinal(
            CarrinhoRepo repo,
            MotorDesconto desconto,
            GatewayPagamento pagamento,
            ImpressoraCupom impressora,
            Notificador notificador,
            ExportadorRelatorioPedido exportador) {

        this.repo = repo;
        this.desconto = desconto;
        this.pagamento = pagamento;
        this.impressora = impressora;
        this.notificador = notificador;
        this.exportador = exportador;
    }

    public ResultadoCompra fechar(CarrinhoCompra carrinho, String codDesc, String tipoPag, String contato) {

        if (carrinho == null || carrinho.estaVazio()) {
            throw new IllegalArgumentException("Carrinho inválido");
        }

        double bruto = carrinho.calcularTotalBruto();
        double liquido = desconto.aplicar(codDesc, bruto);

        pagamento.pagar(tipoPag, liquido);
        repo.salvar(carrinho);
        impressora.imprimir(carrinho, liquido);
        notificador.enviar(contato, liquido);

        String csv = exportador.exportar(carrinho, liquido);

        return new ResultadoCompra(bruto, liquido, csv);
    }
}