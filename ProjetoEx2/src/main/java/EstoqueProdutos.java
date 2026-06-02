import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EstoqueProdutos {
    private List<Produto> estoque = new ArrayList<>();

    public void adicionar(Produto produto){ // aqui vai adicionar produto
        estoque.add(produto);
    }

    public List<Produto> listarEstoque(){ //auto-explicativo, mas ele retorna os produtos salvos
        return estoque;
    }

    public boolean estaVazio(){
        return estoque.isEmpty();
    } // nota mental, eu preciso aprender a padronizar melhor as coisas, fica nessa mistura de ingles e pt br sempre
}
