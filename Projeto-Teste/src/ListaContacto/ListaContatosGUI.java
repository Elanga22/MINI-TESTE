/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ListaContacto;

/**
 *
 * @author Elton Langa
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class ListaContatosGUI extends JFrame {
    private JTextField nomeTextField, telefoneTextField;
    private JTextArea listaContatosTextArea;
    private List<Contato> listaContatos;

    public ListaContatosGUI() {
        super("Lista de Contatos");

        listaContatos = new ArrayList<>();

        // Painel de entrada de dados
        JPanel entradaDadosPanel = new JPanel(new GridLayout(3, 2));
        JLabel nomeLabel = new JLabel("Nome:");
        nomeTextField = new JTextField();
        JLabel telefoneLabel = new JLabel("Telefone:");
        telefoneTextField = new JTextField();
        JButton adicionarButton = new JButton("Adicionar");
        adicionarButton.addActionListener(new AdicionarContatoListener());
        entradaDadosPanel.add(nomeLabel);
        entradaDadosPanel.add(nomeTextField);
        entradaDadosPanel.add(telefoneLabel);
        entradaDadosPanel.add(telefoneTextField);
        entradaDadosPanel.add(adicionarButton);

        // Painel de lista de contatos
        JPanel listaContatosPanel = new JPanel();
        listaContatosPanel.setLayout(new BoxLayout(listaContatosPanel, BoxLayout.Y_AXIS));
        listaContatosTextArea = new JTextArea(10, 30);
        listaContatosTextArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(listaContatosTextArea);
        listaContatosPanel.add(scrollPane);

        // Painel principal
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(entradaDadosPanel, BorderLayout.NORTH);
        mainPanel.add(listaContatosPanel, BorderLayout.CENTER);

        // Configurações da janela
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(mainPanel);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private class AdicionarContatoListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String nome = nomeTextField.getText();
            String telefone = telefoneTextField.getText();
            Contato contato = new Contato(nome, telefone);
            listaContatos.add(contato);
            listaContatosTextArea.append(contato.toString() + "\n");
            nomeTextField.setText("");
            telefoneTextField.setText("");
        }
    }

    private class Contato {
        private String nome;
        private String telefone;

        public Contato(String nome, String telefone) {
            this.nome = nome;
            this.telefone = telefone;
        }

        @Override
        public String toString() {
            return nome + ": " + telefone;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new ListaContatosGUI();
            }
        });
    }
}

