public class Pengguna{
    private String nama;
    private int usia;
    private String jenisKelamin;
    private int NIM;

    public String getNIM() {
        return String.valueOf(NIM);
    }
    public String getNama() {
        return nama;
    }
    public String getUsia() {
        return String.valueOf(usia);
    }
    public String getJenisKelamin() {
        return jenisKelamin;
    }
    public void setUsia(int usia) {
        this.usia = usia;
    }
    public void setJenisKelamin(String jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
    }
}