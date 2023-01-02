import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class delete_buku extends JFrame{
    private JTextField textField1;
    private JButton cariButton;
    private JButton deleteButton;
    private JPanel deletePanel;
    private DatabaseManager databaseManager = new DatabaseManager();

    public void display(delete_buku screen) {
        screen.setContentPane(screen.deletePanel);
        screen.setTitle("Testing");
        screen.setSize(400, 400);
        screen.setVisible(true);
        screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        databaseManager.connect();
    }

    public void deleteButton () {
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String judulBuku = textField1.getText();
                databaseManager.hapusData(judulBuku);
            }
        });
    }
}
