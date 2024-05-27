package tubespbo.Models;

public class Pengguna {
    private String nama;
    private int nim;
    private String jenisKelamin;

    public Pengguna(int nim, String nama, String jenisKelamin) {
        this.nama = nama;
        this.nim = nim;
        this.jenisKelamin = jenisKelamin;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getNim() {
        return nim;
    }

    public String getJenisKelamin() {
        return jenisKelamin;
    }

    public void setNim(int nim) {
        this.nim = nim;
    }

    public void setJenisKelamin(String jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
    }
}