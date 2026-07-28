import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class AgendaAyla implements Agenda {

    private Map<String, Contato> contatos;
    private final GravadorDeDados gravador;

    public AgendaAyla() {
        this.gravador = new GravadorDeDados();
        this.contatos = new HashMap<>();
        recuperarDados();
    }

    @Override
    public void salvarDados() {
        gravador.salvarContatos(contatos);
    }

    @Override
    public void recuperarDados() {
        contatos = gravador.recuperarContatos();
    }

    @Override
    public boolean cadastraContato(String nome, int dia, int mes) throws ContatoJaExisteException {
        if (!contatos.containsKey(nome)) {
            throw new ContatoJaExisteException("Esse contato já existe, não tem como existir dois dele né?");
        }
        contatos.put(nome, new Contato(nome, dia, mes));
        return true;
    }

    @Override
    public Collection<Contato> pesquisaAniversariantes(int dia, int mes) {
        Collection<Contato> aniversariantes = new java.util.ArrayList<>();
        for (Contato c : contatos.values()) {
            if (c.getDiaAniversario() == dia && c.getMesAniversario() == mes) {
                aniversariantes.add(c);
            }
        }
        return aniversariantes;
    }

    @Override
    public boolean removeContato(String nome) throws ContatoInexistenteException {
        if (!contatos.containsKey(nome)) {
            throw new ContatoInexistenteException("Esse contato não existe.\nNão tem como apagar alguém já apagado, né?");
        }
        contatos.remove(nome);
        return true;
    }
}