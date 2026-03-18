package feira.solucao.desconto;

public class PromoNenhuma implements RegraPromo {
    public String getCodigo() { return "NENHUM"; }
    public double aplicar(double valor) { return valor; }
}