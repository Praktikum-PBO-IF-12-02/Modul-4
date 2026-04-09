public class Main {
    public static void main(String[] args) {
        Hero hero1 = new Hero("Layla", 100, 100, 10);
        Hero hero2 = new Hero("Grok", 150, 10, 8);

        hero1.tampilkanStatus();
        hero2.tampilkanStatus();

        System.out.println();
        hero1.serang(hero2);
        hero1.gunakanSkill(hero2);
        hero2.tampilkanStatus();

        System.out.println();
        hero2.heal();
        hero2.tampilkanStatus();
    }
}