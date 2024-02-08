import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class LayoutTest{
    JTextField jtf;
    String val1, val2, op;
    LayoutTest(){
        JFrame jf = new JFrame("Calculator");
        JPanel jp = new JPanel();
        JPanel outerPanel = new JPanel();
        outerPanel.setLayout(new BorderLayout());
        outerPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        jf.setSize(400,600);
        jp.setLayout(new GridLayout(4,4,10,10));
        jp.setBorder(BorderFactory.createEmptyBorder(20,0,0,0));
        jtf = new JTextField("");
        jtf.setHorizontalAlignment(SwingConstants.RIGHT);
        jtf.setFont(new Font("Ariel",10, 40));
        jtf.setEditable(false);
        //jf.setResizable(false);
        jtf.setPreferredSize(new Dimension(200, 50)); 
        outerPanel.add(jtf,BorderLayout.NORTH);
        JButton[] buttons = new JButton[16];
        String[] btexts = {"7","8","9","/","4","5","6","*","1","2","3","-","=","0","C","+"};
        for(int i=0;i<16;i++){
            JButton b=new JButton(btexts[i]);
            jp.add(b);
            b.setFont(new Font("Ariel",10, 20));
            b.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e){
                    JButton clickedButton = (JButton)e.getSource();
                    actions(clickedButton.getText().charAt(0));
                }
            });
            buttons[i]=b;
        }
        outerPanel.add(jp,BorderLayout.CENTER);
        jf.add(outerPanel);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setVisible(true);

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
                val1 = jtf.getText();
                jtf.setText("");
                break;
            case 'C':
            case 'c':
            case '\u007F':
                val1 = "";
                val2 = "";
                op = "";
                jtf.setText("");
                break;
            case '=':
            case '\n':
                val2 = jtf.getText();
                String result;
                try {
                    result = "" + evaluate();
                } catch (ArithmeticException e) {
                    result = e.getMessage();
                }
                jtf.setText(result);
                break;
            case '\b':
                String text = jtf.getText();
                if (!text.isEmpty()) {
                    jtf.setText(text.substring(0, text.length() - 1));
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
                jtf.setText(jtf.getText() + key);
                break;
        }

    }

    public static void main(String[] args) {
        new LayoutTest();
    }
}
