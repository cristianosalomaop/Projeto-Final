package pedido;

public class PedidoPreparadoState extends PedidoState{
    public PedidoPreparadoState(){}
    private static PedidoPreparadoState instance = new PedidoPreparadoState();
    public static PedidoPreparadoState getInstance(){
        return instance;
    }

    public String getStateName(){ return "Preparado"; }

    @Override
    public boolean enviar(Pedido pedido) {
        pedido.setEstado(PedidoEnviadoState.getInstance());
        return true;
    }

    @Override
    public boolean cancelar(Pedido pedido) {
        pedido.setEstado(PedidoCanceladoState.getInstance());
        return true;
    }
}
