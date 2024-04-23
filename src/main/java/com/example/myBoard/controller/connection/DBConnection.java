package com.example.myBoard.controller.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private static Connection dbConn;

    public static Connection getDbConn() {
        if (dbConn == null) {
            try {
                String url = "jdbc:mysql://localhost:3306/article";
                String username = "root";
                String password = "1111";
                dbConn = DriverManager.getConnection(url,
                        username, password);
                System.out.println("DB연결 성공");
            } catch (SQLException e) {
                System.out.println("DB 실패");
                System.out.print("사유 : " + e.getMessage());
            }
        }

        return dbConn;
    }
    public static void close() throws SQLException {
        if (!dbConn.isClosed()){
            dbConn.close();
        }
    }
}