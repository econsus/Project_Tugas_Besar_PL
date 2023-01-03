import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Class untuk halaman menu utama
 */
public class Main_Screen extends JFrame {
    private JPanel mainPanel;
    private JButton cariBukuButton;
    private JButton inputBukuButton;
    private JButton deleteBukuButton;
    private JButton updateBukuButton;
    private cari_buku cariBuku = new cari_buku();
    DatabaseManager databaseManager = new DatabaseManager();
    //private TestFormAndData inputPanel = new TestFormAndData();

    private Input_Data input_data = new Input_Data();
    private Update_Data update_data = new Update_Data();
    private delete_buku deleteBuku = new delete_buku();

    /**
     * Method untuk menampilkan GUI dari halaman utama
     */
    public void displayMainScreen(Main_Screen screen) {
        fungsiTombol();

        screen.setContentPane(screen.mainPanel);
        screen.setTitle("Manajemen Perpustakaan");
        screen.setSize(400, 400);
        screen.setVisible(true);
        screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * Method untuk memanggil fungsi button
     */
    private void fungsiTombol() {
        tombolUpdate();
        tombolInput();
        tombolDelete();
        tombolCari();
    }

    /**
     * Method untuk memberikan fungsi dari menu input button
     */
    public void tombolInput() {
        inputBukuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                input_data.input_Button();
                dispose();
                input_data.displayInput(input_data);
            }
        });
    }

    /**
     * Method untuk memberikan fungsi dari menu update button
     */
    public void tombolUpdate() {
        updateBukuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                update_data.update_Button();
                update_data.displayUpdate(update_data);
            }
        });
    }

    /**
     * Method untuk memberikan fungsi dari delete menu button
     */
    public void tombolDelete() {
        deleteBukuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                deleteBuku.deleteButton();
                deleteBuku.display(deleteBuku);
            }
        });
    }

    /**
     * Method untuk memberikan fungsi dari cari menu button
     */
    public void tombolCari() {
        cariBukuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                cariBuku.searchButton();
                cariBuku.display(cariBuku);
            }
        });
    }
}