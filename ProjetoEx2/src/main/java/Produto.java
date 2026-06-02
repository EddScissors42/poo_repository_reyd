public class Produto { // o começo de tudo! decidi que iria fazer um mini gerenciador de produtos de supermercado
    private String nome;
    private String codigo;
    private boolean perecivel;
    private double valor;

    public Produto(String nome, String codigo, boolean perecivel, double valor){
        this.nome = nome;
        this.valor = valor;
        this.codigo = codigo;
        this.perecivel = perecivel;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCodigo() {
        return codigo;
    }
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public boolean isPerecivel() {
        return perecivel;
    }
    public void setPerecivel(boolean perecivel) {
        this.perecivel = perecivel;
    }

    public double getValor() {
        return valor;
    }
    public void setValor(double valor) {
        this.valor = valor;
    }

}
