import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GUI extends JFrame {

    ImageIcon paisagem = new ImageIcon("C:\\Users\\reydn\\Documents\\GitHub\\poo_repository_reyd\\ProjetoEx7\\imgs\\paisagem.jpg");
    JLabel linha1, linha2;
    JButton btnPesquisar, btnCatalogo, btnHistorico;
    JMenuBar barraDeMenu = new JMenuBar();

    public GUI(){
        setTitle("Atrativos Turisticos!");
        setSize(300, 300);
        setLocation(0, 0);
        setResizable(true); //deixei true so por motivos
        getContentPane().setBackground(Color.lightGray);
        setLayout(new BorderLayout (10,10));

        linha1 = new JLabel("Programa de turismo!", JLabel.CENTER);
        linha1.setForeground(Color.BLACK);
        linha1.setFont(new Font("Serif", Font.BOLD, 24));
        linha2 = new JLabel(paisagem, JLabel.CENTER);

        getContentPane().setLayout(new GridLayout(3,1));
        getContentPane().add(linha1);
        getContentPane().add(linha2);

        // Adicionando Botões!
        btnPesquisar = new JButton("Pesquisar");
        btnCatalogo = new JButton("Catalogo");
        btnHistorico = new JButton("Historico");

        JMenu menuPesquisa = new JMenu("Pesquisar");
        JMenu menuCatalogo = new JMenu("Catalogo");
        JMenu menuHistorico = new JMenu("Historico");
        JMenu menuConfig = new JMenu("Configuração");


        btnPesquisar.setToolTipText("Ele pesquisa");
        btnCatalogo.setToolTipText("Ele mostra o catalogo");
        btnHistorico.setToolTipText("Mostra teu historico de pesquisa");

        // ''Main'' do projeto
        getContentPane().setLayout(new GridLayout(3,2));
    }

    public static void main(String [] args){
        GUI janela = new GUI();
        janela.setVisible(true);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}