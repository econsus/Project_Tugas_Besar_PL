import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Class untuk halaman input
 */
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

    /**
     * Method untuk memberikan fungsi pada input button dan memasukkan data buku ke dataabase
     * @exception Exception ketika pengguna klik button tanpa mengisi keseluruhan data
     * @exception NumberFormatException ketika pengguna mengisi selain bilangan pada data tahun
     */
    public void input_Button() {
        inputButton.addActionListener(new ActionListener() {
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
                    databaseManager.exportData(judul, pengarang, penerbit, tahun, rak);
                }catch (Exception ex){
                    JOptionPane.showMessageDialog(null,ex);
                }


            }
        });
    }

    /**
     * Memberikan fungsi paca back button
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

    /**
     * Menampilkan GUI dari halaman input
     */
    public void displayInput(Input_Data screen) {
        tombolKembali();
        screen.setContentPane(screen.Input_Data);
        screen.setTitle("Manajemen Perpustakaan");
        screen.setSize(400, 400);
        screen.setVisible(true);
        screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        databaseManager.connect();
    }
}