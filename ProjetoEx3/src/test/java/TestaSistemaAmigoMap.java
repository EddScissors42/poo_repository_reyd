import java.util.List;
//o mesmo do testasistemaamigo, mas agora com Map, :O evoluçãaao
public class TestaSistemaAmigoMap {
    public static void main(String[] args) {
        SistemaAmigoMap sistema = new SistemaAmigoMap();

        sistema.cadastraAmigo("Edd", "Edd@gmail.com");
        sistema.cadastraAmigo("May", "May@gmail.com");
        try {
            sistema.configuraAmigoSecretoDe("Edd@gmail.com", "May@gmail.com");
            sistema.configuraAmigoSecretoDe("May@gmail.com", "Edd@gmail.com");
            System.out.println("[MAIN]Sorteio configurado com sucesso!");
        } catch (AmigoInexistenteException e) {
            System.out.println(e.getMessage());
        }
        sistema.enviarMensagemParaAlguem("[TESTE ALGUEM]Loren Ispeum ou algo assim","Edd@gmail.com","May@gmail.com",true);
        sistema.enviarMensagemParaTodos("[TESTE TODOS]Quem sera que sou eu","May@gmail.com",true);
        List<Mensagem> mensagensAnonimas = sistema.pesquisaMensagensAnonimas();
        for (Mensagem msg : mensagensAnonimas) {
            System.out.println(msg.getTextoCompletoAExibir());
        }


        //testando se meu amigo secreto é realmente meu amigo secreto (ou não, vai que)
        try {
            String amigoDoEdd = sistema.pesquisaAmigoSecretoDe("Edd@gmail.com");
            if (amigoDoEdd.equals("May@gmail.com")) {
                System.out.println("[TESTE EQUALS]Sim, é o amigo do Edd");
            }
        } catch (AmigoInexistenteException | AmigoNaoSorteadoException e) {
            System.out.println(e.getMessage());
        }

    }
}