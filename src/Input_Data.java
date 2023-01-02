import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Input_Data extends JFrame{
    private JTextField fieldJudul;
    private JTextField fieldTahun;
    private JTextField fieldPenerbit;
    private JTextField fieldPengarang;
    private JTextField fieldRak;
    private JButton inputButton;
    private JPanel Input_Data;
    private JButton kembaliButton;

    private DatabaseManager databaseManager = new DatabaseManager();

    public void display (Input_Data screen) {
        screen.setContentPane(screen.Input_Data);
        screen.setTitle("Testing");
        screen.setSize(400, 400);
        screen.setVisible(true);
        screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        databaseManager.connect();
    }

    public void input_Button() {
        inputButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String judul, pengarang, penerbit, tahun, rak;
                judul = fieldJudul.getText();
                pengarang = fieldPengarang.getText();
                penerbit = fieldPenerbit.getText();
                tahun = fieldTahun.getText();
                rak = fieldRak.getText();
                databaseManager.exportData(judul, pengarang, penerbit, tahun, rak);
            }
        });
    }
}
