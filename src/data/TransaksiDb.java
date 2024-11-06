/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import entity.OrderEntity;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Nurfa
 */
public class TransaksiDb {

    private Conn c = new Conn();
    private Connection conn;

    public ArrayList<OrderEntity> getStruk(int id) throws SQLException {
        conn = c.getConnection();
        String query = "SELECT * FROM transaksi_detail WHERE id =? ";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        ArrayList<OrderEntity> detail = new ArrayList<>();
        while (rs.next()) {
            String merek = rs.getString("merek");
            String tipe = rs.getString("tipe");
            int berat = rs.getInt("berat");
            int banyak = rs.getInt("banyak");
            int harga = rs.getInt("total_harga");
            OrderEntity o = new OrderEntity(merek, tipe, berat, banyak, harga);
            detail.add(o);
        }

        rs.close();
        ps.close();
        conn.close();

        return detail;
    }

    public ArrayList<OrderEntity> getHistory(String username) throws SQLException {
        conn = c.getConnection();
        String query = "SELECT * FROM transaksi_master WHERE username = ? ORDER BY id DESC";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1, username);
        ResultSet rs = ps.executeQuery();
        ArrayList<OrderEntity> history = new ArrayList<>();
        while (rs.next()) {
            int id = rs.getInt("id");
            int harga = rs.getInt("total_harga");
            String waktu = rs.getString("waktu");
            OrderEntity o = new OrderEntity(id, waktu, harga);
            history.add(o);
        }

        rs.close();
        ps.close();
        conn.close();

        return history;
    }

    public boolean cekPayment(OrderEntity o) throws SQLException {
        conn = c.getConnection();
        String query = "INSERT INTO transaksi_detail(id, merek, tipe, berat, banyak, total_harga) VALUES(?,?,?,?,?,?)";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setInt(1, o.getId());
        ps.setString(2, o.getMerek());
        ps.setString(3, o.getTipe());
        ps.setInt(4, o.getBerat());
        ps.setInt(5, o.getBanyak());
        ps.setInt(6, o.getTotalHarga());
        int barisTerpengaruh = ps.executeUpdate();
        ps.close();
        conn.close();
        return barisTerpengaruh == 1;
    }

    public int getIdStruk(String username) throws SQLException {
        conn = c.getConnection();
        String query = "SELECT id FROM transaksi_master WHERE username = ? ORDER BY id DESC LIMIT 1";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1, username);
        ResultSet rs = ps.executeQuery();
        int id = 0;
        while (rs.next()) {
            id = rs.getInt("id");
        }

        return id;
    }

    public boolean getStruk(OrderEntity oE) throws SQLException {
        conn = c.getConnection();
        String query = "INSERT INTO transaksi_master(username, total_harga, waktu) VALUES(?,?,now())";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1, oE.getUsername());
        ps.setInt(2, oE.getTotalHarga());
        int barisTerpengaruh = ps.executeUpdate();
        ps.close();
        conn.close();
        return barisTerpengaruh == 1;
    }

}
