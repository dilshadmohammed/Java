import javax.swing.*;
import java.awt.event.*;

class Prime implements ActionListener {

    JTextField jtf;
    JLabel jl;
    Prime(){
        JFrame jf = new JFrame("Prime or Not");
        jf.setLayout(null);
        jf.setSize(400,400);

        jtf = new JTextField();
        jtf.setBounds(150, 150, 100, 40);
        jf.add(jtf);

        JButton jb = new JButton("Click me");
        jb.setBounds(160, 210, 150, 60);
        jb.addActionListener(this);
        jf.add(jb);

        jl = new JLabel();
        jl.setBounds(100, 290, 200, 40);
        jf.add(jl);
        
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setVisible(true);
    }

    public void actionPerformed(ActionEvent e){
        int num = Integer.parseInt(jtf.getText());
        for(int i=2;i<num/2;i++){
            if(num%i==0){
                jl.setText(num+" is not a prime number");
                return;
            }
        }
        jl.setText(num+" is a Prime number");
    }
    public static void main(String[] args) {
        new Prime();
    }
}
