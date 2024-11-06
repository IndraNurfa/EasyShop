/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import entity.RegisterEntity;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;

/**
 *
 * @author Nurfa
 */
public class RegisterDb {

    private Conn c = new Conn();
    private Connection conn;

    private UserDataDb dataUser = new UserDataDb();

    public boolean dataInsert(RegisterEntity r) throws SQLException {
        conn = c.getConnection();
        String query = "INSERT INTO data_user(username, nama, email) VALUES(?,?,?)";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1, r.getUsername());
        ps.setString(2, r.getNama());
        ps.setString(3, r.getEmail());
        int barisTerpengaruh = ps.executeUpdate();
        dataUser.getDataUser(r.getUsername());
        ps.close();
        conn.close();
        return barisTerpengaruh == 1;
    }

    public boolean loginInsert(RegisterEntity rE) throws SQLException {
        conn = c.getConnection();
        String query = "INSERT INTO login(username, password, level) VALUES(?,?,?)";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1, rE.getUsername());
        ps.setString(2, rE.getPassword());
        ps.setString(3, "user");
        int barisTerpengaruh = ps.executeUpdate();
        ps.close();
        conn.close();
        return barisTerpengaruh == 1;
    }
}
