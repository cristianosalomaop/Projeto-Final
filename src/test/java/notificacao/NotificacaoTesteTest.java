package notificacao;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NotificacaoTesteTest {

    @Test
    void deveLancarExcecaoParaNotificacaoTesteNaoImplementeInterface() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            NotificacaoFactory.getNotification("NotificacaoTeste");
        });

        assertEquals("Forma de notificação não implementa a interface", exception.getMessage());
    }
}