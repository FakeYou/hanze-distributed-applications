package javabank.DBHandlers;

import java.sql.*;

public class DBHandler {

    private static Connection connection;
    private Statement statement;
    private ResultSet resultSet;

    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/javabank";

    //  Database credentials
    static final String USER = "root";
    static final String PASS = "toor";

    /**
     * Register JDBC Driver
     */
    public DBHandler() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int add(String query) {
        int row = -1;
        try {
            statement = connection.createStatement();
            row = statement.executeUpdate(query);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                statement.close();
                connection.close();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return row;
    }

    public ResultSet get(String query) {
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                statement.close();
                connection.close();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return resultSet;
    }
}
