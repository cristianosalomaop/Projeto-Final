package notificacao;

public class NotificacaoEmail implements INotificacao {
    @Override
    public String send(String mensagem) {
        return "Enviando e-mail: " + mensagem;
    }
}