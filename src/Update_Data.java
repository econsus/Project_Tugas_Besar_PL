import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

    public void displayUpdate(Update_Data screen) {
        tombolKembali();
        screen.setContentPane(screen.Update_Data);
        screen.setSize(400, 400);
        screen.setVisible(true);
        screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        databaseManager.connect();
    }
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
