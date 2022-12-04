package org.implementation.gateways;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Timer;
import java.util.TimerTask;

public class DBConnection{
    private static final String connectionStr = "jdbc:mysql://localhost:3306/testdb";
    private static Connection connection = null;
    private static Timer timer;

    public static Connection getConnection() throws SQLException {
        resetTimer();

        if(connection == null || connection.isClosed()) {
            connection = DriverManager.getConnection(connectionStr, "root", "1234");
            System.out.println("DB Connection Opened");
            return connection;
        }

        return connection;
    }

    public static void close(){
        try {
            if(connection != null) {
                connection.close();
                connection = null;

                System.out.println("DB Connection Closed");
            }

            timer = null;
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void resetTimer(){
        if(timer != null)
            timer.cancel();
        timer = new Timer(true);
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                close();
            }
        }, 30000);
    }
}
