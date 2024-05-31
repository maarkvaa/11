
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class d2 extends JFrame {
    private JTextField firstNameField;
    private JTextField lastNameField;
    private JTextField patronymicField;
    private JTextField dobField;
    private JTextField groupField;

    public d2() {
        setTitle("Запись и загрузка данных");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(6, 2));

        JLabel firstNameLabel = new JLabel("Имя:");
        firstNameField = new JTextField(20);
        add(firstNameLabel);
        add(firstNameField);

        JLabel lastNameLabel = new JLabel("Фамилия:");
        lastNameField = new JTextField(20);
        add(lastNameLabel);
        add(lastNameField);

        JLabel patronymicLabel = new JLabel("Отчество:");
        patronymicField = new JTextField(20);
        add(patronymicLabel);
        add(patronymicField);

        JLabel dobLabel = new JLabel("Дата рождения:");
        dobField = new JTextField(20);
        add(dobLabel);
        add(dobField);

        JLabel groupLabel = new JLabel("Учебная группа:");
        groupField = new JTextField(20);
        add(groupLabel);
        add(groupField);

        JButton saveButton = new JButton("Записать");
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    FileWriter writer = new FileWriter("student_data.txt");
                    writer.write(firstNameField.getText() + "\n");
                    writer.write(lastNameField.getText() + "\n");
                    writer.write(patronymicField.getText() + "\n");
                    writer.write(dobField.getText() + "\n");
                    writer.write(groupField.getText() + "\n");
                    writer.close();
                    JOptionPane.showMessageDialog(null, "Данные успешно записаны в файл.");
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, "Ошибка при записи в файл: " + ex.getMessage());
                }
            }
        });
        add(saveButton);

        JButton loadButton = new JButton("Загрузить");
        loadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    BufferedReader reader = new BufferedReader(new FileReader("student_data.txt"));
                    firstNameField.setText(reader.readLine());
                    lastNameField.setText(reader.readLine());
                    patronymicField.setText(reader.readLine());
                    dobField.setText(reader.readLine());
                    groupField.setText(reader.readLine());
                    reader.close();
                    JOptionPane.showMessageDialog(null, "Данные успешно загружены из файла.");
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, "Ошибка при загрузке из файла: " + ex.getMessage());
                }
            }
        });
        add(loadButton);

        setVisible(true);
    }

    public static void main(String[] args) {
        new Main();
    }
}
