package notificacao;

public class NotificacaoFactory {
    public static INotificacao getNotification(String notificationType){
        Class<?> classe = null;
        Object objeto = null;

        try{
            classe = Class.forName("notificacao." + notificationType);
            objeto = classe.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            throw new IllegalArgumentException("Forma de notificação não encontrada");
        }

        if (!(objeto instanceof INotificacao)) {
            throw new IllegalArgumentException("Forma de notificação não implementa a interface");
        }

        return (INotificacao) objeto;
    }
}
