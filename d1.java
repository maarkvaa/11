import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;

public class d1 extends JFrame {

    private JTextField textField1;
    private JTextField textField2;

    public d1() {
        setTitle("Write Data to File");
        setSize(400, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(3, 1));

        JLabel label1 = new JLabel("Enter data (max 25 characters):");
        textField1 = new JTextField(25);
        JLabel label2 = new JLabel("Enter file path:");
        textField2 = new JTextField();
        JButton button = new JButton("Write to File");

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String data = textField1.getText();
                String filePath = textField2.getText();

                try (FileWriter writer = new FileWriter(filePath)) {
                    writer.write(data);
                    writer.flush();
                    JOptionPane.showMessageDialog(d1.this, "Data successfully written to the file.", "Success", JOptionPane.INFORMATION_MESSAGE);
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(d1.this, "Error writing to file: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        add(label1);
        add(textField1);
        add(label2);
        add(textField2);
        add(button);

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Main();
        });
    }
}
