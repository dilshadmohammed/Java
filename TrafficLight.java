import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class TrafficLight implements ActionListener {
    Color red, orange, green;
    JFrame jf;
    ButtonGroup buttons;

    TrafficLight() {
        jf = new JFrame("Traffic Light");
        JRadioButton redb = new JRadioButton("Red");
        JRadioButton orangeb = new JRadioButton("Orange");
        JRadioButton greenb = new JRadioButton("Green");

        buttons = new ButtonGroup();
        buttons.add(redb);
        buttons.add(orangeb);
        buttons.add(greenb);
        redb.addActionListener(this);
        orangeb.addActionListener(this);
        greenb.addActionListener(this);
        red = jf.getBackground();
        orange = jf.getBackground();
        green = jf.getBackground();

        JPanel controls = new JPanel();
        controls.add(redb);
        controls.add(orangeb);
        controls.add(greenb);
        jf.add(controls, BorderLayout.NORTH);
        Lights lights = new Lights();
        jf.add(lights, BorderLayout.CENTER);
        jf.setSize(300, 600);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        jf.setVisible(true);

    }

    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        red = jf.getBackground();
        orange = jf.getBackground();
        green = jf.getBackground();
        switch (command) {
            case "Red":
                red = Color.RED;
                break;
            case "Orange":
                orange = Color.ORANGE;
                break;
            case "Green":
                green = Color.GREEN;
                break;
        }
        jf.repaint();

    }

    class Lights extends JPanel {

        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawOval(100, 50, 50, 50);
            g.drawOval(100, 110, 50, 50);
            g.drawOval(100, 170, 50, 50);

            g.setColor(red);
            g.fillOval(100, 50, 50, 50);

            g.setColor(orange);
            g.fillOval(100, 110, 50, 50);

            g.setColor(green);
            g.fillOval(100, 170, 50, 50);
        }
    }

    public static void main(String[] args) {
        new TrafficLight();
    }
}
