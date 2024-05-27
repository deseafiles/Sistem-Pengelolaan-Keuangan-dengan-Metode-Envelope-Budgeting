package tubespbo.Dao;

import tubespbo.Models.Anggaran;
import java.util.ArrayList;
import java.util.List;

public class AnggaranDao {
    private List<Anggaran> totalAnggaran;

    public AnggaranDao() {
        this.totalAnggaran = new ArrayList<>();
    }

    public void tambahAnggaran(Anggaran anggaran) {
        totalAnggaran.add(anggaran);
    }

    public List<Anggaran> getTotalAnggaran() {
        return totalAnggaran;
    }

    public void logAnggaran() {
        for (Anggaran anggaran : totalAnggaran) {
            System.out.println("Halo " + anggaran.getPengguna().getNama());
            System.out.println("Total Anggaran Pengguna : " + anggaran.totalAnggaran());
            System.out.println("Total Anggaran Pokok : " + anggaran.getTotalAnggaranPokok());
            System.out.println("Total Anggaran Sekunder : " + anggaran.getTotalAnggaranSekunder());
            System.out.println("Total Anggaran Tersier : " + anggaran.getTotalAnggaranTersier());
        }
    }
}
