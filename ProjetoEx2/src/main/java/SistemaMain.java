import java.util.ArrayList;
import java.util.Scanner;

// decidi fazer em terminal mesmo o menu, why not?
public class SistemaMain {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean sistemaRodando = true;
        EstoqueProdutos gerenciadorEstoque = new EstoqueProdutos();


        System.out.println("=====================================");
        System.out.println("  BEM-VINDO AO GERENCIADOR DE MERCADO  ");
        System.out.println("=====================================");

        while (sistemaRodando) {
            System.out.println("\n=-= MENU =-=");
            System.out.println("1 - Cadastrar novo item");
            System.out.println("2 - Listar estoque");
            System.out.println("3 - Sair do sistema");
            System.out.print("Digite a opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("\n-> Cadastrando novo item...");
                    System.out.println("Qual o nome do produto?"); //nome
                    String nomeSalvo = scanner.nextLine();
                    System.out.println("Insira o código de registro do produto");//codigo
                    String codigoSalvo = scanner.nextLine();
                    System.out.println("O produto é perecível?"); //perecivel
                    String respostaPerecivel = scanner.nextLine();
                    boolean perecivelSalvo = respostaPerecivel.equalsIgnoreCase("S"); //aprendi isso no guanabara hehe, eu acho?
                    System.out.println("Defina o valor do produto em R$:"); //valor
                    double valorSalvo = scanner.nextDouble();

                    scanner.nextLine();


                    Produto novoItem = new Produto(nomeSalvo, codigoSalvo, perecivelSalvo, valorSalvo);
                    gerenciadorEstoque.adicionar(novoItem);

                    break;
                case 2:
                    System.out.println("\n-> Listando itens cadastrados...");
                    if (gerenciadorEstoque.estaVazio()){
                        System.out.println("===-= ESTOQUE VAZIO! =-===");
                    }


                    // pretendo adicionar um if else aqui para determinar a questão do pericivel

                    for (Produto item : gerenciadorEstoque.listarEstoque()){
                        System.out.println("Nome do produto: " + item.getNome());
                        System.out.println("Codigo: " + item.getCodigo());
                        System.out.println("Preço: R$" + item.getValor());
                        // colocar para mostrar se o item é pericivel ou não
                    }

                    break;
                case 3:
                    System.out.println("\n-> Fechando o caixa. See Ya!");
                    sistemaRodando = false; // ele vai esganar o sistema e assim encerrar
                    break;
                default:
                    System.out.println("\n-> Opção inválida! Digite 1, 2 ou 3.");
            }
        }

        scanner.close();
    }
}