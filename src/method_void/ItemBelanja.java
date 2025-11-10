package method_void;

public class ItemBelanja {
    private final Barang barang;
    private final int jumlah;

    public ItemBelanja(Barang barang, int jumlah) {
        this.barang = barang;
        this.jumlah = jumlah;
    }

    public Barang getBarang() {
        return barang;
    }

    public int getJumlah() {
        return jumlah;
    }

    public double getSubtotal() {
        return barang.getHargaSatuan() * jumlah;
    }
}
