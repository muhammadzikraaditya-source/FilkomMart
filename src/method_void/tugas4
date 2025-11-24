import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class tugas4 {
	static class Buku {
		private final String isbn;
		private final String judul;

		public Buku(String isbn, String judul) {
			this.isbn = isbn;
			this.judul = judul;
		}

		public String getIsbn() { return isbn; }
		public String getJudul() { return judul; }
	}

	static class Mahasiswa {
		private final String nim;
		private final String nama;
		private final List<Buku> daftarPinjaman = new ArrayList<>();

		public Mahasiswa(String nim, String nama) {
			this.nim = nim;
			this.nama = nama;
		}

		public void pinjam(Buku b) {
			daftarPinjaman.add(b);
		}

		public String getNim() { return nim; }
		public String getNama() { return nama; }
		public List<Buku> getDaftarPinjaman() { return daftarPinjaman; }
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("======================================================");
		System.out.print("Nim     : ");
		String nim = sc.nextLine().trim();
		System.out.println();
		System.out.print("Nama    : ");
		String nama = sc.nextLine().trim();

		Mahasiswa mhs = new Mahasiswa(nim, nama);

		System.out.println();
		System.out.println("Masukkan data buku yang akan dipinjam.");
		System.out.println("Jika selesai, masukkan jumlah 0 atau tekan Enter saat diminta jumlah.");
		System.out.print("Berapa banyak buku yang dipinjam? ");
		String jumlahStr = sc.nextLine().trim();
		int jumlah = 0;
		try {
			if (!jumlahStr.isEmpty()) jumlah = Integer.parseInt(jumlahStr);
		} catch (NumberFormatException e) {
			jumlah = 0;
		}

		for (int i = 1; i <= jumlah; i++) {
			System.out.println();
			System.out.print("ISBN buku ke-" + i + " : ");
			String isbn = sc.nextLine().trim();
			System.out.print("Judul buku ke-" + i + " : ");
			String judul = sc.nextLine().trim();
			Buku b = new Buku(isbn, judul);
			mhs.pinjam(b);
		}

		if (jumlah == 0) {
			int idx = 1;
			while (true) {
				System.out.println();
				System.out.print("ISBN buku ke-" + idx + " (kosong untuk selesai): ");
				String isbn = sc.nextLine().trim();
				if (isbn.isEmpty()) break;
				System.out.print("Judul buku ke-" + idx + " : ");
				String judul = sc.nextLine().trim();
				mhs.pinjam(new Buku(isbn, judul));
				idx++;
			}
		}

		System.out.println();
		System.out.println("======================================================");
		System.out.println();
		System.out.printf("Nim     : %s\n", mhs.getNim());
		System.out.println();
		System.out.printf("Nama    : %s\n", mhs.getNama());
		System.out.println();
		System.out.println("----------------------------------------------------------------------------------------");
		System.out.printf("| %-3s | %-36s | %-86s |%n", "No", "Isbn", "Judul");
		System.out.println("----------------------------------------------------------------------------------------");

		List<Buku> daftar = mhs.getDaftarPinjaman();
		int idx = 1;
		if (daftar.isEmpty()) {
			System.out.printf("| %-3s | %-36s | %-86s |%n", "-", "-", "(tidak ada buku yang dipinjam)");
		} else {
			for (Buku bk : daftar) {
				String isbn = bk.getIsbn();
				String judul = bk.getJudul();
				String judulDisp = judul;
				if (judulDisp.length() > 86) judulDisp = judulDisp.substring(0, 83) + "...";
				if (isbn.length() > 36) isbn = isbn.substring(0, 33) + "...";
				System.out.printf("| %-3d | %-36s | %-86s |%n", idx, isbn, judulDisp);
				idx++;
			}
		}
		System.out.println("----------------------------------------------------------------------------------------");

		sc.close();
		System.out.println();
		System.out.println("Selesai. Terima kasih.");

	}
}
