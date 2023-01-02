import javax.swing.*;
import java.awt.*;

public class cari_buku extends JFrame{
    private JTextField textField1;
    private JPanel cari_Buku;
    private JButton button;
    private JButton kembaliButton;
    private DatabaseManager databaseManager = new DatabaseManager();

    public JPanel getCari_Buku() {
        return cari_Buku;
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }

    public void display(cari_buku screen) {
        screen.setContentPane(cari_Buku);
        screen.setSize(400, 400);
        screen.setVisible(true);
        screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        databaseManager.connect();
    }
}
