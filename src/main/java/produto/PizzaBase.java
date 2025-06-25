package produto;

public class PizzaBase implements IProduto {
    @Override
    public String getDescricao() {
        return "Pizza básica";
    }

    @Override
    public double getPreco() {
        return 70.0;
    }
}
