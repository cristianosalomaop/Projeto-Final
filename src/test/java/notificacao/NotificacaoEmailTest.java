package notificacao;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NotificacaoEmailTest {
    @Test
    void deveRetornarNotificacaoEmail() {
        INotificacao notificacao = NotificacaoFactory.getNotification("NotificacaoEmail");

        assertTrue(notificacao instanceof NotificacaoEmail);
        assertEquals("Enviando e-mail: Teste", notificacao.send("Teste"));
    }
}