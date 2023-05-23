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
    @Test
    void deveNotificarOsClientes() {
        Pedido pedido = new Pedido(001, "X Bacon",20.50f);
        Cliente cliente = new Cliente("Robson");
        Cliente cliente1 = new Cliente("Julio");
        cliente1.RegistraPedido(pedido);
        cliente.RegistraPedido(pedido);
        cliente1.RegistraPedido(pedido);
        pedido.lancarPedido();
        assertEquals("Robson,O Pedido(X Bacon,Valor= 20.5),Foi Aceito", cliente.getUltimaNotificacao());
        assertEquals("Julio,O Pedido(X Bacon,Valor= 20.5),Foi Aceito", cliente1.getUltimaNotificacao());
    }
    @Test
    void deveNotificarOsClientesSeuPedidoEspecifico() {
        Pedido pedido = new Pedido(001, "X Bacon",20.50f);
        Pedido pedido2 = new Pedido(002, "Hamburguer Artesanal",15.00f);
        Cliente cliente = new Cliente("Robson");
        Cliente cliente1 = new Cliente("Julio");
        cliente1.RegistraPedido(pedido);
        cliente.RegistraPedido(pedido);
        cliente1.RegistraPedido(pedido2);
        pedido.lancarPedido();
        pedido2.lancarPedido();
        assertEquals("Robson,O Pedido(X Bacon,Valor= 20.5),Foi Aceito", cliente.getUltimaNotificacao());
        assertEquals("Julio,O Pedido(Hamburguer Artesanal,Valor= 15.0),Foi Aceito", cliente1.getUltimaNotificacao());
    }
    @Test
    void naoDeveNotificarCliente() {
        Pedido pedido = new Pedido(001, "X Bacon",20.50f);
        Cliente cliente = new Cliente("Robson");
        cliente.RegistraPedido(pedido);
        assertEquals(null, cliente.getUltimaNotificacao());
    }
}