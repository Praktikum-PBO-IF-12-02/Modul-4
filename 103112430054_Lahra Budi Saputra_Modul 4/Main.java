public class Main {
    public static void main(String[] args) {
        Hero miya = new Hero("Miya", 150, 50, 30); 
        Hero tigreal = new Hero("Tigreal", 100, 100, 5);

        System.out.println("=== STATUS AWAL ===");
        miya.tampilkanStatus();
        tigreal.tampilkanStatus();

        System.out.println("\n=== PERTANDINGAN ===");
        miya.serang(tigreal);
        tigreal.gunakanSkill(miya);
        miya.heal();

        System.out.println("\n=== MIYA SPAM SKILL ===");
        miya.gunakanSkill(tigreal); 
        miya.gunakanSkill(tigreal); 
        
        miya.gunakanSkill(tigreal); 
        
        miya.serang(tigreal);
        miya.serang(tigreal);

        System.out.println("\n=== STATUS AKHIR ===");
        tigreal.tampilkanStatus();
        
        tigreal.serang(miya);
    }
}