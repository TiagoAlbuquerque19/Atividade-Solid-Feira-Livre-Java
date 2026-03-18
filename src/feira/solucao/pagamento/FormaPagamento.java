package feira.solucao.pagamento;

public interface FormaPagamento {
    String getTipo();
    void executar(double valor);
}