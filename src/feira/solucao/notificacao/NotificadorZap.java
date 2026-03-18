package feira.solucao.notificacao;

public class NotificadorZap implements Notificador {

    @Override
    public void enviar(String contato, double valor) {
        System.out.println("[Zap] " + contato + " -> Pedido finalizado. Total: R$ " + valor);
    }
}