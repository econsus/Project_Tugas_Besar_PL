import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;

/**
 * Class untuk halaman menu cari
 */
public class cari_buku extends JFrame{
    private JTextField fieldCari;
    private JPanel cari_Buku;
    private JButton button;
    private JButton kembaliButton;
    private JTable tabelBuku;
    private DatabaseManager databaseManager = new DatabaseManager();

    /**
     *Method untuk menampilkan GUI dari halaman cari
     */
    public void display(cari_buku screen) {
        tombolKembali();
        screen.setContentPane(cari_Buku);
        screen.setTitle("Manajemen Perpustakaan");
        screen.setSize(800, 400);
        screen.setVisible(true);
        screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        databaseManager.connect();
    }

    /**
     * Method untuk memberikan fungsi dari search button
     */
    public void searchButton() {
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fetchData(fieldCari.getText());
            }
        });
    }

    /**
     * Memberikan fungsi dari back button
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
     * Method untuk mencari dan menampilkan data buku yang dicari
     * @param judulBuku
     */
    public void fetchData(String judulBuku) {
        try {
            int columntCount;
            Object[] columnTitle = {"Judul Buku", "Pengarang Buku", "Penerbit Buku", "Tahun Terbit", "Nomor Rak"};
            databaseManager.setPreparedStatement(databaseManager.getConnection().prepareStatement("SELECT * FROM databuku WHERE `Judul Buku` = ?"));
            databaseManager.getPreparedStatement().setString(1, judulBuku);
            databaseManager.setResultSet(databaseManager.getPreparedStatement().executeQuery());
            ResultSetMetaData metaData = databaseManager.getResultSet().getMetaData();
            columntCount = metaData.getColumnCount();
            DefaultTableModel model = new DefaultTableModel(null, columnTitle);
            tabelBuku.setModel(model);
            model.setRowCount(0);
            while(databaseManager.getResultSet().next()) {
                Vector vector2 = new Vector();
                for (int i = 1; i <= columntCount; i++) {
                    vector2.add(databaseManager.getResultSet().getString("Judul Buku"));
                    vector2.add(databaseManager.getResultSet().getString("Pengarang Buku"));
                    vector2.add(databaseManager.getResultSet().getString("Penerbit Buku"));
                    vector2.add(databaseManager.getResultSet().getString("Tahun Terbit"));
                    vector2.add(databaseManager.getResultSet().getString("Nomor Rak"));
                }
                model.addRow(vector2);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }



    }
}
