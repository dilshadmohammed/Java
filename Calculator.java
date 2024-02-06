import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator extends JFrame implements ActionListener, KeyEventDispatcher {
    JTextField outputText;
    String val1, val2, op;

    Calculator() {
        setLayout(null);
        setSize(360, 400);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        outputText = new JTextField();
        outputText.setBounds(50, 50, 260, 60);
        outputText.setEditable(false);
        add(outputText);

        JButton b7 = createButton("7", 50, 130);
        JButton b8 = createButton("8", 120, 130);
        JButton b9 = createButton("9", 190, 130);
        JButton mul = createButton("*", 260, 130);

        JButton b4 = createButton("4", 50, 180);
        JButton b5 = createButton("5", 120, 180);
        JButton b6 = createButton("6", 190, 180);
        JButton div = createButton("/", 260, 180);

        JButton b1 = createButton("1", 50, 230);
        JButton b2 = createButton("2", 120, 230);
        JButton b3 = createButton("3", 190, 230);
        JButton sub = createButton("-", 260, 230);

        JButton b0 = createButton("0", 50, 280);
        JButton clear = createButton("C", 120, 280);
        JButton eqls = createButton("=", 190, 280);
        JButton plus = createButton("+", 260, 280);

        addActionListeners(b0, b1, b2, b3, b4, b5, b6, b7, b8, b9, plus, sub, mul, div, clear, eqls);
        KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(this);
        setVisible(true);
    }

    JButton createButton(String label, int x, int y) {
        JButton newButton = new JButton(label);
        newButton.setBounds(x, y, 50, 30);
        add(newButton);
        return newButton;
    }

    void addActionListeners(JButton... buttons) {
        for (JButton button : buttons) {
            button.addActionListener(this);
        }
    }

    Double evaluate() throws ArithmeticException {
        Double num1 = Double.parseDouble(val1);
        Double num2 = Double.parseDouble(val2);
        if (op.equals("/") && num2 == 0)
            throw new ArithmeticException("Math ERROR");
        switch (op) {
            case "+":
                return num1 + num2;
            case "-":
                return num1 - num2;
            case "/":
                return num1 / num2;
            case "*":
                return num1 * num2;
            default:
                return 0.0;
        }
    }

    void actions(char key) {
        switch (key) {
            case '+':
            case '-':
            case '/':
            case '*':
                op = "" + key;
                val1 = outputText.getText();
                outputText.setText("");
                break;
            case 'C':
            case 'c':
            case '\u007F':
                val1 = "";
                val2 = "";
                op = "";
                outputText.setText("");
                break;
            case '=':
            case '\n':
                val2 = outputText.getText();
                String result;
                try {
                    result = "" + evaluate();
                } catch (ArithmeticException e) {
                    result = e.getMessage();
                }
                outputText.setText(result);
                break;
            case '\b':
                String text = outputText.getText();
                if (!text.isEmpty()) {
                    outputText.setText(text.substring(0, text.length() - 1));
                }
                break;
            case '1':
            case '2':
            case '3':
            case '4':
            case '5':
            case '6':
            case '7':
            case '8':
            case '9':
            case '0':
                outputText.setText(outputText.getText() + key);
                break;
        }

    }

    public void actionPerformed(ActionEvent e) {
        JButton clickedButton = (JButton) e.getSource();
        actions(clickedButton.getText().charAt(0));
    }

    public boolean dispatchKeyEvent(KeyEvent e) {
        int id = e.getID();
        if (id == KeyEvent.KEY_TYPED)
            actions(e.getKeyChar());
        return false;
    }

    public static void main(String[] args) {
        new Calculator();
    }
}
