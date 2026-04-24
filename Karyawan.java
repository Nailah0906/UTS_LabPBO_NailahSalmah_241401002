package jawaban1;

public class Karyawan {
    private String id;
    private String nama;
    private String posisi;
    private double gaji;

    public Karyawan(String id, String nama, String posisi, double gaji) {
        this.id = id;
        this.nama = nama;
        this.posisi = posisi;
        this.gaji = gaji;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getPosisi() {
        return posisi;
    }

    public void setPosisi(String posisi) {
        this.posisi = posisi;
    }

    public double getGaji() {
        return gaji;
    }

    public void setGaji(double gaji) {
        this.gaji = gaji;
    }

    public void tampilkanInfo() {
        System.out.printf("ID: %s, Nama: %s, Posisi: %s, Gaji: Rp%.1f%n",
                id, nama, posisi, gaji);
    }
}
