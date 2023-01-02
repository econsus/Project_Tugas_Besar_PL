import javax.swing.*;

public class Update_Data extends JFrame{
    private JPanel Update_Data;
    private JTextField fieldJudul;
    private JTextField fieldPenerbit;
    private JTextField fieldTahun;
    private JTextField fieldRak;
    private JTextField fieldPengarang;
    private JButton updateButton;
    private JButton kembaliButton;
    private DatabaseManager databaseManager = new DatabaseManager();

    public void display(Update_Data screen) {
        screen.setContentPane(screen);
        screen.setSize(400, 400);
        screen.setVisible(true);
        screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        databaseManager.connect();
    }
}
