import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EstoqueProdutos {
    private List<Produto> estoque = new ArrayList<>();

    public void adicionar(Produto produto) throws ProdutoDuplicadoException{ // aqui vai adicionar yoo


        for (Produto item : estoque){
            if (item.getNome().equalsIgnoreCase(produto.getNome())){
                throw new ProdutoDuplicadoException("⚠ OI, já tem um produto com esse nome! (" + produto.getNome() + ")");
            }
            if (item.getCodigo().equalsIgnoreCase(produto.getCodigo())){
                throw new ProdutoDuplicadoException("⚠️ Eita, já tem um produto com esse codigo! \nIsso não pode ser ignorado... (" + produto.getCodigo() + ")");
            }
        }

        estoque.add(produto);

    }

    public List<Produto> listarEstoque(){ //autoexplicativo, mas ele retorna os produtos salvos
        return estoque;
    }

    public boolean estaVazio(){
        return estoque.isEmpty();
    } // nota mental, eu preciso aprender a padronizar melhor as coisas, fica nessa mistura de ingles e pt br sempre
}
