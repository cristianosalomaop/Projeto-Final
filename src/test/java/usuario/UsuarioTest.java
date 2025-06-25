package usuario;

import org.junit.jupiter.api.Test;
import pedido.Pedido;
import pedido.PedidoPreparadoState;
import produto.BordaRecheada;
import produto.IProduto;
import produto.PizzaBase;

import static org.junit.jupiter.api.Assertions.*;

class UsuarioTest {
    @Test
    void usuarioRecebeNotificacaoEmailAoAtualizarPedidoPizzaSimples() {
        Usuario usuario = new Usuario("João", "NotificacaoEmail");

        IProduto pizza = new PizzaBase();
        Pedido pedido = new Pedido(pizza);

        pedido.addObserver(usuario);
        pedido.setEstado(PedidoPreparadoState.getInstance());

        assertNotNull(usuario.getUltimaMensagem());
        assertTrue(usuario.getUltimaMensagem().contains("Enviando e-mail: João O status do seu pedido foi atualizado para:"));
    }

    @Test
    void usuarioRecebeNotificacaoPushAoAtualizarPedidoPizzaSimples() {
        Usuario usuario = new Usuario("João", "NotificacaoPush");

        IProduto pizza = new PizzaBase();
        Pedido pedido = new Pedido(pizza);

        pedido.addObserver(usuario);
        pedido.setEstado(PedidoPreparadoState.getInstance());

        assertNotNull(usuario.getUltimaMensagem());
        assertTrue(usuario.getUltimaMensagem().contains("Enviando push: João O status do seu pedido foi atualizado para:"));
    }

    @Test
    void usuarioRecebeNotificacaoEmailAoAtualizarPedidoPizzaComBorda() {
        Usuario usuario = new Usuario("João", "NotificacaoEmail");

        IProduto pizza = new PizzaBase();
        IProduto pizzaComBorda = new BordaRecheada(pizza);
        Pedido pedido = new Pedido(pizzaComBorda);

        pedido.addObserver(usuario);
        pedido.setEstado(PedidoPreparadoState.getInstance());

        assertNotNull(usuario.getUltimaMensagem());
        assertTrue(usuario.getUltimaMensagem().contains("Enviando e-mail: João O status do seu pedido foi atualizado para:"));
    }

    @Test
    void usuarioRecebeNotificacaoPushAoAtualizarPedidoPizzaComBorda() {
        Usuario usuario = new Usuario("João", "NotificacaoPush");

        IProduto pizza = new PizzaBase();
        IProduto pizzaComBorda = new BordaRecheada(pizza);
        Pedido pedido = new Pedido(pizzaComBorda);

        pedido.addObserver(usuario);
        pedido.setEstado(PedidoPreparadoState.getInstance());

        assertNotNull(usuario.getUltimaMensagem());
        assertTrue(usuario.getUltimaMensagem().contains("Enviando push: João O status do seu pedido foi atualizado para:"));
    }
}