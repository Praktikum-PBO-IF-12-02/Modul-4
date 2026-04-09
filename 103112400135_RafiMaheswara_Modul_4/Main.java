public class Main {
    public static void main(String[] args) {

        Hero layla = new Hero("Layla", 100, 80, 12);
        Hero miya  = new Hero("Miya", 90, 60, 10);

        System.out.println("=== Status Awal ===");
        layla.tampilkanStatus();
        miya.tampilkanStatus();

        System.out.println("\n=== Aksi ===");
        layla.serang(miya);
        miya.gunakanSkill(layla);
        layla.heal();

        System.out.println("\n=== Status Akhir ===");
        layla.tampilkanStatus();
        miya.tampilkanStatus();

        System.out.println("\n=== Simulasi DEAD ===");
        Hero tigreal = new Hero("Tigreal", 20, 50, 8);
        Hero franco  = new Hero("Franco", 100, 70, 15);
        franco.serang(tigreal);
        franco.gunakanSkill(tigreal);
        tigreal.tampilkanStatus();
        tigreal.serang(franco);   // hero DEAD mencoba menyerang
        tigreal.heal();           // hero DEAD mencoba regen
    }
}