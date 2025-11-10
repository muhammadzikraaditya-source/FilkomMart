package method_void;

public class Barang {
    private final String nama;
    private final double hargaSatuan;

    public Barang(String nama, double hargaSatuan) {
        this.nama = nama;
        this.hargaSatuan = hargaSatuan;
    }

    public String getNama() {
        return nama;
    }

    public double getHargaSatuan() {
        return hargaSatuan;
    }
}
