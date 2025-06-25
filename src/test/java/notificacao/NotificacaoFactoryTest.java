package notificacao;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class NotificacaoFactoryTest {
    @Test
    void deveRetornarNotificacaoEmail() {
        INotificacao notificacao = NotificacaoFactory.getNotification("NotificacaoEmail");

        assertTrue(notificacao instanceof NotificacaoEmail);
        assertEquals("Enviando e-mail: Teste", notificacao.send("Teste"));
    }

    @Test
    void deveLancarExcecaoParaTipoInvalido() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            NotificacaoFactory.getNotification("NotificacaoTeste");
        });

        assertEquals("Forma de notificação não implementa a interface", exception.getMessage());
    }

    @Test
    void deveLancarExcecaoParaTipoInexistente() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            NotificacaoFactory.getNotification("NonExistentShipping");
        });

        assertEquals("Forma de notificação não encontrada", exception.getMessage());
    }
}