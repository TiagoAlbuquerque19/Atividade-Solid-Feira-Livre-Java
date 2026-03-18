package feira.solucao.service;

public class ResultadoCompra {
    private final double bruto;
    private final double liquido;
    private final String csv;

    public ResultadoCompra(double b, double l, String csv) {
        this.bruto = b;
        this.liquido = l;
        this.csv = csv;
    }

    public double getBruto() { return bruto; }
    public double getLiquido() { return liquido; }
    public String getCsv() { return csv; }
}