//  Establish a connection to a mSQL database using JDBC
import java.sql.*;

public class driver {
    /**
     * Connect to a sample database
     */
    public static Connection connect(Connection conn) {
        try {
            // db parameters
            String url = "jdbc:sqlite:C:/Users/mexva/IdeaProjects/20Questions/db/testdb.db";
            // create a connection to the database
            conn = DriverManager.getConnection(url);

            System.out.println("Connection to SQLite has been established.");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }
    /**
     * Here is where we start the program after we connect to the database
     */
    public static void main(String[] args) {
        Connection conn = null;
        conn = connect(conn);

        Tree tree = new Tree(conn);
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
