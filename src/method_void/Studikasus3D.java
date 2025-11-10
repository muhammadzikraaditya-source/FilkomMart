package method_void;
import java.util.Scanner;

/* Muhammad Zikra Aditya
NIM: 255150407111001
*/
public class Studikasus3D {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        String[] daftarBarang = {"Beras", "Gula", "Minyak Goreng", "Sabun", "Telur"};
        double[] daftarHarga = {55000, 10000, 56000, 15000, 2500};
        
        System.out.print("jumlah barang yang dibeli :");
        int n = input.nextInt();
        String[] namaBarang = new String[n];
        int[] jumlahbarang = new int[n];
        double[] hargaBarang = new double[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Masukkan nama barang ke-" + (i + 1) + " (Beras/Gula/Minyak Goreng/Sabun/Telur): ");
            namaBarang[i] = input.next();
            System.out.print("Masukkan jumlah barang ke-" + (i + 1) + ": ");
            jumlahbarang[i] = input.nextInt();
            
            boolean barangDitemukan = false;
            for (int j = 0; j < daftarBarang.length; j++) {
                if (namaBarang[i].equalsIgnoreCase(daftarBarang[j])) {
                    hargaBarang[i] = daftarHarga[j];
                    barangDitemukan = true;
                    break;
                }
            }
            if (!barangDitemukan) {
                System.out.println("Barang tidak ditemukan dalam daftar!");
                hargaBarang[i] = 0;
            }
        }

        double totalKeseluruhan = 0;
        System.out.println("\nBarang yang dibeli:");
        for (int i = 0; i < n; i++) {
            double totalBarang = jumlahbarang[i] * hargaBarang[i];
            System.out.println("Barang: " + namaBarang[i]);
            System.out.println("Jumlah: " + jumlahbarang[i]);
            System.out.println("Harga satuan: Rp" + String.format("%,.0f", hargaBarang[i]));
            System.out.println("Total harga barang " + namaBarang[i] + ": Rp" + String.format("%,.0f", totalBarang));
            totalKeseluruhan += totalBarang;
        }
        
        System.out.println("\nTotal harga keseluruhan: Rp" + String.format("%,.0f", totalKeseluruhan));
    }
}