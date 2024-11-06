/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author Nurfa
 */
public class DataUserEntity {

    private static String username, nama, email;

    public static String getUsername() {
        return username;
    }

    public static void setUsername(String username) {
        DataUserEntity.username = username;
    }

    public static String getNama() {
        return nama;
    }

    public static void setNama(String nama) {
        DataUserEntity.nama = nama;
    }

    public static String getEmail() {
        return email;
    }

    public static void setEmail(String email) {
        DataUserEntity.email = email;
    }

}
