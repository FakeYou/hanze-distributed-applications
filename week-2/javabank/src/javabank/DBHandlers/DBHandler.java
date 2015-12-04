package javabank.DBHandlers;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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

    public HashMap get(String query) {
        HashMap resultMap = new HashMap();
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);

            resultMap = resultSetToHashMap(resultSet);

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
        return resultMap;
    }

    public List resultSetToArrayList(ResultSet rs) throws SQLException{
        ResultSetMetaData md = rs.getMetaData();
        int columns = md.getColumnCount();
        ArrayList list = new ArrayList(50);
        while (rs.next()){
            HashMap row = new HashMap(columns);
            for(int i=1; i<=columns; ++i){
                row.put(md.getColumnName(i),rs.getObject(i));
            }
            list.add(row);
        }

        return list;
    }

    public HashMap resultSetToHashMap(ResultSet rs) throws SQLException{
        ResultSetMetaData md = rs.getMetaData();
        int columns = md.getColumnCount();
        HashMap row = new HashMap(columns);
        while (rs.next()){
            for(int i=1; i<=columns; ++i){
                row.put(md.getColumnName(i),rs.getObject(i));
            }
        }
        return row;
    }
}
