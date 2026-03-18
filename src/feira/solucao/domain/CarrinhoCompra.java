package feira.solucao.domain;

import java.util.*;

public class CarrinhoCompra {
    private final String clienteNome;
    private final List<ItemPedido> listaItens;

    public CarrinhoCompra(String clienteNome) {
        if (clienteNome == null || clienteNome.trim().isEmpty()) {
            throw new IllegalArgumentException("Cliente inválido");
        }
        this.clienteNome = clienteNome;
        this.listaItens = new ArrayList<>();
    }

    public void adicionar(Item item, int qtd) {
        listaItens.add(new ItemPedido(item, qtd));
    }

    public List<ItemPedido> itens() {
        return Collections.unmodifiableList(listaItens);
    }

    public boolean estaVazio() {
        return listaItens.isEmpty();
    }

    public double calcularTotalBruto() {
        double total = 0;
        for (ItemPedido i : listaItens) {
            total += i.calcularSubtotal();
        }
        return total;
    }

    public String getClienteNome() {
        return clienteNome;
    }
}