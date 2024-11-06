/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import com.mysql.cj.jdbc.MysqlDataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author Nurfa
 */
public class Conn {
    private final MysqlDataSource DATA_SOURCE = new MysqlDataSource();
    private final String DB_URL = "jdbc:mysql://localhost:3306/EasyShop?serverTimezone=Asia/Jakarta";
    private final String DB_USERNAME = "root";
    private final String DB_PASSWORD = "";
    
    public Connection getConnection() throws SQLException{
        DATA_SOURCE.setURL(DB_URL);
        DATA_SOURCE.setUser(DB_USERNAME);
        DATA_SOURCE.setPassword(DB_PASSWORD);
        Connection conn = DATA_SOURCE.getConnection();
        return conn;
    }
}
