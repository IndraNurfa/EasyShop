/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import entity.DataUserEntity;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Nurfa
 */
public class UserDataDb {

    private Conn c = new Conn();
    private Connection conn;    

    public boolean getDataUser(String username) throws SQLException {
        conn = c.getConnection();
        String query = "SELECT * FROM data_user WHERE username=?";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1, username);
        ResultSet rs = ps.executeQuery();
        String nama= null, email= null;
        while (rs.next()) {
            nama = rs.getString("nama");
            email = rs.getString("email");
            DataUserEntity.setUsername(username);
            DataUserEntity.setNama(nama);
            DataUserEntity.setEmail(email); 
        }
        rs.close();
        ps.close();
        conn.close();
        return true;
    }
}
