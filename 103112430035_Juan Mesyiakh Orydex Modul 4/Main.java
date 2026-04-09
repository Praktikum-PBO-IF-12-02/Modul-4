public class Main {
    public static void main(String[] args) {
        Hero h1 = new Hero("Kazuha", 95, 100, 14);
        Hero h2 = new Hero("Scaramouche", 80, 40, 15);

        System.out.println("----------------------------------------------");
        System.out.println("            SIMULASI BATTLE ARENA             ");
        System.out.println("----------------------------------------------");
        h1.status();
        h2.status();
        System.out.println("----------------------------------------------");

        h1.attack(h2);
        h2.skill(h1);
        h1.heal();
        
        System.out.println("----------------------------------------------");
        h1.status();
        h2.status();
        System.out.println("----------------------------------------------");

        h1.skill(h2);
        h1.skill(h2);
        h1.skill(h2);

        System.out.println("----------------------------------------------");
        h2.status();
        h2.attack(h1);
        System.out.println("----------------------------------------------");
    }
}