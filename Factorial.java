import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

class Factorial extends JFrame implements ActionListener{
    JTextField jtf;
    JButton[] buttons = new JButton[9];
    Factorial(){
        setLayout(null);
        setSize(600,600);
        jtf = new JTextField();
        jtf.setBounds(20, 20, 300, 30);
        add(jtf);
       
        int x=20,y=70,size=65,num=1;
        for(int i=0;i<3;i++){
            x=20;
            for(int j=0;j<3;j++)
            {
                JButton b = new JButton(""+num);
            b.setBounds(x,y,size,size);
            b.addActionListener(this);
            add(b);
            buttons[num-1] = b;
            x=20+x+size;
            num++;
            }
            y=y+size+20;
        }
        
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        JButton clickedButton=null;
      for(int i=0;i<9;i++){
        if(e.getSource()==buttons[i])
        {
            clickedButton = buttons[i];
            break;
        }
      }
      int fact =1;
      int n = Integer.parseInt(clickedButton.getText());
      for(int i=2;i<=n;i++)
      {
        fact*=i;
      }
      jtf.setText(fact+"");
        
    }
    public static void main(String[] args) {
        new Factorial();
    }
}
