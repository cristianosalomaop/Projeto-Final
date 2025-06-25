package pedido;

public class PedidoCanceladoState extends PedidoState{
    public PedidoCanceladoState(){}
    private static PedidoCanceladoState instance = new PedidoCanceladoState();
    public static PedidoCanceladoState getInstance(){
        return instance;
    }

    public String getStateName(){
        return "Cancelado";
    }
}
