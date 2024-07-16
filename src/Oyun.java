import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Oyun extends JFrame {
    private JPanel mainPanel;
    private JTextField Cevap;
    private JLabel Soru;
    private JButton OnayTusu;
    private JLabel Sonuc;
    private JLabel Skor;
    private JLabel ad;

    private int correctAnswer;
    private int score;

    public Oyun() {
        score = 0;
        generateQuestion();

        OnayTusu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkAnswer();
            }
        });
    }

    private void generateQuestion() {
        Random rand = new Random();
        int num1 = rand.nextInt(10) + 1;
        int num2 = rand.nextInt(10) + 1;
        correctAnswer = num1 * num2;
        Soru.setText(num1 + " x " + num2 + " = ?");
        Cevap.setText("");

    }

    private void checkAnswer() {
        try {
            int userAnswer = Integer.parseInt(Cevap.getText());
            if (userAnswer == correctAnswer) {
                score++;

            }
            Skor.setText("Skor: " + score);
            generateQuestion();
        } catch (NumberFormatException e) {
            Sonuc.setText("Geçersiz giriş! Lütfen bir sayı girin.");
        }
    }

    public static void main(String[] args) {
        JFrame frame = new Oyun();
        frame.setContentPane(new Oyun().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}

