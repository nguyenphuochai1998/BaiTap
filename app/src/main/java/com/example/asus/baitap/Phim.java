package com.example.asus.baitap;

public class Phim {
    private String Ten;
    private String Mota;
    private String NhanVat;
    private int Hinh;
    private String Video;

    public Phim(String ten, String mota, String nhanVat, int hinh, String video) {
        Ten = ten;
        Mota = mota;
        NhanVat = nhanVat;
        Hinh = hinh;
        Video = video;
    }

    public String getTen() {
        return Ten;
    }

    public void setTen(String ten) {
        Ten = ten;
    }

    public String getMota() {
        return Mota;
    }

    public void setMota(String mota) {
        Mota = mota;
    }

    public String getNhanVat() {
        return NhanVat;
    }

    public void setNhanVat(String nhanVat) {
        NhanVat = nhanVat;
    }

    public int getHinh() {
        return Hinh;
    }

    public void setHinh(int hinh) {
        Hinh = hinh;
    }

    public String getVideo() {
        return Video;
    }

    public void setVideo(String video) {
        Video = video;
    }
}
