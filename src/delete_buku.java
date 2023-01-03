import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Class halaman menu delete
 */
public class delete_buku extends JFrame{
    private JTextField textField1;
    private JButton kembaliButton;
    private JButton deleteButton;
    private JPanel deletePanel;
    private DatabaseManager databaseManager = new DatabaseManager();

    /**
     * Method untuk menampilkan GUI dari halaman delete
     * @param screen
     */
    public void display(delete_buku screen) {
        deleteButton();
        tombolKembali();
        screen.setContentPane(screen.deletePanel);
        screen.setTitle("Manajemen Perpustakaan");
        screen.setSize(400, 400);
        screen.setVisible(true);
        screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        databaseManager.connect();
    }

    /**
     * Method untuk memberikan fungsi dari delete button
     */
    public void deleteButton () {
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String judulBuku = textField1.getText();
                databaseManager.hapusData(judulBuku);
            }
        });
    }

    /**
     * Method untuk memberikan fungsi dari back button
     */
    public void tombolKembali(){
        kembaliButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main_Screen mainScreen = new Main_Screen();
                dispose();
                mainScreen.displayMainScreen(mainScreen);
            }
        });
    }
}
