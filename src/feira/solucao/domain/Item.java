package feira.solucao.domain;

public class Item {
    private final String descricao;
    private final double valorUnitario;

    public Item(String descricao, double valorUnitario) {
        if (descricao == null || descricao.trim().isEmpty()) {
            throw new IllegalArgumentException("Descrição obrigatória");
        }
        if (valorUnitario <= 0) {
            throw new IllegalArgumentException("Valor inválido");
        }
        this.descricao = descricao;
        this.valorUnitario = valorUnitario;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getValorUnitario() {
        return valorUnitario;
    }
}