public class Main {

    public static void main(String[] args) {

        // ===================== INISIALISASI HERO =====================
        Hero layla   = new Hero("Layla",   100, 80, 12);
        Hero tigreal = new Hero("Tigreal", 100, 60,  9);

        System.out.println("========== STATUS AWAL ==========");
        layla.displayStatus();
        tigreal.displayStatus();

        // ===================== RONDE 1: SERANGAN BIASA =====================
        System.out.println("\n========== RONDE 1: SERANGAN BIASA ==========");
        layla.attack(tigreal);   // Tigreal HP: 100 -> 88
        tigreal.attack(layla);   // Layla   HP: 100 -> 91

        // ===================== RONDE 2: PENGGUNAAN SKILL =====================
        System.out.println("\n========== RONDE 2: PENGGUNAAN SKILL ==========");
        layla.useSkill(tigreal); // damage 24, Tigreal HP: 88 -> 64, mana Layla: 80 -> 55
        tigreal.useSkill(layla); // damage 18, Layla   HP: 91 -> 73, mana Tigreal: 60 -> 35

        // ===================== RONDE 3: REGEN =====================
        System.out.println("\n========== RONDE 3: HEAL / REGEN ==========");
        layla.heal();            // Layla   HP: 73 -> 88
        tigreal.heal();          // Tigreal HP: 64 -> 79

        // ===================== UJI BATAS: HP tidak boleh negatif =====================
        System.out.println("\n========== UJI BATAS: HP TIDAK BOLEH NEGATIF ==========");
        // Terus serang Layla sampai habis
        tigreal.attack(layla);
        tigreal.attack(layla);
        tigreal.attack(layla);
        tigreal.attack(layla);
        tigreal.attack(layla);
        tigreal.attack(layla);
        tigreal.attack(layla);
        tigreal.attack(layla);
        tigreal.attack(layla);
        tigreal.attack(layla);

        // ===================== UJI: Hero DEAD tidak bisa menyerang =====================
        System.out.println("\n========== UJI: HERO DEAD TIDAK BISA MENYERANG ==========");
        layla.attack(tigreal);    // Layla sudah DEAD
        layla.useSkill(tigreal);  // Layla sudah DEAD
        layla.heal();             // Layla sudah DEAD

        // ===================== UJI: HP tidak bisa melebihi 100 =====================
        System.out.println("\n========== UJI: HP TIDAK BISA MELEBIHI 100 ==========");
        tigreal.heal(); // HP sudah 79 -> 94
        tigreal.heal(); // HP 94 -> 100 (tidak lebih dari 100)
        tigreal.heal(); // HP sudah maksimum

        // ===================== UJI: Mana tidak cukup =====================
        System.out.println("\n========== UJI: MANA TIDAK CUKUP ==========");
        Hero bruno = new Hero("Bruno", 100, 10, 8); // mana hanya 10
        bruno.useSkill(tigreal); // gagal, mana < 25

        // ===================== UJI: Validasi nilai awal melebihi batas =====================
        System.out.println("\n========== UJI: VALIDASI NILAI AWAL ==========");
        Hero invalid = new Hero("Argus", 999, -50, 100); // nilai tidak valid
        invalid.displayStatus(); // hp=100, mana=0, damage=15 (otomatis dibatasi)

        // ===================== STATUS AKHIR =====================
        System.out.println("\n========== STATUS AKHIR ==========");
        layla.displayStatus();
        tigreal.displayStatus();
        bruno.displayStatus();
    }
}
