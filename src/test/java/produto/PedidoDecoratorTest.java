package produto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PedidoDecoratorTest {
    @Test
    void pizzaBaseDeveTerDescricaoEPrecoCorretos() {
        IProduto pizza = new PizzaBase();

        assertEquals("Pizza básica", pizza.getDescricao());
        assertEquals(70.0, pizza.getPreco());
    }

    @Test
    void bordaRecheadaDeveAdicionarDescricaoEPreco() {
        IProduto pizza = new PizzaBase();
        IProduto pizzaComBorda = new BordaRecheada(pizza);

        assertEquals("Pizza básica, borda recheada", pizzaComBorda.getDescricao());
        assertEquals(77.0, pizzaComBorda.getPreco());
    }
}