package method_void;

import java.util.ArrayList;
import java.util.List;

public class KeranjangBelanja {
    private final List<ItemBelanja> items = new ArrayList<>();

    public void tambahItem(ItemBelanja item) {
        items.add(item);
    }

    public List<ItemBelanja> getItems() {
        return items;
    }

    public double getTotal() {
        double sum = 0.0;
        for (ItemBelanja it : items) {
            sum += it.getSubtotal();
        }
        return sum;
    }

    public void cetakStruk() {
        System.out.println();
        System.out.println("===================================================================");
        System.out.println("              STRUK FILKOMMART                 ");
        System.out.println("-------------------------------------------------------------------");
        System.out.printf("%-22s %12s %6s %15s%n", "Nama Barang", "Harga", "Qty", "Subtotal");
        System.out.println("-------------------------------------------------------------------");

        if (items.isEmpty()) {
            System.out.println("(Keranjang masih kosong)");
        } else {
            for (ItemBelanja it : items) {
                String nama = it.getBarang().getNama();
                if (nama.length() > 22)
                    nama = nama.substring(0, 22);
                double harga = it.getBarang().getHargaSatuan();
                int qty = it.getJumlah();
                double sub = it.getSubtotal();

                System.out.printf("%-22.22s Rp%,10.0f %6d Rp%,13.0f%n", nama, harga, qty, sub);
            }
        }

        System.out.println("-------------------------------------------------------------------");
        System.out.printf("%-22s %12s %6s Rp%,13.0f%n", "Total Belanja", "", "", getTotal());
        System.out.println("===================================================================\n");
    }
}
