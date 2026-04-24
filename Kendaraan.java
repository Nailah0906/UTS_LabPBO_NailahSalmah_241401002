package jawaban2;

class Kendaraan {
    private String jenis;
    private int durasiParkir; // dalam jam
    private double totalBiaya;

    private static final int TarifMotor = 2000;
    private static final int TarifMobil = 5000;
    private static final int TarifTruk = 10000;

    public Kendaraan(String jenis) {
        this.jenis = jenis;
        this.durasiParkir = 0;
        this.totalBiaya = 0;
    }

    public void hitungBiaya(int durasiManual) {
        this.durasiParkir = durasiManual;
        Diskon();
    }

    public void hitungBiaya(int jamMasuk, int jamKeluar) {
        this.durasiParkir = jamKeluar - jamMasuk;
        if (this.durasiParkir < 0) {
            this.durasiParkir += 24;
        }
        Diskon();
    }

    private void Diskon() {
        int tarifPerJam = getTarifPerJam();
        double biayaKotor = durasiParkir * tarifPerJam;

        if (durasiParkir > 5) {
            totalBiaya = biayaKotor * 0.9;
        } else {
            totalBiaya = biayaKotor;
        }
    }

    private int getTarifPerJam() {
        switch (jenis.toLowerCase()) {
            case "motor":
                return TarifMotor;
            case "mobil":
                return TarifMobil;
            case "truk":
                return TarifTruk;
            default:
                return 0;
        }
    }

    public void tampilkanR() {
        System.out.println("\n--- PARKING SUMMARY ---");
        System.out.println("Vehicle Type    : " + (jenis));
        System.out.println("Parking Time    : " + durasiParkir + " hour(s)");
        System.out.printf("Total Fee    : Rp%.1f\n", totalBiaya);
        if (durasiParkir > 5) {
            System.out.println("(Diskon 10% applied for parking > 5 hours)");
        }
    }

    public String getJenis() {
        return jenis;
    }

    public double getTotalBiaya() {
        return totalBiaya;
    }

}