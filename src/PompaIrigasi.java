public class PompaIrigasi extends PerangkatPertanian implements Operasional {

    private static final int AMBANG_KELEMBAPAN_PERSEN = 40;

    public PompaIrigasi(String kodeAlat, String lokasi) {
        super(kodeAlat, lokasi, 0);
    }

    public PompaIrigasi(String kodeAlat, String lokasi, int levelOperasi) {
        super(kodeAlat, lokasi, levelOperasi);
    }

    @Override
    public void prosesSensor(int nilaiSensor) {
        if (nilaiSensor < AMBANG_KELEMBAPAN_PERSEN) {
            this.nyalakan();
            if (nilaiSensor < 20) {
                this.setLevelOperasi(100);
            } else {
                this.setLevelOperasi(50);
            }
        } else {
            this.matikan();
        }
    }

    @Override
    public void nyalakan() {
        this.setStatusAktif(true);
    }

    @Override
    public void matikan() {
        this.setStatusAktif(false);
        this.setLevelOperasi(0);
    }

    @Override
    public boolean isAktif() {
        return this.isStatusAktif();
    }

    @Override
    public void info() {
        super.info();
        System.out.println("   Tipe: Pompa Irigasi");
    }
}
