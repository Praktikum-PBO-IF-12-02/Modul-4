public class Main {
    public static void main(String[] args) {
        Hero alucard = new Hero("Alucard", 95, 60, 12);
        Hero miya = new Hero("Miya", 80, 40, 10);
        Hero franco = new Hero("Franco", 120, -5, 20);

        System.out.println("=== STATUS AWAL ===");
        alucard.showStatus();
        miya.showStatus();
        franco.showStatus();

        System.out.println("=== SIMULASI BATTLE ===");
        alucard.attack(miya);
        miya.useSkill(alucard);
        franco.useSkill(miya);
        miya.regen();

        System.out.println("=== STATUS SETELAH AKSI ===");
        alucard.showStatus();
        miya.showStatus();
        franco.showStatus();

        System.out.println("=== UJI HERO DEAD TIDAK BISA MENYERANG ===");
        Hero zilong = new Hero("Zilong", 10, 100, 8);
        Hero layla = new Hero("Layla", 100, 100, 14);

        layla.useSkill(zilong);
        zilong.attack(layla);

        zilong.showStatus();
        layla.showStatus();
    }
}
