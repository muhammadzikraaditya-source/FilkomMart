package method_void;

import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

public class studiKasus5A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.US);

        KeranjangBelanja cart = new KeranjangBelanja();

        System.out.println("Daftar barang tersedia (nama -> harga):");
        for (Map.Entry<String, Double> e : DataBarang.semua().entrySet()) {
            System.out.printf("- %s -> Rp%.0f%n", e.getKey(), e.getValue());
        }
        System.out.println();

        System.out.print("Jumlah jenis barang yang dibeli: ");
        int jenis = readInt(sc);

        for (int i = 1; i <= jenis; i++) {
            System.out.print("Nama barang ke-" + i + ": ");
            String nama = sc.nextLine().trim();
            if (nama.isEmpty()) { i--; continue; }

            Double harga = DataBarang.getHarga(nama);
            if (harga == null) {
                System.out.print("Harga satuan (Rp) untuk '" + nama + "': ");
                harga = readDouble(sc);
            }

            System.out.print("Jumlah satuan '" + nama + "': ");
            int qty = readInt(sc);

            Barang b = new Barang(capitalize(nama), harga);
            cart.tambahItem(new ItemBelanja(b, qty));
        }

        cart.cetakStruk();
    }

    private static int readInt(Scanner sc) {
        while (!sc.hasNextInt()) { sc.next(); }
        int v = sc.nextInt();
        sc.nextLine();
        return v;
    }

    private static double readDouble(Scanner sc) {
        while (!sc.hasNextDouble()) { sc.next(); }
        double v = sc.nextDouble();
        sc.nextLine();
        return v;
    }

    private static String capitalize(String s) {
        if (s == null || s.isEmpty()) return s;
        return s.substring(0,1).toUpperCase() + s.substring(1);
    }
}
