package notificacao;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NotificacaoPushTest {
    @Test
    void deveRetornarNotificacaoPush() {
        INotificacao notificacao = NotificacaoFactory.getNotification("NotificacaoPush");

        assertTrue(notificacao instanceof NotificacaoPush);
        assertEquals("Enviando push: Teste", notificacao.send("Teste"));
    }
}