package pedido;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import produto.IProduto;
import produto.PizzaBase;

import static org.junit.jupiter.api.Assertions.*;

class PedidoStateTest {

    private Pedido pedido;

    @BeforeEach
    void setUp() {
        IProduto produto = new PizzaBase();
        pedido = new Pedido(produto);
    }

    @Test
    void pedidoDeveIniciarComEstadoCriado() {
        assertTrue(pedido.getEstado() instanceof PedidoCriadoState);
    }

    @Test
    void estadoCriadoDevePermitirPreparar() {
        boolean resultado = pedido.getEstado().preparar(pedido);
        assertTrue(resultado);
        assertTrue(pedido.getEstado() instanceof PedidoPreparadoState);
    }

    @Test
    void estadoCriadoDevePermitirCancelar() {
        boolean resultado = pedido.getEstado().cancelar(pedido);
        assertTrue(resultado);
        assertTrue(pedido.getEstado() instanceof PedidoCanceladoState);
    }

    @Test
    void estadoCriadoNaoDevePermitirEnviarOuEntregar() {
        assertFalse(pedido.getEstado().enviar(pedido));
        assertFalse(pedido.getEstado().entregar(pedido));
        assertTrue(pedido.getEstado() instanceof PedidoCriadoState);
    }

    @Test
    void estadoPreparadoDevePermitirEnviarOuCancelar() {
        pedido.setEstado(PedidoPreparadoState.getInstance());

        assertTrue(pedido.getEstado().enviar(pedido));
        assertTrue(pedido.getEstado() instanceof PedidoEnviadoState);

        pedido.setEstado(PedidoPreparadoState.getInstance());
        assertTrue(pedido.getEstado().cancelar(pedido));
        assertTrue(pedido.getEstado() instanceof PedidoCanceladoState);
    }

    @Test
    void estadoPreparadoNaoDevePermitirPrepararOuEntregar() {
        pedido.setEstado(PedidoPreparadoState.getInstance());

        assertFalse(pedido.getEstado().preparar(pedido));
        assertFalse(pedido.getEstado().entregar(pedido));
    }

    @Test
    void estadoEnviadoDevePermitirEntregarOuCancelar() {
        pedido.setEstado(PedidoEnviadoState.getInstance());

        assertTrue(pedido.getEstado().entregar(pedido));
        assertTrue(pedido.getEstado() instanceof PedidoEntregueState);

        pedido.setEstado(PedidoEnviadoState.getInstance());
        assertTrue(pedido.getEstado().cancelar(pedido));
        assertTrue(pedido.getEstado() instanceof PedidoCanceladoState);
    }

    @Test
    void estadoEnviadoNaoDevePermitirPrepararOuEnviar() {
        pedido.setEstado(PedidoEnviadoState.getInstance());

        assertFalse(pedido.getEstado().preparar(pedido));
        assertFalse(pedido.getEstado().enviar(pedido));
    }

    @Test
    void estadoEntregueNaoDevePermitirQualquerAcao() {
        pedido.setEstado(PedidoEntregueState.getInstance());

        assertFalse(pedido.getEstado().preparar(pedido));
        assertFalse(pedido.getEstado().enviar(pedido));
        assertFalse(pedido.getEstado().entregar(pedido));
        assertFalse(pedido.getEstado().cancelar(pedido));
    }

    @Test
    void estadoCanceladoNaoDevePermitirQualquerAcao() {
        pedido.setEstado(PedidoCanceladoState.getInstance());

        assertFalse(pedido.getEstado().preparar(pedido));
        assertFalse(pedido.getEstado().enviar(pedido));
        assertFalse(pedido.getEstado().entregar(pedido));
        assertFalse(pedido.getEstado().cancelar(pedido));
    }

    @Test
    void deveRetornarNomeCorretoDosEstados() {
        assertEquals("Criado", PedidoCriadoState.getInstance().getStateName());
        assertEquals("Preparado", PedidoPreparadoState.getInstance().getStateName());
        assertEquals("Enviado", PedidoEnviadoState.getInstance().getStateName());
        assertEquals("Entregue", PedidoEntregueState.getInstance().getStateName());
        assertEquals("Cancelado", PedidoCanceladoState.getInstance().getStateName());
    }
}