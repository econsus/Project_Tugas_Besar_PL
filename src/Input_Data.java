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

    public void input_Button() {
        inputButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if(fieldJudul.getText().isEmpty()||fieldPenerbit.getText().isEmpty()||fieldPengarang.getText().isEmpty()||fieldTahun.getText().isEmpty()||fieldRak.getText().isEmpty()){
                        throw new Exception("Mohon isi seluruh data yang valid");
                    }
                    int x = Integer.parseInt(fieldTahun.getText());
                    String judul, pengarang, penerbit, tahun, rak;
                    judul = fieldJudul.getText();
                    pengarang = fieldPengarang.getText();
                    penerbit = fieldPenerbit.getText();
                    tahun = fieldTahun.getText();
                    rak = fieldRak.getText();
                    databaseManager.exportData(judul, pengarang, penerbit, tahun, rak);
                }catch (Exception ex){
                    JOptionPane.showMessageDialog(null,ex);
                }


            }
        });
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
    public void displayInput(Input_Data screen) {
        tombolKembali();
        screen.setContentPane(screen.Input_Data);
        screen.setTitle("Testing");
        screen.setSize(400, 400);
        screen.setVisible(true);
        screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        databaseManager.connect();
    }
}