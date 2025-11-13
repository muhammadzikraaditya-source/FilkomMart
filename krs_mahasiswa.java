package oopkrs;

import java.util.Scanner;

class MataKuliah {
    String kode;
    String nama;
    int sks;
}

class Mahasiswa {
    String nim;
    String nama;
    MataKuliah[] daftarMK = new MataKuliah[10];
    int jumlahMK = 0;
    int totalSKS = 0;
    
    boolean tambahMataKuliah(String kode, String namaMK, int sks) {
        if (totalSKS + sks > 24) {
            System.out.println("\nGAGAL! Total SKS tidak boleh melebihi 24.");
            System.out.println("Total SKS saat ini: " + totalSKS + " SKS");
            return false;
        }

        MataKuliah mk = new MataKuliah();
        mk.kode = kode;
        mk.nama = namaMK;
        mk.sks = sks;

        daftarMK[jumlahMK] = mk;
        jumlahMK++;
        totalSKS = totalSKS + sks;

        System.out.println("Mata kuliah berhasil ditambahkan!");
        System.out.println("Total SKS sekarang: " + totalSKS + " SKS\n");
        return true;
    }
    
    void cetakKRS() {
        System.out.println("\n\n========================================");
        System.out.println("      KARTU RENCANA STUDI (KRS)");
        System.out.println("        SEMESTER GENAP 2024/2025");
        System.out.println("========================================");
        System.out.println();
        System.out.println("NIM         : " + nim);
        System.out.println("Nama        : " + nama);
        System.out.println("Total SKS   : " + totalSKS + " SKS");
        System.out.println();
        System.out.println("----------------------------------------");
        System.out.println("Kode MK      Nama Mata Kuliah       SKS");
        System.out.println("----------------------------------------");
        
        for (int i = 0; i < jumlahMK; i++) {
            System.out.printf("%-13s%-24s%3d\n",
                daftarMK[i].kode,
                daftarMK[i].nama,
                daftarMK[i].sks);
        }
        
        System.out.println("----------------------------------------");
        System.out.println("========================================");
    }
}

public class krs_mahasiswa {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.println("========================================");
        System.out.println("   SISTEM PENGISIAN KRS MAHASISWA");
        System.out.println("========================================");
        System.out.println();
        
        System.out.print("Masukkan NIM   : ");
        String nim = input.nextLine();
        
        System.out.print("Masukkan Nama  : ");
        String nama = input.nextLine();
        
        Mahasiswa mhs = new Mahasiswa();
        mhs.nim = nim;
        mhs.nama = nama;
        
        System.out.println("\n--- Pengisian Mata Kuliah (Max 24 SKS) ---\n");
        
        String lanjut = "y";
        while (lanjut.equals("y") && mhs.totalSKS < 24) {
            System.out.println("Total SKS: " + mhs.totalSKS + " / 24 SKS");
            System.out.println("Sisa SKS : " + (24 - mhs.totalSKS) + " SKS\n");
            
            System.out.print("Kode MK : ");
            String kode = input.nextLine();
            
            System.out.print("Nama MK : ");
            String namaMK = input.nextLine();
            
            System.out.print("SKS     : ");
            int sks = Integer.parseInt(input.nextLine());
            
            mhs.tambahMataKuliah(kode, namaMK, sks);
            
            if (mhs.totalSKS >= 24) {
                System.out.println("\nTotal SKS sudah mencapai batas maksimal!");
                break;
            }
            
            System.out.print("Tambah mata kuliah lagi? (y/n): ");
            lanjut = input.nextLine();
            System.out.println();
        }
        
        mhs.cetakKRS();
        
        input.close();
    }
}
