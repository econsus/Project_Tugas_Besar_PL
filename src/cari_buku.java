import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;

public class cari_buku extends JFrame{
    private JTextField textField1;
    private JPanel cari_Buku;
    private JButton button;
    private JButton kembaliButton;
    private JTable tabelBuku;
    private DatabaseManager databaseManager = new DatabaseManager();

    public JPanel getCari_Buku() {
        return cari_Buku;
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }

    public void display(cari_buku screen) {
        screen.setContentPane(cari_Buku);
        screen.setSize(400, 400);
        screen.setVisible(true);
        screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        databaseManager.connect();
    }

    public void searchButton() {
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fetchData(textField1.getText());
            }
        });
    }

    public void fetchData(String judulBuku) {
        try {
            int columntCount;
            databaseManager.preparedStatement = databaseManager.connection.prepareStatement("SELECT * FROM databuku WHERE `Judul Buku` = ?");
            databaseManager.preparedStatement.setString(1, judulBuku);
            databaseManager.resultSet = databaseManager.preparedStatement.executeQuery();
            ResultSetMetaData metaData = databaseManager.resultSet.getMetaData();
            columntCount = metaData.getColumnCount();
            DefaultTableModel model = (DefaultTableModel)tabelBuku.getModel();
            model.setRowCount(0);
            while(databaseManager.resultSet.next()) {
                Vector vector2 = new Vector();
                for (int i = 1; i <= columntCount; i++) {
                    vector2.add(databaseManager.resultSet.getString("Judul Buku"));
                    vector2.add(databaseManager.resultSet.getString("Pengarang Buku"));
                    vector2.add(databaseManager.resultSet.getString("Penerbit Buku"));
                    vector2.add(databaseManager.resultSet.getString("Tahun Terbit"));
                    vector2.add(databaseManager.resultSet.getString("Nomor Rak"));
                }
                model.addRow(vector2);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }



    }
}
