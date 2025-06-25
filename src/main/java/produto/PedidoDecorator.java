package produto;

public abstract class PedidoDecorator implements IProduto {
    protected IProduto pedido;

    public PedidoDecorator(IProduto pedido) {
        this.pedido = pedido;
    }

    @Override
    public String getDescricao() {
        return pedido.getDescricao();
    }

    @Override
    public double getPreco() {
        return pedido.getPreco();
    }
}