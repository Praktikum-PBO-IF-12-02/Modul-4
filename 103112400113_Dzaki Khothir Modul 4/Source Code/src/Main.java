public class Main {
    public static void main(String[] args) throws Exception {
        Hero hero1 = new Hero("King Nasir", 100, 50, 12);
        Hero hero2 = new Hero("Mas Amba ", 80, 40, 10);

        hero1.showStatus();
        hero2.showStatus();

        hero1.menyerang(hero2);
        hero2.skill(hero1);

        hero1.regen();

        hero1.showStatus();
        hero2.showStatus();
    }
}
