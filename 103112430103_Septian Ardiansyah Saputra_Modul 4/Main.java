public class Main {
    public static void main(String[] args) {

        Hero hero1 = new Hero("Zetian", 75, 80, 10);
        Hero hero2 = new Hero("Zhuxin", 60, 60, 8);

        hero1.status();
        hero2.status();

        hero1.attack(hero2);
        hero2.status();

        hero2.skill(hero1);
        hero1.status();

        hero1.heal();
        hero1.status();

        hero1.skill(hero2);
        hero1.skill(hero2);
        hero1.skill(hero2);

        hero2.status();

        hero2.attack(hero1);
    }
}