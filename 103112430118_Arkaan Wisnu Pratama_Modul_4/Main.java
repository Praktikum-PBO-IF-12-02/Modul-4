package Modul4;

public class Main {

    public static void main(String[] args) {

        System.out.println(">>> Inisialisasi Hero <<<");
        Hero layla   = new Hero("Layla",   100, 80, 12);
        Hero tigreal = new Hero("Tigreal", 100, 50,  8);

        layla.displayStatus();
        tigreal.displayStatus();

        System.out.println("\n>>> Layla menyerang Tigreal <<<");
        layla.attack(tigreal);

        System.out.println("\n>>> Layla menggunakan skill ke Tigreal <<<");
        layla.useSkill(tigreal);

        System.out.println("\n>>> Tigreal heal <<<");
        tigreal.heal();
        tigreal.displayStatus();

        System.out.println("\n>>> Simulasi hero mati <<<");
        Hero minion = new Hero("Minion", 1, 0, 5);
        minion.displayStatus();

        layla.attack(minion);       // Minion mati (hp jadi 0)
        minion.displayStatus();     // Status: DEAD

        minion.attack(layla);       // Ditolak, sudah mati
        minion.useSkill(layla);     // Ditolak, sudah mati
        minion.heal();              // Ditolak, sudah mati

        System.out.println("\n>>> Tigreal coba skill tapi mana kurang <<<");
        Hero weakMana = new Hero("Eudora", 100, 20, 10);
        weakMana.useSkill(tigreal); // Mana hanya 20, butuh 25 → ditolak

        System.out.println("\n>>> Layla HP penuh coba heal <<<");
        layla.heal();               // HP masih 100 → ditolak
    }
}