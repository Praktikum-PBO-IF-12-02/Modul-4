/**
 *
 * @author wahyuuuwid
 */

public class Main {
    public static void main(String[] args) {

        Hero hero1 = new Hero("Suyou", 100, 50, 10);
        Hero hero2 = new Hero("Fanny", 80, 60, 8);

        hero1.status();
        hero2.status();

        // Simulasi aksi
        hero1.attack(hero2);
        hero2.useSkill(hero1);
        hero1.heal();

        System.out.println("\nSetelah pertarungan:\n");

        hero1.status();
        hero2.status();
    }
}