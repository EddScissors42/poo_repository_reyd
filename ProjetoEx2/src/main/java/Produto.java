import java.util.Objects;

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

    public String TextoPerecivel() {
        if (perecivel) {
            return "Sim";
        } else {
            return "Não";
        }
    }


    @Override
        public String toString() {
            return "Produto [Nome=" + nome +
                    ", Código=" + codigo +
                    ", Perecível=" + TextoPerecivel() +
                    ", Valor=R$" + valor + "]";
    }

    @Override // confesso que esse conceito ficou um pouco abstraido ate demais, confuso na minha cabeça, só sei q parece q fucniona
    public boolean equals(Object obj){
        if (this == obj){
            return true;
        }
        if (!(obj instanceof Produto)){
            return false;
        }
        Produto outroProduto = (Produto) obj; // ISSO AQUI JÁ É UM PRODUTO ENTÃO ELE SERA COMO TAL!!!!!

        return Objects.equals(this.codigo, outroProduto.codigo); // iniciando a comparação vamos lá!
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo);
    }
}
