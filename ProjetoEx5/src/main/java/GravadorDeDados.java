import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class GravadorDeDados {

    public static final String ARQUIVO_CONTATOS = "contatos.dat";

    public HashMap<String, Contato> recuperarContatos() {
        HashMap<String, Contato> contatos = new HashMap<>();

        File arquivo = new File(ARQUIVO_CONTATOS);
        if (!arquivo.exists()) {
            return contatos;
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(arquivo))) {
            contatos = (HashMap<String, Contato>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return contatos;
    }

    public void salvarContatos(Map<String, Contato> contatos) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ARQUIVO_CONTATOS))) {
            oos.writeObject(contatos);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}