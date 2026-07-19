public class MensagemParaTodos extends Mensagem{

    public MensagemParaTodos(String texto ,String emailRemetente, boolean anonima){
        super(texto, emailRemetente, anonima);
    }

    @Override
    public String getTextoCompletoAExibir() {
        if (ehAnonima()){
            return "Mensagem para todos.\nTexto: " + getTexto();
        } else {
            return "Mensagem de " + getEmailRemetente() + " para todos.\nTexto: " + getTexto();
        }
    }
}
