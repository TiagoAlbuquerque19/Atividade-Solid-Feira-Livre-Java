package feira.solucao.desconto;

public class PromoQueima implements RegraPromo {
    public String getCodigo() { return "QUEIMA_ESTOQUE"; }
    public double aplicar(double valor) { return valor * 0.80; }
}