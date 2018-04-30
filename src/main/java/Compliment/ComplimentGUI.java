package Compliment;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ComplimentGUI extends JFrame{
    private JPanel mainPanel;
    private JLabel complimentText;
    private JButton getCompliment;

    // constructor to configure ComplimentGUI
    ComplimentGUI() {
        setContentPane(mainPanel);
        setPreferredSize(new Dimension(400, 150));
        pack();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        // action listener for JButton
        getCompliment.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                complimentText.setText("Thinking of a compliment...");
                ComplimentClient.getCompliment(ComplimentGUI.this);
            }
        });
    }

    public void complimentMessage(String compliment) {
        complimentText.setText(compliment);
    }
}
