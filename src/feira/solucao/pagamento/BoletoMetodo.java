package feira.solucao.pagamento;

public class BoletoMetodo implements FormaPagamento {
    public String getTipo() { return "BOLETO"; }
    public void executar(double valor) {
        System.out.println("Boleto gerado: R$ " + valor);
    }
}