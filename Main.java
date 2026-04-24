package jawaban2;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Kendaraan> daftarKendaraan = new ArrayList<>();
        String tambahLagi;

        System.out.println("======== Welcome to ParkingChan ========\n");

        do {
            System.out.print("Enter vehicle type (Motor/Mobil/Truk) : ");
            String jenis = scanner.nextLine();

            while (!jenis.equalsIgnoreCase("Motor") &&
                    !jenis.equalsIgnoreCase("Mobil") &&
                    !jenis.equalsIgnoreCase("Truk")) {
                System.out.print("Invalid type! Enter vehicle type (Motor/Mobil/Truk) : ");
                jenis = scanner.nextLine();
            }

            Kendaraan kendaraan = new Kendaraan(jenis);
            System.out.print("Enter Duration (Manual/Time): ");
            String metode = scanner.nextLine();

            if (metode.equalsIgnoreCase("Manual")) {
                System.out.print("Enter Duration (in hour): ");
                int durasi = scanner.nextInt();
                scanner.nextLine();
                kendaraan.hitungBiaya(durasi);

            } else if (metode.equalsIgnoreCase("Time")) {
                System.out.print("Enter entry time   : ");
                int jamMasuk = scanner.nextInt();
                System.out.print("Enter exit time    : ");
                int jamKeluar = scanner.nextInt();
                scanner.nextLine();
                kendaraan.hitungBiaya(jamMasuk, jamKeluar);

            } else {
                System.out.println("Invalid method! Using Manual mode as default.");
                System.out.print("Enter Duration (in hour): ");
                int durasi = scanner.nextInt();
                scanner.nextLine();
                kendaraan.hitungBiaya(durasi);
            }

            kendaraan.tampilkanR();

            daftarKendaraan.add(kendaraan);

            System.out.print("\nAdd another vehicle? (y/n): ");
            tambahLagi = scanner.nextLine();
            System.out.println();

        } while (tambahLagi.equalsIgnoreCase("y"));

        RingkasanAkhir(daftarKendaraan);
        scanner.close();
    }

    private static void RingkasanAkhir(ArrayList<Kendaraan> daftarKendaraan) {
        System.out.println("======== FINAL REPORT ========");
        System.out.println("Total Vehicle Final    : " + daftarKendaraan.size());

        double totalSemuaBiaya = 0;
        for (Kendaraan k : daftarKendaraan) {
            totalSemuaBiaya += k.getTotalBiaya();
        }

        System.out.printf("Total Parking Fees Final    : Rp%.1f\n", totalSemuaBiaya);
        System.out.println("Thank You......");
    }
}