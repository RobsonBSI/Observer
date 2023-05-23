import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClienteTest {
    @Test
    void deveNotificarUmCliente() {
        Pedido pedido = new Pedido(001, "X Bacon",20.50f);
        Cliente cliente = new Cliente("Robson");
        cliente.RegistraPedido(pedido);
        pedido.lancarPedido();
        assertEquals("Robson,O Pedido(X Bacon,Valor= 20.5),Foi Aceito", cliente.getUltimaNotificacao());
    }
}