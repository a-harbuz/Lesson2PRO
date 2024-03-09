package de.telran.pro008JDBC;

import java.sql.*;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        String url = "jdbc:mysql://localhost:3306/bank";
        String user = "root";
        String passwd = "Zxc123!@#";

        //Class.forName("com.mysql.jdbc.Driver");
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection(url, user, passwd);
        //otvech za zaprosi
        //PreparedStatement
        Statement statement = connection.createStatement();
        String selectSQL = "SELECT * FROM users";
        ResultSet resultSet = statement.executeQuery(selectSQL);

        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            System.out.println("ID: "+id);
        }
    }
}
