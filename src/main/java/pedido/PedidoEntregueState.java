package pedido;

public class PedidoEntregueState extends PedidoState{
    public PedidoEntregueState(){}
    private static PedidoEntregueState instance = new PedidoEntregueState();
    public static PedidoEntregueState getInstance(){
        return instance;
    }

    public String getStateName(){
        return "Entregue";
    }
}
