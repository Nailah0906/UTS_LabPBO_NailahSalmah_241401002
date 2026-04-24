package jawaban3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LotreGosok game = new LotreGosok();

        System.out.println("Welcome to Lottery Gosok Nailah~");
        System.out.println("=" .repeat(30));
        System.out.println("Aturan permainan:");
        System.out.println("- Papan berukuran 4 baris x 5 kolom");
        System.out.println("- Terdapat 2 bom dan 18 kotak aman");
        System.out.println("- Masukkan tebakan baris dan kolom (0-3 untuk baris, 0-4 untuk kolom)");
        System.out.println("- Buka semua 18 kotak aman untuk menang!");
        System.out.println("=" .repeat(30));
        System.out.println();

        game.TampilkanPapan();
        System.out.println();

        while (!game.isGameOver()) {
            System.out.print("Masukkan tebakanmu (baris dan kolom) : ");

            int row, col;
            try {
                row = scanner.nextInt();
                col = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("Input tidak valid! Masukkan dua angka (baris dan kolom)");
                scanner.nextLine();
                continue;
            }

            System.out.println();

            boolean isSafe = game.guess(row, col);

            game.TampilkanPapan();
            System.out.println();

            if (game.isGameOver()) {
                break;
            }
        }

        if (game.getSafeCellsOpened() == 18) {
            System.out.println("Selamat! Kamu berhasil membuka semua 18 kotak aman!");
            System.out.println("Kamu adalah pemenangnya!!!");
        } else {
            System.out.println("Game Over! Kamu kena bom!");
            System.out.println("Kamu berhasil membuka " + game.getSafeCellsOpened() + " kotak aman.");
        }

        System.out.println("\nTerima kasih telah bermain Lottery Gosok Nailah :D!!");

        scanner.close();
    }
}