public class Amigo {
    private String nome;
    private String email;
    private String AmigoSorteado;

    public Amigo(String nomeAmigo, String emailAmigo){
        this.nome = nomeAmigo;
        this.email = emailAmigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAmigoSorteado() {
        return AmigoSorteado;
    }

    public void setAmigoSorteado(String emailAmigoSorteado) {
        this.AmigoSorteado = emailAmigoSorteado;
    }
}
