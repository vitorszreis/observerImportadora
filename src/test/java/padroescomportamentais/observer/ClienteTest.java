package padroescomportamentais.observer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClienteTest {

    @Test
    void deveNotificarUmCliente() {
        Embarque embarque = new Embarque(2026, 10, "China", "MSCU1234567");
        Cliente cliente = new Cliente("Cliente 1");
        cliente.acompanhar(embarque);
        embarque.liberarNaAlfandega();
        assertEquals("Cliente 1, carga liberada na alfândega no Embarque{ano=2026, mes=10, paisOrigem='China', numeroConteiner='MSCU1234567'}", cliente.getUltimaNotificacao());
    }

    @Test
    void deveNotificarClientes() {
        Embarque embarque = new Embarque(2026, 10, "China", "MSCU1234567");
        Cliente cliente1 = new Cliente("Cliente 1");
        Cliente cliente2 = new Cliente("Cliente 2");
        cliente1.acompanhar(embarque);
        cliente2.acompanhar(embarque);
        embarque.liberarNaAlfandega();
        assertEquals("Cliente 1, carga liberada na alfândega no Embarque{ano=2026, mes=10, paisOrigem='China', numeroConteiner='MSCU1234567'}", cliente1.getUltimaNotificacao());
        assertEquals("Cliente 2, carga liberada na alfândega no Embarque{ano=2026, mes=10, paisOrigem='China', numeroConteiner='MSCU1234567'}", cliente2.getUltimaNotificacao());
    }

    @Test
    void naoDeveNotificarCliente() {
        Embarque embarque = new Embarque(2026, 10, "China", "MSCU1234567");
        Cliente cliente = new Cliente("Cliente 1");
        embarque.liberarNaAlfandega();
        assertEquals(null, cliente.getUltimaNotificacao());
    }

    @Test
    void deveNotificarClienteEmbarqueMSCU1234567() {
        Embarque embarque1 = new Embarque(2026, 10, "China", "MSCU1234567");
        Embarque embarque2 = new Embarque(2026, 10, "Alemanha", "HLXU7654321");
        Cliente cliente1 = new Cliente("Cliente 1");
        Cliente cliente2 = new Cliente("Cliente 2");
        cliente1.acompanhar(embarque1);
        cliente2.acompanhar(embarque2);
        embarque1.liberarNaAlfandega();
        assertEquals("Cliente 1, carga liberada na alfândega no Embarque{ano=2026, mes=10, paisOrigem='China', numeroConteiner='MSCU1234567'}", cliente1.getUltimaNotificacao());
        assertEquals(null, cliente2.getUltimaNotificacao());
    }

    @Test
    void naoDeveNotificarClienteQueDeixouDeAcompanhar() {
        Embarque embarque = new Embarque(2026, 10, "China", "MSCU1234567");
        Cliente cliente1 = new Cliente("Cliente 1");
        Cliente cliente2 = new Cliente("Cliente 2");
        cliente1.acompanhar(embarque);
        cliente2.acompanhar(embarque);
        cliente2.deixarDeAcompanhar(embarque);
        embarque.liberarNaAlfandega();
        assertEquals("Cliente 1, carga liberada na alfândega no Embarque{ano=2026, mes=10, paisOrigem='China', numeroConteiner='MSCU1234567'}", cliente1.getUltimaNotificacao());
        assertEquals(null, cliente2.getUltimaNotificacao());
    }
}
