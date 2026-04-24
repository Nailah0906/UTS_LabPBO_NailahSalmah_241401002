package jawaban1;
import java.util.ArrayList;
import java.util.List;

public class Perusahaan {
    private List<Karyawan> daftarKaryawan;

    public Perusahaan() {
        daftarKaryawan = new ArrayList<>();
    }

    public boolean tambahKaryawan(Karyawan karyawan) {
        for (Karyawan k : daftarKaryawan) {
            if (k.getId().equals(karyawan.getId())) {
                System.out.println("Gagal: ID " + karyawan.getId() + " sudah ada!");
                return false;
            }
        }
        daftarKaryawan.add(karyawan);
        System.out.println("Karyawan berhasil ditambahkan.");
        return true;
    }

    public boolean hapusKaryawan(String id) {
        for (int i = 0; i < daftarKaryawan.size(); i++) {
            if (daftarKaryawan.get(i).getId().equals(id)) {
                daftarKaryawan.remove(i);
                System.out.println("Karyawan dengan ID " + id + " berhasil dihapus.");
                return true;
            }
        }
        System.out.println("Karyawan dengan ID tersebut tidak ditemukan.");
        return false;
    }

    public boolean ubahPosisi(String id, String posisiBaru) {
        Karyawan k = KaryawanId(id);
        if (k != null) {
            k.setPosisi(posisiBaru);
            System.out.println("Posisi berhasil diubah.");
            return true;
        }
        System.out.println("Karyawan dengan ID tersebut tidak ditemuka.");
        return false;
    }

    public boolean ubahGaji(String id, double gajiBaru) {
        if (gajiBaru < 0) {
            System.out.println("Gagal: Gaji tidak boleh negatif!");
            return false;
        }
        Karyawan k = KaryawanId(id);
        if (k != null) {
            k.setGaji(gajiBaru);
            System.out.println("Gaji berhasil diubah.");
            return true;
        }
        System.out.println("Karyawan dengan ID tersebut tidak ditemukan.");
        return false;
    }

    public void DataKaryawan() {
        if (daftarKaryawan.isEmpty()) {
            System.out.println("Belum ada data karyawan.");
            return;
        }
        for (Karyawan k : daftarKaryawan) {
            k.tampilkanInfo();
        }
    }

    private Karyawan KaryawanId(String id) {
        for (Karyawan k : daftarKaryawan) {
            if (k.getId().equals(id)) {
                return k;
            }
        }
        return null;
    }
}