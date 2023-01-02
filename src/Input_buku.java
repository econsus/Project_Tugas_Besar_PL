import javax.swing.*;

public class Input_buku extends JFrame{
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JButton inputButton;
    protected JPanel form_input;
    private JButton kembaliButton;

    public void displayInput(Input_buku screen) {
        screen.setContentPane(screen.form_input);
        screen.setTitle("Testing");
        screen.setSize(400, 400);
        screen.setVisible(true);
        screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
