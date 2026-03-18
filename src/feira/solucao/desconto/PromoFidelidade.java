package feira.solucao.desconto;

public class PromoFidelidade implements RegraPromo {
    public String getCodigo() { return "CLIENTE_FIEL"; }
    public double aplicar(double valor) { return valor * 0.90; }
}