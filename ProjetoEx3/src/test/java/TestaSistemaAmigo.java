import java.util.List;
//pq não fazer um teste no modulo de testes do java? JUnit chora
public class TestaSistemaAmigo {
    public static void main(String[] args) {
        SistemaAmigo sistema = new SistemaAmigo();

        sistema.cadastraAmigo("José", "jose@email.com");
        sistema.cadastraAmigo("Maria", "maria@email.com");


        //Lembrando, mensagem para alguém é: texto, remetente, destinatario, é anonimo?
        //Mensagem para todos é texto, remetente, é anonimo?
        //testando cadastro dos amg
        try {
            sistema.configuraAmigoSecretoDe("jose@email.com", "maria@email.com");
            sistema.configuraAmigoSecretoDe("maria@email.com", "jose@email.com");
            System.out.println("Sorteio configurado com sucesso!");
        } catch (AmigoInexistenteException e) {
            System.out.println(e.getMessage());
        }


        //testando envio de mensagem
        sistema.enviarMensagemParaAlguem("[TESTE ALGUEM]oi sumido lembra d mim?","jose@email.com","maria@email.com",true);
        sistema.enviarMensagemParaTodos("[TESTE TODOS]Oi sumidosss, duvido saberem quem sou eu","maria@email.com",true);

        //testando o salvamento das mensagens e exibição
        List<Mensagem> mensagensAnonimas = sistema.pesquisaMensagensAnonimas();
        for (Mensagem msg : mensagensAnonimas) {
            System.out.println(msg.getTextoCompletoAExibir());
        }


        //testando se meu amigo secreto é realmente meu amigo secreto (ou não, vai que)
        try {
            String amigoDoJose = sistema.pesquisaAmigoSecretoDe("jose@email.com");
            if (amigoDoJose.equals("maria@email.com")) {
                System.out.println("[TESTE EQUALS]Sim, é o amigo de Jose");
            }
        } catch (AmigoInexistenteException | AmigoNaoSorteadoException e) {
            System.out.println(e.getMessage());
        }

    }
}