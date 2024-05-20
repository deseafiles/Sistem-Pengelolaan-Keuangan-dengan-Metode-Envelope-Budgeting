import java.util.List;

public class Kelompok {
    List<Pengguna> namaAnggota;

    public void addNama(String nama, int usia, String jenisKelamin, int NIM) {
        Pengguna newPengguna = new Pengguna(nama, usia, jenisKelamin, NIM);
        namaAnggota.add(newPengguna);
    }

    public List<Pengguna> getNamaAnggota() {
        return namaAnggota;
    }
}