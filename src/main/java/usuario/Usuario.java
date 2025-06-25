package usuario;

import notificacao.INotificacao;
import notificacao.NotificacaoFactory;
import pedido.PedidoState;

import java.util.Map;
import java.util.Observable;
import java.util.Observer;

public class Usuario implements Observer {
    private final String name;
    private INotificacao notification;
    private String ultimaMensagem;

    public Usuario(String name, String PreferredNotificationType) {
        this.name = name;
        this.notification = NotificacaoFactory.getNotification(PreferredNotificationType);
    }

    public String getUltimaMensagem() {
        return ultimaMensagem;
    }

    @Override
    public void update(Observable o, Object argument) {
        if (argument instanceof Map) {
            Map<?, ?> evento = (Map<?, ?>) argument;
            String type = (String) evento.get("type");
            PedidoState estado = (PedidoState) evento.get("data");

            if(type.equals("StatusUpdate")) {
                String mensagem = name + " O status do seu pedido foi atualizado para: " + estado;
                this.ultimaMensagem = notification.send(mensagem);
            }
        }
    }
}
