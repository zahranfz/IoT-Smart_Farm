public class Main {

    public static void main(String[] args) {

        PompaIrigasi pompa = new PompaIrigasi("PMP-01", "Petak A");
        PompaIrigasi pompaCustom = new PompaIrigasi("PMP-02", "Petak B", 30);
        LampuGreenhouse lampu = new LampuGreenhouse("LGH-01", "Greenhouse 1");

        pompa.setLokasi("Petak A - Blok Timur");

        System.out.println("");
        System.out.println("========== SMART FARM IOT ==========");
        System.out.println("KAPASITAS_MAKSIMAL = " + PerangkatPertanian.KAPASITAS_MAKSIMAL);
        System.out.println("kodeAlat (final) = " + pompa.getKodeAlat());

        pompa.info();
        lampu.info();

        pompa.prosesSensor(15);
        pompa.info();

        System.out.println("Kebutuhan air Petak A/hari: " + pompa.hitungKebutuhanAirHarian(20) + " L");

        lampu.prosesSensor(100);
        lampu.info();

        Operasional alatOperasional = pompaCustom;
        alatOperasional.nyalakan();
        System.out.println("Pompa Petak B aktif: " + alatOperasional.isAktif());

        Pelapor pelapor = lampu;
        System.out.println(pelapor.laporkanStatus());

        System.out.println("");
        System.out.println("========== SMART FARM IOT ==========");
    }
}
