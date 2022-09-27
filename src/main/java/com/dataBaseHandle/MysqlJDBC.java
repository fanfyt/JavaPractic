package com.dataBaseHandle;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MysqlJDBC {
    public static void main(String[] args) throws SQLException {
        Connector connector = Connector.getConnector();

        String sql = "select * from edc_deform";

        PreparedStatement statement = connector.conn.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();
        System.out.println(resultSet.getArray(1));
    } //频繁
}
