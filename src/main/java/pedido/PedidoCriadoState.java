package pedido;

public class PedidoCriadoState extends PedidoState {
    public PedidoCriadoState() {}
    private static PedidoCriadoState instance = new PedidoCriadoState();
    public static PedidoCriadoState getInstance() {
        return instance;
    }

    public String getStateName() { return "Criado"; }

    @Override
    public boolean preparar(Pedido pedido) {
        pedido.setEstado(PedidoPreparadoState.getInstance());
        return true;
    }

    @Override
    public boolean cancelar(Pedido pedido) {
        pedido.setEstado(PedidoCanceladoState.getInstance());
        return true;
    }
}
