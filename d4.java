import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class d4 extends JFrame {
    private JTextField outputField;

    public d4() {
        setTitle("Генератор случайных чисел");
        setSize(200, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(2, 1));

        outputField = new JTextField(10);
        outputField.setEditable(false); // Поле ввода неизменяемо для пользователя
        add(outputField);

        JButton generateButton = new JButton("Сгенерировать числа");
        generateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StringBuilder output = new StringBuilder();
                for (int i = 0; i < 7; i++) {
                    int randomNumber = (int) (Math.random() * 100); // Генерация случайного числа от 0 до 99
                    output.append(randomNumber).append("\n"); // Добавление числа с переносом строки
                }
                outputField.setText(output.toString());
            }
        });
        add(generateButton);

        setVisible(true);
    }

    public static void main(String[] args) {
        new d4();
    }
}
