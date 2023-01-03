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
        update_Button();
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
    public void update_Button(){
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    boolean cekInput =  fieldJudul.getText().isEmpty() ||
                                        fieldPenerbit.getText().isEmpty() ||
                                        fieldPengarang.getText().isEmpty() ||
                                        fieldTahun.getText().isEmpty() ||
                                        fieldRak.getText().isEmpty();
                    if(cekInput){
                        throw new Exception("Mohon isi seluruh data yang valid");
                    }
                    int cekTahun = Integer.parseInt(fieldTahun.getText());
                    String judul, pengarang, penerbit, tahun, rak;
                    judul = fieldJudul.getText();
                    pengarang = fieldPengarang.getText();
                    penerbit = fieldPenerbit.getText();
                    tahun = fieldTahun.getText();
                    rak = fieldRak.getText();
                    databaseManager.updateData(judul, pengarang, penerbit, tahun, rak, judul);
                }catch (Exception ex){
                    JOptionPane.showMessageDialog(null,ex);
                }
            }
        });
    }
}
