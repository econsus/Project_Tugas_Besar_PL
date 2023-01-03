import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

    public void displayMainScreen(Main_Screen screen) {
        tombolUpdate();
        tombolInput();
        tombolDelete();
        tombolCari();

        screen.setContentPane(screen.mainPanel);
        screen.setTitle("Testing");
        screen.setSize(400, 400);
        screen.setVisible(true);
        screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

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