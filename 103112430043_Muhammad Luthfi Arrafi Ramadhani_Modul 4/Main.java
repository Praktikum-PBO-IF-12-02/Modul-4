public class Main {
    public static void main(String[] args) {
        Hero claude = new Hero("Claude", 100, 60, 12);  
        Hero granger = new Hero("Granger", 90, 70, 15); 

        System.out.println("==== Status Awal ====");
        claude.tampilkanStatus();
        granger.tampilkanStatus();

        System.out.println("==== Terjadi battle! ====");
        System.out.println("Claude menyerang Granger");
        claude.menyerang(granger);

        System.out.println("Granger menggunakan SKILL ke Claude");
        granger.menggunakanSkill(claude);

        System.out.println("Claude melakukan HEAL");
        claude.regen();

        System.out.println("==== Status Setelah Pertarungan ====");
        claude.tampilkanStatus();
        granger.tampilkanStatus();
    }
}