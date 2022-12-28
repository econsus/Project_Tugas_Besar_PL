import javax.swing.*;

public class TestFormAndData {
    private JPanel testPanel;
    private JTextField inputJudul;
    private JLabel judulBuku;
    private JTextField inputPengarang;
    private JLabel pengarang;
    private JButton inputButton;
    private JTextField inputPenerbit;
    private JTextField inputTahun;
    private JTextField inputRak;
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

}