public abstract class PerangkatPertanian {

    public static final int KAPASITAS_MAKSIMAL = 100;

    private final String kodeAlat;
    private String lokasi;
    private boolean statusAktif;
    private int levelOperasi;

    public PerangkatPertanian(String kodeAlat, String lokasi) {
        this(kodeAlat, lokasi, 0);
    }

    public PerangkatPertanian(String kodeAlat, String lokasi, int levelOperasi) {
        this.kodeAlat = kodeAlat;
        this.lokasi = lokasi;
        this.statusAktif = false;
        this.levelOperasi = levelOperasi;
    }

    public String getKodeAlat() {
        return this.kodeAlat;
    }

    public String getLokasi() {
        return this.lokasi;
    }

    public void setLokasi(String lokasi) {
        this.lokasi = lokasi;
    }

    public boolean isStatusAktif() {
        return this.statusAktif;
    }

    public void setStatusAktif(boolean statusAktif) {
        this.statusAktif = statusAktif;
    }

    public int getLevelOperasi() {
        return this.levelOperasi;
    }

    public void setLevelOperasi(int levelOperasi) {
        if (levelOperasi > KAPASITAS_MAKSIMAL) {
            this.levelOperasi = KAPASITAS_MAKSIMAL;
        } else {
            this.levelOperasi = levelOperasi;
        }
    }

    public void info() {
        System.out.println("[" + kodeAlat + "] " + lokasi
                + " | Aktif: " + statusAktif
                + " | Level: " + levelOperasi + "%");
    }

    public double hitungKebutuhanAirHarian(int luasAreaM2) {
        return luasAreaM2 * (levelOperasi / 100.0) * 2.5;
    }

    public abstract void prosesSensor(int nilaiSensor);
}
