package feira.solucao.desconto;

public interface RegraPromo {
    String getCodigo();
    double aplicar(double valor);
}