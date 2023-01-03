import java.sql.*;
import javax.swing.*;

/**
 * Class untuk manajemen database
 */
public class DatabaseManager {
    private PreparedStatement preparedStatement;
    private Connection connection;
    private ResultSet resultSet;

    /**
     * Method Setter Getter untuk class lain mengakses atribut dari database
     * @return preparedStatement
     */
    public PreparedStatement getPreparedStatement() {
        return preparedStatement;
    }

    public void setPreparedStatement(PreparedStatement preparedStatement) {
        this.preparedStatement = preparedStatement;
    }

    /**
     * Method Setter dan Getter untuk class lain  mengakses database
     * @return connection
     */
    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    /**
     * Method Setter dan Getter untuk class lain mengakses hasil Query database
     * @return resultSet
     */
    public ResultSet getResultSet() {
        return resultSet;
    }

    public void setResultSet(ResultSet resultSet) {
        this.resultSet = resultSet;
    }

    /**
     * berfungsi untuk melakukan koneksi program ke server database
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

    /**
     * Method untuk memasukkan data buku kedalam database
     * @param judul
     * @param pengarang
     * @param penerbit
     * @param tahun
     * @param rak
     */
    public void exportData(String judul, String pengarang, String penerbit, String tahun, String rak) {
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
    }

    /**
     * Method untuk mengupdate data buku di database berdasarkan pencarian pengguna
     * @param judul
     * @param pengarang
     * @param penerbit
     * @param tahun
     * @param rak
     * @param target
     */
    public void updateData (String judul, String pengarang, String penerbit,String tahun , String rak, String target) {
        try {
            preparedStatement = connection.prepareStatement("UPDATE databuku SET `Judul Buku` = ?, `Pengarang Buku` = ?, `Penerbit Buku` = ?, `Tahun Terbit` = ?, `Nomor Rak` = ? WHERE `Judul Buku` = ?");
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

    /**
     * Method untuk menghapus data buku di database berdasarkan pencarian pengguna
     * @param target
     */
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
}
