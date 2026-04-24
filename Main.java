package jawaban1;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Perusahaan perusahaan = new Perusahaan();

        while (true) {
            System.out.println("\n=== SISTEM MANAJEMEN KARYAWAN ===");
            System.out.println("1. Tambah Karyawan");
            System.out.println("2. Hapus Karyawan");
            System.out.println("3. Ubah Posisi");
            System.out.println("4. Ubah Gaji");
            System.out.println("5. Tampilkan Semua Karyawan");
            System.out.println("6. Keluar");
            System.out.print("Masukkan pilihan: ");

            int pilihan = scanner.nextInt();
            scanner.nextLine();

            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan ID karyawan: ");
                    String id = scanner.nextLine();
                    System.out.print("Masukkan Nama karyawan: ");
                    String nama = scanner.nextLine();
                    System.out.print("Masukkan Posisi: ");
                    String posisi = scanner.nextLine();
                    System.out.print("Masukkan Gaji: ");
                    double gaji = scanner.nextDouble();
                    scanner.nextLine();

                    if (gaji < 0) {
                        System.out.println("Gaji tidak boleh negatif!");
                        break;
                    }

                    Karyawan karyawanBaru = new Karyawan(id, nama, posisi, gaji);
                    perusahaan.tambahKaryawan(karyawanBaru);
                    break;

                case 2:
                    System.out.print("Masukkan ID karyawan yang akan dihapus: ");
                    String idHapus = scanner.nextLine();
                    perusahaan.hapusKaryawan(idHapus);
                    break;

                case 3:
                    System.out.print("Masukkan ID karyawan: ");
                    String idPosisi = scanner.nextLine();
                    System.out.print("Masukkan posisi baru: ");
                    String posisiBaru = scanner.nextLine();
                    perusahaan.ubahPosisi(idPosisi, posisiBaru);
                    break;

                case 4:
                    // Ubah gaji
                    System.out.print("Masukkan ID karyawan: ");
                    String idGaji = scanner.nextLine();
                    System.out.print("Masukkan gaji baru: ");
                    double gajiBaru = scanner.nextDouble();
                    scanner.nextLine();
                    perusahaan.ubahGaji(idGaji, gajiBaru);
                    break;

                case 5:
                    System.out.println("\nDaftar Karyawan:");
                    perusahaan.DataKaryawan();
                    break;

                case 6:
                    System.out.println("Terima kasih telah menggunakan program ini.");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        }
    }
}