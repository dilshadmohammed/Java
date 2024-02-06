import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.*;

import javax.swing.*;

public class Traffic extends JFrame implements ActionListener{
    
    JRadioButton red,yellow,green;
    Color red_c = new Color(128, 0, 0),yellow_c = new Color(128, 64, 0),green_c = new Color(0, 77, 26);
    
    Traffic()
    {
        setTitle("Traffic Light");
        setSize(300,500);

        red = new JRadioButton("Red");
        green = new JRadioButton("Green");
        yellow = new JRadioButton("Yellow");

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(red);
        buttonGroup.add(yellow);
        buttonGroup.add(green);

        red.addActionListener(this);
        yellow.addActionListener(this);
        green.addActionListener(this);


        JPanel controlPanel = new JPanel();
        controlPanel.setLayout(new GridLayout(3,1));
        controlPanel.add(red);
        controlPanel.add(yellow);
        controlPanel.add(green);

        TrafficPanel trafficPanel = new TrafficPanel(); 
        add(trafficPanel, BorderLayout.CENTER);
        add(controlPanel,BorderLayout.EAST);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        
    }

    public void actionPerformed(ActionEvent e) {
        red.setSelected(false);
        yellow.setSelected(false);
        green.setSelected(false);

        if (e.getSource() == red) {
            red.setSelected(true);
            red_c = Color.RED;
            yellow_c = new Color(128, 64, 0);
            green_c = new Color(0, 77, 26);
        } else if (e.getSource() == yellow) {
            yellow.setSelected(true);
           red_c = new Color(128, 0, 0);
            yellow_c = Color.YELLOW;
            green_c = new Color(0, 77, 26);
        } else if (e.getSource() == green) {
            green.setSelected(true);
            red_c = new Color(128, 0, 0);
            yellow_c = new Color(128, 64, 0);
            green_c = Color.GREEN;
        }

        repaint();
        JRadioButton clickButton = (JRadioButton)e.getSource();
        System.out.println("Clicke working"+clickButton.getText());
    }

    
    private class TrafficPanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            g.drawOval(50, 50, 50, 50);
            g.drawOval(50, 110, 50, 50);
            g.drawOval(50, 170, 50, 50);

            g.setColor(red_c);
            g.fillOval(50, 50, 50, 50);

            g.setColor(yellow_c);
            g.fillOval(50, 110, 50, 50);

            g.setColor(green_c);
            g.fillOval(50, 170, 50, 50);

            System.out.println("Painting");
        }
    }

    public static void main(String[] args) {
        new Traffic().repaint();
    }
}
