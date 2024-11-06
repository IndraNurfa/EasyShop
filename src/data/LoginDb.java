/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import entity.LoginEntity;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Nurfa
 */
public class LoginDb {

    private Conn c = new Conn();
    private Connection conn;

    private UserDataDb dataUser = new UserDataDb();

    public String loginCek(LoginEntity l) throws SQLException {
        conn = c.getConnection();
        String query = "SELECT * FROM login WHERE username=? AND password=?";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1, l.getUsername());
        ps.setString(2, l.getPassword());
        ResultSet rs = ps.executeQuery();
        String cek = "";
        while (rs.next()) {
            String username = rs.getString("username");
            String level = rs.getString("level");
            cek = level;
            if (level.equals("user")) {
                dataUser.getDataUser(username);
            }
        }

        rs.close();
        ps.close();
        conn.close();

        return cek;
    }
}