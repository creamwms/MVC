package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewWhiteCow extends JPanel {
    private JButton milkButton;
    private JButton lemonButton;
    private boolean isLemonAdded; 

    public ViewWhiteCow(String cowID) {
        isLemonAdded = false;

        // Create Milk Button
        milkButton = new JButton("Milk Cow");
        milkButton.setFont(new Font("monospace", Font.PLAIN, 15));
        milkButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                milkCow2();
            }
        });

        // Create Lemon Button
        lemonButton = new JButton("Add Lemon");
        lemonButton.setFont(new Font("monospace", Font.PLAIN, 15));
        lemonButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addLemon();
            }
        });

        // Add buttons to panel
        this.setLayout(new FlowLayout());
        this.add(milkButton);
        this.add(lemonButton);
    }

    // made milk
    private void milkCow2() {
        if (isLemonAdded) {
            System.out.println("yogurt Milk");
        } else {
            System.out.println("Regular Milk");
        }
    }

    // check is LemonAdded
    private void addLemon() {
        isLemonAdded = true;
        System.out.println("Lemon added to milk");
    }
}
