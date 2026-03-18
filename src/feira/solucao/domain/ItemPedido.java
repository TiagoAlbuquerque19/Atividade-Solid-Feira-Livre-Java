package feira.solucao.domain;

public class ItemPedido {
    private final Item item;
    private final int qtd;

    public ItemPedido(Item item, int qtd) {
        if (item == null) throw new IllegalArgumentException("Item obrigatório");
        if (qtd <= 0) throw new IllegalArgumentException("Qtd inválida");

        this.item = item;
        this.qtd = qtd;
    }

    public Item getItem() {
        return item;
    }

    public int getQtd() {
        return qtd;
    }

    public double calcularSubtotal() {
        return item.getValorUnitario() * qtd;
    }
}