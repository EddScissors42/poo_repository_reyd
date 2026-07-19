import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;

public class SistemaAmigoMap {
    private List<Mensagem> mensagens;
    private Map<String, Amigo> amigos;

    public SistemaAmigoMap(){
        this.amigos = new HashMap<>();
        this.mensagens = new ArrayList<>();
    }


    public void cadastraAmigo(String nomeAmigo, String emailAmigo){
        Amigo novoAmg = new Amigo(nomeAmigo, emailAmigo);
        this.amigos.put(emailAmigo, novoAmg);
    }

    // o Map é algo engraçado, esse metodo no outro sistema é super longo e aqui é super resumido em uma unica linhakkkkk
    public Amigo pesquisaAmigo(String emailAmigo){
        return this.amigos.get(emailAmigo);
    }

    public List<Mensagem> pesquisaMensagensAnonimas(){
        List<Mensagem> mensagensAnonimas = new ArrayList<>();

        for (Mensagem msg : mensagens){
            if(msg.ehAnonima()){
                mensagensAnonimas.add(msg);
            }
        }
        return mensagensAnonimas;
    }


    public void configuraAmigoSecretoDe(String emailDaPessoa, String emailAmigoSorteado) throws AmigoInexistenteException, AmigoNaoSorteadoException{

        Amigo pessoa = pesquisaAmigo(emailDaPessoa);
        if (pessoa == null){
            throw new AmigoInexistenteException("[ERRO]Oops, essa pessoa com e-mail " + emailDaPessoa + " mencionado não foi encontrado(a)");
        }
        pessoa.setAmigoSorteado(emailAmigoSorteado);
    }

    public List<Mensagem> pesquisaTodasAsMensagens(){
        return this.mensagens;
    }

    public String pesquisaAmigoSecretoDe(String emailDaPessoa) throws AmigoInexistenteException{
        Amigo pessoa = pesquisaAmigo(emailDaPessoa);

        if (pessoa == null){
            throw new AmigoInexistenteException("[ERRO]Vixe, essa pessoa não está cadastrada...");
        }

        if (pessoa.getAmigoSorteado() == null){
            throw new AmigoNaoSorteadoException("[ERRO]Está pessoa ainda não tem um amigo secreto configurado");
        }

        return pessoa.getAmigoSorteado();
    }

    // agora o resto da magica do programa, eu acho, deveria voltar a separar as coisas

    public void enviarMensagemParaTodos(String texto, String emailRemetente, boolean ehAnonima){
        MensagemParaTodos novaMsg = new MensagemParaTodos(texto, emailRemetente, ehAnonima);

        this.mensagens.add(novaMsg);
    }

    public void enviarMensagemParaAlguem(String texto, String emailRemetente, String emailDestinatario, boolean ehAnonima){
        MensagemParaAlguem novaMsg = new MensagemParaAlguem(texto, emailRemetente, emailDestinatario, ehAnonima);

        this.mensagens.add(novaMsg);
    }

}