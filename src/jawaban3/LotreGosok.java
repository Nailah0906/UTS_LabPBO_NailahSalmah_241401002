package jawaban3;

import java.util.Random;

public class LotreGosok {

    private char[][] board;
    private boolean[][] revealed;
    private int[][] data;
    private Random random;
    private int safeCellsOpened;
    private boolean bombFound;

    public LotreGosok() {
        board = new char[4][5];
        revealed = new boolean[4][5];
        data = new int[4][5];
        random = new Random();
        safeCellsOpened = 0;
        bombFound = false;
        generatePapan();
        AturTampilanPapan();
    }

    public void generatePapan() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 5; j++) {
                data[i][j] = 0;
            }
        }

        int Bom = 0;
        while (Bom < 2) {
            int row = random.nextInt(4);
            int col = random.nextInt(5);
            if (data[row][col] == 0) {
                data[row][col] = 1; // 1 = bom
                Bom++;
            }
        }
    }

    private void AturTampilanPapan() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 5; j++) {
                board[i][j] = '*';
            }
        }
    }

    public void TampilkanPapan() {
        for (int i = 0; i < 4; i++) {
            System.out.print(i + "   ");
            for (int j = 0; j < 5; j++) {
                if (revealed[i][j]) {
                    if (data[i][j] == 0) {
                        System.out.print("0   ");
                    } else {
                        System.out.print("X   ");
                    }
                } else {
                    System.out.print(board[i][j] + "   ");
                }
            }
            System.out.println();
        }
        System.out.println("    0   1   2   3   4");
    }

    public boolean guess(int row, int col) {
        if (row < 0 || row >= 4 || col < 0 || col >= 5) {
            System.out.println("Input tidak valid! Baris harus 0-3 dan kolom harus 0-4");
            return true;
        }

        if (revealed[row][col]) {
            System.out.println("Kotak telah dibuka sebelumnya!");
            return true;
        }

        revealed[row][col] = true;

        if (data[row][col] == 1) {
            bombFound = true;
            board[row][col] = 'X';
            System.out.println("BOM! Permainan berakhir!");
            return false;
        } else {
            safeCellsOpened++;
            board[row][col] = '0';
            System.out.println("Kotak Aman");
            return true;
        }
    }

    public boolean isGameOver() {
        if (bombFound) {
            return true;
        }

        if (safeCellsOpened == 18) {
            System.out.println("Selamat anda menang");
            return true;
        }

        return false;
    }

    public void TampilkanLotre() {
        System.out.println("Papan lengkap:");
        for (int i = 0; i < 4; i++) {
            System.out.print(i + "   ");
            for (int j = 0; j < 5; j++) {
                if (data[i][j] == 0) {
                    System.out.print("0   ");
                } else {
                    System.out.print("1   ");
                }
            }
            System.out.println();
        }
        System.out.println("    0   1   2   3   4");
    }

    public int getSafeCellsOpened() {
        return safeCellsOpened;
    }
}
