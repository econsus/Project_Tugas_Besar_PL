import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main_Screen extends JFrame {
    private JButton inputBukuButton;
    private JPanel mainPanel;
    private JButton cariBukuButton;
    Input_buku input_Screen = new Input_buku();

    public void displayMainScreen() {
        Main_Screen screen = new Main_Screen();
        screen.setContentPane(screen.mainPanel);
        screen.setTitle("Testing");
        screen.setSize(400, 400);
        screen.setVisible(true);
        screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        inputBukuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                screen.setContentPane(input_Screen.form_input);
            }
        });
    }


}
