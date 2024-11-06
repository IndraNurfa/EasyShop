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
public class OrderEntity {

    String username, merek, tipe, waktu;
    int id, berat, banyak, totalHarga;

    public OrderEntity(String merek, String tipe, int berat, int banyak, int totalHarga) {
        this.merek = merek;
        this.tipe = tipe;
        this.berat = berat;
        this.banyak = banyak;
        this.totalHarga = totalHarga;
    }

    public OrderEntity(int id, String waktu, int totalHarga) {
        this.id = id;
        this.waktu = waktu;
        this.totalHarga = totalHarga;
    }

    public OrderEntity(int id, String merek, String tipe, int berat, int banyak, int totalHarga) {
        this.id = id;
        this.merek = merek;
        this.tipe = tipe;
        this.berat = berat;
        this.banyak = banyak;
        this.totalHarga = totalHarga;
    }

    public OrderEntity(String username, int totalHarga) {
        this.username = username;
        this.totalHarga = totalHarga;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMerek() {
        return merek;
    }

    public void setMerek(String merek) {
        this.merek = merek;
    }

    public String getTipe() {
        return tipe;
    }

    public void setTipe(String tipe) {
        this.tipe = tipe;
    }

    public int getBerat() {
        return berat;
    }

    public void setBerat(int berat) {
        this.berat = berat;
    }

    public int getBanyak() {
        return banyak;
    }

    public void setBanyak(int banyak) {
        this.banyak = banyak;
    }

    public int getTotalHarga() {
        return totalHarga;
    }

    public void setTotalHarga(int totalHarga) {
        this.totalHarga = totalHarga;
    }

    public String getWaktu() {
        return waktu;
    }

    public void setWaktu(String waktu) {
        this.waktu = waktu;
    }
}
