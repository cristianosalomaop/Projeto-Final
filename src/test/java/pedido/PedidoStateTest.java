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

    // ESTADO: Criado

    @Test
    void estadoCriadoDeveSerEstadoInicial() {
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
    void estadoCriadoNaoDevePermitirEnviar() {
        assertFalse(pedido.getEstado().enviar(pedido));
        assertTrue(pedido.getEstado() instanceof PedidoCriadoState);
    }

    @Test
    void estadoCriadoNaoDevePermitirEntregar() {
        assertFalse(pedido.getEstado().entregar(pedido));
        assertTrue(pedido.getEstado() instanceof PedidoCriadoState);
    }

    // ESTADO: Preparado

    @Test
    void estadoPreparadoDevePermitirEnviar() {
        pedido.setEstado(PedidoPreparadoState.getInstance());
        assertTrue(pedido.getEstado().enviar(pedido));
        assertTrue(pedido.getEstado() instanceof PedidoEnviadoState);
    }

    @Test
    void estadoPreparadoDevePermitirCancelar() {
        pedido.setEstado(PedidoPreparadoState.getInstance());
        assertTrue(pedido.getEstado().cancelar(pedido));
        assertTrue(pedido.getEstado() instanceof PedidoCanceladoState);
    }

    @Test
    void estadoPreparadoNaoDevePermitirPreparar() {
        pedido.setEstado(PedidoPreparadoState.getInstance());
        assertFalse(pedido.getEstado().preparar(pedido));
    }

    @Test
    void estadoPreparadoNaoDevePermitirEntregar() {
        pedido.setEstado(PedidoPreparadoState.getInstance());
        assertFalse(pedido.getEstado().entregar(pedido));
    }

    // ESTADO: Enviado

    @Test
    void estadoEnviadoDevePermitirEntregar() {
        pedido.setEstado(PedidoEnviadoState.getInstance());
        assertTrue(pedido.getEstado().entregar(pedido));
        assertTrue(pedido.getEstado() instanceof PedidoEntregueState);
    }

    @Test
    void estadoEnviadoDevePermitirCancelar() {
        pedido.setEstado(PedidoEnviadoState.getInstance());
        assertTrue(pedido.getEstado().cancelar(pedido));
        assertTrue(pedido.getEstado() instanceof PedidoCanceladoState);
    }

    @Test
    void estadoEnviadoNaoDevePermitirPreparar() {
        pedido.setEstado(PedidoEnviadoState.getInstance());
        assertFalse(pedido.getEstado().preparar(pedido));
    }

    @Test
    void estadoEnviadoNaoDevePermitirEnviar() {
        pedido.setEstado(PedidoEnviadoState.getInstance());
        assertFalse(pedido.getEstado().enviar(pedido));
    }

    // ESTADO: Entregue

    @Test
    void estadoEntregueNaoDevePermitirPreparar() {
        pedido.setEstado(PedidoEntregueState.getInstance());
        assertFalse(pedido.getEstado().preparar(pedido));
    }

    @Test
    void estadoEntregueNaoDevePermitirEnviar() {
        pedido.setEstado(PedidoEntregueState.getInstance());
        assertFalse(pedido.getEstado().enviar(pedido));
    }

    @Test
    void estadoEntregueNaoDevePermitirEntregar() {
        pedido.setEstado(PedidoEntregueState.getInstance());
        assertFalse(pedido.getEstado().entregar(pedido));
    }

    @Test
    void estadoEntregueNaoDevePermitirCancelar() {
        pedido.setEstado(PedidoEntregueState.getInstance());
        assertFalse(pedido.getEstado().cancelar(pedido));
    }

    // ESTADO: Cancelado

    @Test
    void estadoCanceladoNaoDevePermitirPreparar() {
        pedido.setEstado(PedidoCanceladoState.getInstance());
        assertFalse(pedido.getEstado().preparar(pedido));
    }

    @Test
    void estadoCanceladoNaoDevePermitirEnviar() {
        pedido.setEstado(PedidoCanceladoState.getInstance());
        assertFalse(pedido.getEstado().enviar(pedido));
    }

    @Test
    void estadoCanceladoNaoDevePermitirEntregar() {
        pedido.setEstado(PedidoCanceladoState.getInstance());
        assertFalse(pedido.getEstado().entregar(pedido));
    }

    @Test
    void estadoCanceladoNaoDevePermitirCancelar() {
        pedido.setEstado(PedidoCanceladoState.getInstance());
        assertFalse(pedido.getEstado().cancelar(pedido));
    }

    // NOMES DOS ESTADOS

    @Test
    void deveRetornarNomeCorretoDosEstados() {
        assertEquals("Criado", PedidoCriadoState.getInstance().getStateName());
        assertEquals("Preparado", PedidoPreparadoState.getInstance().getStateName());
        assertEquals("Enviado", PedidoEnviadoState.getInstance().getStateName());
        assertEquals("Entregue", PedidoEntregueState.getInstance().getStateName());
        assertEquals("Cancelado", PedidoCanceladoState.getInstance().getStateName());
    }
}