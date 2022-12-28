import java.sql.*;
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

    public void exportData() {

    }
}
