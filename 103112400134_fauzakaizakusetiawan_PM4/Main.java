public class Main {
    public static void main(String[] args) {
        Hero hero1 = new Hero("Layla", 100, 80, 12);
        Hero hero2 = new Hero("Miya", 90, 60, 10);

        System.out.println("=== Status Awal ===");
        hero1.tampilkanStatus();
        hero2.tampilkanStatus();

        System.out.println("\n=== Aksi ===");
        hero1.serang(hero2);
        hero2.gunakanSkill(hero1);
        hero1.heal();

        System.out.println("\n=== Status Akhir ===");
        hero1.tampilkanStatus();
        hero2.tampilkanStatus();

        System.out.println("\n=== Simulasi DEAD ===");
        Hero hero3 = new Hero("Tigreal", 20, 50, 8);
        Hero hero4 = new Hero("Franco", 100, 70, 15);
        hero4.serang(hero3);
        hero4.gunakanSkill(hero3);
        hero3.tampilkanStatus();
        hero3.serang(hero4);
        hero3.heal();
    }
}