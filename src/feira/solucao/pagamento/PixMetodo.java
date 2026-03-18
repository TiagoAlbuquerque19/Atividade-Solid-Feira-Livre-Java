package feira.solucao.pagamento;

public class PixMetodo implements FormaPagamento {
    public String getTipo() { return "PIX"; }
    public void executar(double valor) {
        System.out.println("Pagamento PIX efetuado: R$ " + valor);
    }
}