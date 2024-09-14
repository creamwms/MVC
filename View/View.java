package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Controller.CSVReader;
import Controller.CowIDCheck;
import Controller.CowTypeChecker;
import java.util.List;

public class View {
    private JFrame frame;
    private JPanel panel;
    private JTextField textFieldForCowID;
    private CSVReader csvReader;
    private CowIDCheck cowIDCheck;
    private CowTypeChecker cowTypeChecker;

    public View() {
        // Create JFrame
        frame = new JFrame("Cow Strike Milk Testing No.2");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 600);

        // Create JPanel
        panel = new JPanel();
        panel.setLayout(new FlowLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));

        // Create JLabel for CowID
        JLabel EnterCowID_Label = new JLabel("Enter CowID");
        EnterCowID_Label.setFont(new Font("monospace", Font.PLAIN, 20));

        // Create JTextField for Entering CowID
        textFieldForCowID = new JTextField(8);
        textFieldForCowID.setFont(new Font("monospace", Font.PLAIN, 20));

        // Create button for checking CowID
        JButton checkCowIDButton = new JButton("Check");
        checkCowIDButton.setFont(new Font("monospace", Font.PLAIN, 15));

        // Initialize CSVReader, CowIDCheck, and CowTypeChecker
        csvReader = new CSVReader("Model/data.csv");
        List<String[]> csvData = csvReader.readCSV();
        cowTypeChecker = new CowTypeChecker(csvData);
        cowIDCheck = new CowIDCheck();

        // Add ActionListener for button
        checkCowIDButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Clear previous content in panel
                panel.removeAll();

                // Get CowID from TextField
                String cowID = textFieldForCowID.getText();

                // Check CowID
                if (cowIDCheck.cowIDCheck(cowID)) {
                    // If CowID is valid
                    String[] cowData = csvReader.findCowById(cowID); // Retrieve cow data by ID

                    if (cowData != null) {
                        // Check CowType
                        String cowType = cowTypeChecker.checkCowType(cowID);
                        JButton milkButton = new JButton("Milk Cow");
                        milkButton.setFont(new Font("monospace", Font.PLAIN, 15));
                        JButton LemonButton = new JButton("Milk Cow");
                        LemonButton.setFont(new Font("monospace", Font.PLAIN, 15));

                        if (cowType != null) {
                            // Display cow info
                            JLabel cowInfoLabel = new JLabel("Cow ID: " + cowData[0] + " | Type: " + cowData[1] + " | Year: " + cowData[2]);
                            cowInfoLabel.setFont(new Font("monospace", Font.PLAIN, 20));
                            panel.add(cowInfoLabel);
                            panel.add(milkButton);

                            if (cowData[1]=="White") {
                                panel.add(LemonButton);
                            }
                            
                            if ("White".equals(cowType)) {
                                panel.add(LemonButton);
                                ViewWhiteCow viewWhiteCow = new ViewWhiteCow(cowID);
                                panel.add(viewWhiteCow);
                            }

                            // Create and add view based on CowType
                            if ("Brown".equals(cowType)) {
                                ViewBrownCow viewBrownCow = new ViewBrownCow(cowID, 0);
                                panel.add(viewBrownCow);
                            }

                            // Refresh layout of panel
                            panel.revalidate();
                            panel.repaint();
                        } else {
                            JOptionPane.showMessageDialog(frame, "Cow Type not found", "Result", JOptionPane.ERROR_MESSAGE);
                        }
                    } else {
                        JOptionPane.showMessageDialog(frame, "Cow ID not found", "Result", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    // If CowID is invalid
                    JOptionPane.showMessageDialog(frame, "Invalid CowID: " + cowID + "\nPlease enter CowID again", "Result", JOptionPane.ERROR_MESSAGE);
                }
                
                // Clear the text field
                textFieldForCowID.setText("");
            }
        });

        // Add components to panel
        panel.add(EnterCowID_Label);
        panel.add(textFieldForCowID);
        panel.add(checkCowIDButton);

        // Add JPanel to JFrame
        frame.add(panel);

        // Show JFrame
        frame.setVisible(true);
    }
}
