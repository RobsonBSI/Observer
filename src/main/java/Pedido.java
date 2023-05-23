import java.util.Observable;

public class Pedido  extends Observable {
    private Integer numeroPedido;
    private String nomeLanche;
    private float valor;

    public Pedido(Integer numero, String nomeLanche, float valor) {
        this.numeroPedido = numero;
        this.nomeLanche = nomeLanche;
        this.valor = valor;
    }

    public void lancarPedido() {
        setChanged();
        notifyObservers();
    }

    @Override
    public String toString() {
        return "Pedido" +
                "(" + nomeLanche +
                ",Valor= " + valor +
                ")";
    }
}
