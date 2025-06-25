package produto;

public class BordaRecheada extends PedidoDecorator {
    public BordaRecheada(IProduto pedido) {
        super(pedido);
    }

    @Override
    public String getDescricao() {
        return super.getDescricao() + ", borda recheada";
    }

    @Override
    public double getPreco() {
        return super.getPreco() + 7.0;
    }
}