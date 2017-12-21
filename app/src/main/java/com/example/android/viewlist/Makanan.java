package com.example.android.viewlist;

/**
 * Created by User on 11/1/2017.
 */

public class Makanan {
    private int ImageId;
        private String nama;
        private double harga;

    public Makanan(int imageId, String nama, double harga) {
        ImageId = imageId;
        this.nama = nama;
        this.harga = harga;
    }

    public int getImageId() {
        return ImageId;
    }

    public String getNama() {
        return nama;
    }

    public double getHarga() {
        return harga;
    }
}
