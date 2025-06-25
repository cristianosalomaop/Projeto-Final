package notificacao;

public class NotificacaoPush implements INotificacao {
    @Override
    public String send(String mensagem) {
        return "Enviando push: " + mensagem;
    }
}