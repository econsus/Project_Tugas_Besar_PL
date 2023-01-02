import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//change color
public class TestFormAndData extends JFrame {
    private JPanel testPanel;
    private JTextField inputJudul;
    private JLabel judulBuku;
    private JTextField inputPengarang;
    private JLabel pengarang;
    private JButton inputButton;
    private JTextField inputPenerbit;
    private JTextField inputTahun;
    private JTextField inputRak;
    private JButton kembaliButton;
   private DatabaseManager databaseManager = new DatabaseManager();

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
    public String getJudulText() {
        return inputJudul.getText();
    }
    public String getPengarangText() {
        return inputPengarang.getText();
    }
    public String getPenerbitText() {
        return inputPenerbit.getText();
    }
    public String getTahunText() {
        return inputTahun.getText();
    }
    public String getRakText() {
        return inputRak.getText();
    }

    public void displayMainScreen(TestFormAndData screen) {
        screen.setContentPane(screen.testPanel);
        screen.setTitle("Testing");
        screen.setSize(400, 400);
        screen.setVisible(true);
        screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        databaseManager.connect();
    }

    public void uploadBuku() {
        inputButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Tombol dipencet");
                databaseManager.exportData(getJudulText(), getPengarangText(), getPenerbitText(), getTahunText(), getRakText());
            }
        });
    }

}
