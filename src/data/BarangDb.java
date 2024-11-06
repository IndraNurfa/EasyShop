/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import entity.BarangEntity;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Nurfa
 */
public class BarangDb {

    private Conn c = new Conn();
    private Connection conn;

    public boolean deleteMakanan(String id) throws SQLException {
        conn = c.getConnection();
        String query = "DELETE FROM makanan WHERE id=?";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1, id);
        int barisTerpengaruh = ps.executeUpdate();
        ps.close();
        conn.close();
        return barisTerpengaruh == 1;
    }

    public boolean deleteMinuman(String id) throws SQLException {
        conn = c.getConnection();
        String query = "DELETE FROM minuman WHERE id=?";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1, id);
        int barisTerpengaruh = ps.executeUpdate();
        ps.close();
        conn.close();
        return barisTerpengaruh == 1;
    }

    public boolean updateMakanan(BarangEntity mknE) throws SQLException {
        conn = c.getConnection();
        String query = "UPDATE makanan SET merek=?, tipe=?, berat=?, harga=? WHERE id=?";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(5, mknE.getId());
        ps.setString(1, mknE.getMerek());
        ps.setString(2, mknE.getTipe());
        ps.setInt(3, mknE.getBerat());
        ps.setInt(4, mknE.getHarga());
        int barisTerpengaruh = ps.executeUpdate();
        ps.close();
        conn.close();
        return barisTerpengaruh == 1;
    }

    public boolean updateMinuman(BarangEntity mnmE) throws SQLException {
        conn = c.getConnection();
        String query = "UPDATE minuman SET merek=?, tipe=?, berat=?, harga=? WHERE id=?";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(5, mnmE.getId());
        ps.setString(1, mnmE.getMerek());
        ps.setString(2, mnmE.getTipe());
        ps.setInt(3, mnmE.getBerat());
        ps.setInt(4, mnmE.getHarga());
        int barisTerpengaruh = ps.executeUpdate();
        ps.close();
        conn.close();
        return barisTerpengaruh == 1;
    }

    public boolean insertMakanan(BarangEntity mknE) throws SQLException {
        conn = c.getConnection();
        String query = "INSERT INTO makanan(id, merek, tipe, berat, harga) VALUES(?,?,?,?,?)";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1, mknE.getId());
        ps.setString(2, mknE.getMerek());
        ps.setString(3, mknE.getTipe());
        ps.setInt(4, mknE.getBerat());
        ps.setInt(5, mknE.getHarga());
        int barisTerpengaruh = ps.executeUpdate();
        ps.close();
        conn.close();
        return barisTerpengaruh == 1;
    }

    public boolean insertMinuman(BarangEntity mnmE) throws SQLException {
        conn = c.getConnection();
        String query = "INSERT INTO minuman(id, merek, tipe, berat, harga) VALUES(?,?,?,?,?)";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1, mnmE.getId());
        ps.setString(2, mnmE.getMerek());
        ps.setString(3, mnmE.getTipe());
        ps.setInt(4, mnmE.getBerat());
        ps.setInt(5, mnmE.getHarga());
        int barisTerpengaruh = ps.executeUpdate();
        ps.close();
        conn.close();
        return barisTerpengaruh == 1;
    }

    public ArrayList<BarangEntity> getBarangMakanan(String keyword) throws SQLException {
        conn = c.getConnection();
        String query = "SELECT * FROM makanan WHERE id LIKE ? OR merek LIKE ? OR tipe LIKE ? OR berat LIKE ? OR harga LIKE ?";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1, "%" + keyword + "%");
        ps.setString(2, "%" + keyword + "%");
        ps.setString(3, "%" + keyword + "%");
        ps.setString(4, "%" + keyword + "%");
        ps.setString(5, "%" + keyword + "%");
        ResultSet rs = ps.executeQuery();
        ArrayList<BarangEntity> entityMakanan = new ArrayList<>();
        while (rs.next()) {
            String id = rs.getString("id");
            String merek = rs.getString("merek");
            String tipe = rs.getString("tipe");
            int berat = rs.getInt("berat");
            int harga = rs.getInt("harga");
            BarangEntity makEn = new BarangEntity(id, merek, tipe, berat, harga);
            entityMakanan.add(makEn);
        }
        rs.close();
        ps.close();
        conn.close();

        return entityMakanan;
    }

    public ArrayList<BarangEntity> getBarangMinuman(String keyword) throws SQLException {
        conn = c.getConnection();
        String query = "SELECT * FROM minuman WHERE id LIKE ? OR merek LIKE ? OR tipe LIKE ? OR berat LIKE ? OR harga LIKE ?";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1, "%" + keyword + "%");
        ps.setString(2, "%" + keyword + "%");
        ps.setString(3, "%" + keyword + "%");
        ps.setString(4, "%" + keyword + "%");
        ps.setString(5, "%" + keyword + "%");
        ResultSet rs = ps.executeQuery();
        ArrayList<BarangEntity> entityMinuman = new ArrayList<>();
        while (rs.next()) {
            String id = rs.getString("id");
            String merek = rs.getString("merek");
            String tipe = rs.getString("tipe");
            int berat = rs.getInt("berat");
            int harga = rs.getInt("harga");
            BarangEntity minEn = new BarangEntity(id, merek, tipe, berat, harga);
            entityMinuman.add(minEn);
        }
        rs.close();
        ps.close();
        conn.close();

        return entityMinuman;
    }

    public ArrayList<BarangEntity> getBarangMakanan() throws SQLException {
        conn = c.getConnection();
        String query = "SELECT * FROM makanan";
        PreparedStatement ps = conn.prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        ArrayList<BarangEntity> entityMakanan = new ArrayList<>();
        while (rs.next()) {
            String id = rs.getString("id");
            String merek = rs.getString("merek");
            String tipe = rs.getString("tipe");
            int berat = rs.getInt("berat");
            int harga = rs.getInt("harga");
            BarangEntity makEn = new BarangEntity(id, merek, tipe, berat, harga);
            entityMakanan.add(makEn);
        }
        rs.close();
        ps.close();
        conn.close();

        return entityMakanan;
    }

    public ArrayList<BarangEntity> getBarangMinuman() throws SQLException {
        conn = c.getConnection();
        String query = "SELECT * FROM minuman";
        PreparedStatement ps = conn.prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        ArrayList<BarangEntity> entityMinuman = new ArrayList<>();
        while (rs.next()) {
            String id = rs.getString("id");
            String merek = rs.getString("merek");
            String tipe = rs.getString("tipe");
            int berat = rs.getInt("berat");
            int harga = rs.getInt("harga");
            BarangEntity minEn = new BarangEntity(id, merek, tipe, berat, harga);
            entityMinuman.add(minEn);
        }
        rs.close();
        ps.close();
        conn.close();

        return entityMinuman;
    }

}
