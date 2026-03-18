package feira.solucao.pagamento;

public class CartaoMetodo implements FormaPagamento {
    public String getTipo() { return "CARTAO"; }
    public void executar(double valor) {
        System.out.println("Pagamento no cartão: R$ " + valor);
    }
}