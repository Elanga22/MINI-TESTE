
package projeto.teste.Calculadora;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculadora2GUI extends JFrame implements ActionListener {
    private JTextField textField;
    private JButton button0, button1, button2, button3, button4, button5, button6, button7, button8, button9, buttonExponenciacao, buttonFatorial, buttonRestoDivisao;
    private JButton buttonAdd, buttonSubtract, buttonMultiply, buttonDivide, buttonEqual, buttonClear, buttonDot;
    private double numero1, numero2, resultado, base, expoente, calcularFatorial;
    private String operador;

    public Calculadora2GUI() {
        // Configurações da janela
        setTitle("Calculadora");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(300, 350);
        setLocationRelativeTo(null);

        // Configurações do painel
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());  // Usando BorderLayout
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(4, 4));  // GridLayout com 4 linhas e 4 colunas


        // Criação dos componentes
      //  textField = new JTextField();
         textField = new JTextField() {
            @Override
            public Dimension getPreferredSize() {
                // Defina as dimensões desejadas para a JTextField
                return new Dimension(super.getPreferredSize().width, 50); // Largura padrão e altura de 50 pixels
            }
        };

        button0 = new JButton("0");
        button1 = new JButton("1");
        button2 = new JButton("2");
        button3 = new JButton("3");
        button4 = new JButton("4");
        button5 = new JButton("5");
        button6 = new JButton("6");
        button7 = new JButton("7");
        button8 = new JButton("8");
        button9 = new JButton("9");
        buttonAdd = new JButton("+");
        buttonSubtract = new JButton("-");
        buttonMultiply = new JButton("*");
        buttonDot = new JButton(".");
        buttonDivide = new JButton("/");
        buttonEqual = new JButton("=");
        buttonClear = new JButton("C");
        buttonExponenciacao = new JButton("^");
        buttonFatorial = new JButton("!");
        buttonRestoDivisao = new JButton("%");

        // Adiciona os componentes ao painel
        panel.add(textField, BorderLayout.NORTH);
        buttonPanel.add(button1);
        buttonPanel.add(button2);
        buttonPanel.add(button3);
        buttonPanel.add(buttonDivide);
        buttonPanel.add(buttonMultiply);
        buttonPanel.add(button4);
        buttonPanel.add(button5);
        buttonPanel.add(button6);
        buttonPanel.add(buttonAdd);
        buttonPanel.add(buttonSubtract);
        buttonPanel.add(button7);
        buttonPanel.add(button8);
        buttonPanel.add(button9);
        buttonPanel.add(buttonDot);
        buttonPanel.add(buttonEqual);
        buttonPanel.add(button0);
        buttonPanel.add(buttonClear);
        buttonPanel.add(buttonExponenciacao);
        buttonPanel.add(buttonFatorial);
        buttonPanel.add(buttonRestoDivisao);

        
        
        panel.add(buttonPanel, BorderLayout.CENTER);

        // Adiciona o painel à janela
        add(panel);

        // Adiciona os listeners de ação aos botões
        button0.addActionListener(this);
        button1.addActionListener(this);
        button2.addActionListener(this);
        button3.addActionListener(this);
        button4.addActionListener(this);
        button5.addActionListener(this);
        button6.addActionListener(this);
        button7.addActionListener(this);
        button8.addActionListener(this);
        button9.addActionListener(this);
        buttonAdd.addActionListener(this);
        buttonSubtract.addActionListener(this);
        buttonMultiply.addActionListener(this);
        buttonDot.addActionListener(this);
        buttonDivide.addActionListener(this);
        buttonEqual.addActionListener(this);
        buttonClear.addActionListener(this);
        buttonExponenciacao.addActionListener(this);
        buttonFatorial.addActionListener(this);
        buttonRestoDivisao.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button0) {
            textField.setText(textField.getText() + "0");
        } else if (e.getSource() == button1) {
            textField.setText(textField.getText() + "1");
        } else if (e.getSource() == button2) {
            textField.setText(textField.getText() + "2");
        } else if (e.getSource() == button3) {
            textField.setText(textField.getText() + "3");
        } else if (e.getSource() == button4) {
            textField.setText(textField.getText() + "4");
        } else if (e.getSource() == button5) {
            textField.setText(textField.getText() + "5");
        } else if (e.getSource() == button6) {
           textField.setText(textField.getText() + "6");
        } else if (e.getSource() == button7) {
            textField.setText(textField.getText() + "7");
        } else if (e.getSource() == button8) {
            textField.setText(textField.getText() + "8");
        } else if (e.getSource() == button9) {
            textField.setText(textField.getText() + "9");
        }else if (e.getSource() == buttonDot) {
            textField.setText(textField.getText() + ".");
        }
        else if (e.getSource() == buttonAdd) {
            numero1 = Double.parseDouble(textField.getText());
            operador = "+";
            textField.setText("");
        } else if (e.getSource() == buttonSubtract) {
            numero1 = Double.parseDouble(textField.getText());
            operador = "-";
            textField.setText("");
        } else if (e.getSource() == buttonMultiply) {
            numero1 = Double.parseDouble(textField.getText());
            operador = "*";
            textField.setText("");
        } else if (e.getSource() == buttonDivide) {
            numero1 = Double.parseDouble(textField.getText());
            operador = "/";
            textField.setText("");
        } else if (e.getSource() == buttonEqual) {
            numero2 = Double.parseDouble(textField.getText());
            if (operador.equals("+")) {
                resultado = numero1 + numero2;
            } else if (operador.equals("-")) {
                resultado = numero1 - numero2;
            } else if (operador.equals("*")) {
                resultado = numero1 * numero2;
            } else if (operador.equals("/")) {
                resultado = numero1 / numero2;
            }
            textField.setText(String.valueOf(resultado));
        } else if (e.getSource() == buttonClear) {
            textField.setText("");
        } else if (e.getSource() == buttonExponenciacao) {
    // Obtenha os valores dos operandos da interface gráfica
    double base = Double.parseDouble(textField.getText());
    
    double expoente = Double.parseDouble(JOptionPane.showInputDialog("Digite o expoente"));

    // Realize a exponenciação
    double resultado = Math.pow(base, expoente);

    // Atualize a interface gráfica com o resultado
    textField.setText(String.valueOf(resultado));
} else if (e.getSource() == buttonFatorial) {
    // Obtenha o valor do número da interface gráfica
    int numero = Integer.parseInt(textField.getText());

    // Realize o cálculo do fatorial
    int resultado = calcularFatorial(numero);

    // Atualize a interface gráfica com o resultado
    textField.setText(String.valueOf(resultado));
}  else if (e.getSource() == buttonRestoDivisao) {
    // Obtenha o valor do dividendo da interface gráfica
    int dividendo = Integer.parseInt(textField.getText());

    // Obtenha o valor do divisor da interface gráfica
    int divisor = Integer.parseInt(JOptionPane.showInputDialog("Digite o divisor"));

    // Realize o cálculo do resto da divisão
    int resultado = dividendo % divisor;

    // Atualize a interface gráfica com o resultado
    textField.setText(String.valueOf(resultado));
}

    }
    private int calcularFatorial(int numero) {
    if (numero == 0 || numero == 1) {
        return 1;
    } else {
        int fatorial = 1;
        for (int i = 2; i <= numero; i++) {
            fatorial *= i;
        }
        return fatorial;
    }
}

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Calculadora2GUI().setVisible(true);
            }
        });
    }
}

