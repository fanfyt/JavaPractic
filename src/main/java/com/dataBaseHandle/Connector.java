package com.dataBaseHandle;
import java.sql.*;


public class Connector {

    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/boot-admin?useSSL=false", "root", "root");
    Statement stmt = conn.createStatement();

    public Connector() throws SQLException {

    }




    private static final Connector connector;

    static {
        try {
            connector = new Connector();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static Connector getConnector() {
        return connector;
    }
}
