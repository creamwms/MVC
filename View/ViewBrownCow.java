package View;

import javax.swing.*;
import Controller.BrownMilkCheck;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewBrownCow extends JPanel {
    private JButton milkButton;


    public ViewBrownCow(String cowID, int ageYears) {


        // Create Milk Button
        milkButton = new JButton("Milk Cow");
        milkButton.setFont(new Font("monospace", Font.PLAIN, 15));
        milkButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                milkCow();
            }
        });

        // Add buttons to panel
        this.setLayout(new FlowLayout());
        this.add(milkButton);
    }

    // Check Milk from brown cow
    private void milkCow() {
        String milkResult = BrownMilkCheck.milkCow1();
        System.out.println(milkResult);
    }
}
