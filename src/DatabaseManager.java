import java.sql.*;
import javax.swing.*;
public class DatabaseManager {
    private Connection connection;
    private PreparedStatement preparedStatement;

    /**
     * berfungsi untuk melakukan koneksi ke server database
     * @exception ClassNotFoundException terjadi jika driver class untuk JDBC tidak ditemukan
     * @exception SQLException terjadi saat terjadi error pada query database
     */
    public void connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost/tugasbesarpl","root","Imisthebest9");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int exportData(String judul, String pengarang, String penerbit, String tahun, String rak) {
        try {
            preparedStatement = connection.prepareStatement("INSERT INTO databuku (`Judul Buku`,`Pengarang Buku`,`Penerbit Buku`,`Tahun Terbit`,`Nomor Rak`) VALUES (?,?,?,?,?)");
            preparedStatement.setString(1, judul);
            preparedStatement.setString(2, pengarang);
            preparedStatement.setString(3, penerbit);
            preparedStatement.setString(4, tahun);
            preparedStatement.setString(5, rak);
            int execute = preparedStatement.executeUpdate();
            if(execute == 1) {
                System.out.println("Upload sukses");
            }
            else {
                System.out.println("Upload gagal");
            }

        } catch (SQLException e) {
            System.out.println("Upload gagal");
            e.printStackTrace();
        }
        return 0;
    }

    public void updateData (String judul, String pengarang, String penerbit,String tahun , String rak, String target) {
        try {
            preparedStatement = connection.prepareStatement("UPDATE databuku SET `Judul Buku` = ?, `Pengarang Buku` = ?, `Penerbit Buku` = ?, `Tahun Terbit` = ?, `Nomor Rak` = ?, WHERE `Judul Buku` = ?");
            preparedStatement.setString(1, judul);
            preparedStatement.setString(2, pengarang);
            preparedStatement.setString(3, penerbit);
            preparedStatement.setString(4, tahun);
            preparedStatement.setString(5, rak);
            preparedStatement.setString(6, target);
            int execute = preparedStatement.executeUpdate();
            if (execute == 1) {
                System.out.println("Update Berhasil");
            }
            else {
                System.out.println("Update Gagal");
            }
        } catch (SQLException e) {
            System.out.println("Update Gagal");
            e.printStackTrace();
        }
    }

    public void hapusData (String target) {
        try {
            preparedStatement = connection.prepareStatement("DELETE FROM databuku where `Judul Buku` = ?");
            preparedStatement.setString(1, target);
            int execute = preparedStatement.executeUpdate();
            if (execute == 1) {
                System.out.println("Data berhasil dihapus");
            }
            else {
                System.out.println("Data tidak terhapus");
            }
        } catch (SQLException e) {
            System.out.println("Data tidak terhapus");
            e.printStackTrace();
        }
    }

    public void selectData(String judulBuku) {
        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM databuku WHERE `Judul Buku` = ?");
            preparedStatement.setString(1, judulBuku);
            int execute = preparedStatement.executeUpdate();
            if (execute == 1) {
                System.out.println("Data Ditemukan");
            }
            else {
                System.out.println("Buku Yang Anda Cari Tidak Ditemukan");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
