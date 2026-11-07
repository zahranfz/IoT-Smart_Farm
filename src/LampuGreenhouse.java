public class LampuGreenhouse extends PerangkatPertanian implements Operasional, Pelapor {

    private static final int AMBANG_CAHAYA_LUX = 250;

    public LampuGreenhouse(String kodeAlat, String lokasi) {
        super(kodeAlat, lokasi, 0);
    }

    public LampuGreenhouse(String kodeAlat, String lokasi, int levelOperasi) {
        super(kodeAlat, lokasi, levelOperasi);
    }

    @Override
    public void prosesSensor(int nilaiSensor) {
        if (nilaiSensor < AMBANG_CAHAYA_LUX) {
            this.nyalakan();
            this.setLevelOperasi(80);
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
    public String laporkanStatus() {
        return "Lampu Greenhouse " + getLokasi() + " -> aktif=" + isStatusAktif()
                + ", level=" + getLevelOperasi() + "%";
    }

    @Override
    public void info() {
        super.info();
        System.out.println("   Tipe: Lampu Greenhouse");
    }
}
