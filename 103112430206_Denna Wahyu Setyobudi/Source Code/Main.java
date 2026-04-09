public class Main {
    public static void main(String[] args) {
        Hero layla = new Hero("Layla", 90, 60, 15);
        Hero zilong = new Hero("Zilong", 100, 50, 12);

        layla.tampilkanStatus();
        zilong.tampilkanStatus();

        System.out.println("\n--- Pertarungan Dimulai ---");
        layla.serang(zilong);
        zilong.gunakanSkill(layla);
        layla.heal();

        System.out.println("\n--- Status Akhir ---");
        layla.tampilkanStatus();
        zilong.tampilkanStatus();
    }
}