package pedido;

public class PedidoEnviadoState extends PedidoState{
    public PedidoEnviadoState(){}
    private static PedidoEnviadoState instance = new PedidoEnviadoState();
    public static PedidoEnviadoState getInstance(){
        return instance;
    }

    public String getStateName(){
        return "Enviado";
    }

    @Override
    public boolean entregar(Pedido pedido) {
        pedido.setEstado(PedidoEntregueState.getInstance());
        return true;
    }

    @Override
    public boolean cancelar(Pedido pedido) {
        pedido.setEstado(PedidoCanceladoState.getInstance());
        return true;
    }
}
