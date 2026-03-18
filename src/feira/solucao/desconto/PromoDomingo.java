package feira.solucao.desconto;

public class PromoDomingo implements RegraPromo {
    public String getCodigo() { return "DOMINGO"; }
    public double aplicar(double valor) { return valor * 0.95; }
}