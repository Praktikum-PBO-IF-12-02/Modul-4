public class Hero {
    private String namaHero;
    private int hpHero;
    private int manaHero;
    private int power;

    public Hero(String namaHero, int hpHero, int manaHero, int power) {
        this.namaHero = namaHero;
        this.hpHero = Math.max(0, Math.min(100, hpHero));
        this.manaHero = Math.max(0, Math.min(100, manaHero));
        this.power = Math.max(0, Math.min(15, power));
    }

    public String getNama() {
        return namaHero;
    }

    public int getHp() {
        return hpHero;
    }

    public int getMana() {
        return manaHero;
    }

    public int getDamage() {
        return power;
    }

    public void serang(Hero target) {
        if (this.hpHero == 0) {
            System.out.println(this.namaHero + " sudah gugur dan tidak bisa menyerang!");
            return;
        }

        target.hpHero = Math.max(0, target.hpHero - this.power);
        System.out.println(this.namaHero + " menyerang " + target.namaHero + " dengan damage " + this.power + "!");
    }

    public void gunakanSkill(Hero target) {
        if (this.hpHero == 0) {
            System.out.println(this.namaHero + " sudah gugur dan tidak dapat menggunakan skill!");
            return;
        }

        if (this.manaHero < 25) {
            System.out.println(this.namaHero + " kehabisan mana untuk memakai skill!");
            return;
        }

        int skillDamage = this.power * 2;
        this.manaHero -= 25;
        target.hpHero = Math.max(0, target.hpHero - skillDamage);

        System.out.println(this.namaHero + " mengeluarkan skill ke " + target.namaHero + " dengan damage " + skillDamage + "!");
    }

    public void heal() {
        if (this.hpHero == 100) {
            System.out.println(this.namaHero + " HP sudah penuh, tidak perlu heal.");
            return;
        }

        this.hpHero = Math.min(100, this.hpHero + 15);
        System.out.println(this.namaHero + " melakukan heal. HP sekarang: " + this.hpHero);
    }

    public void tampilkanStatus() {
        String kondisi = (this.hpHero > 0) ? "ALIVE" : "DEAD";

        System.out.println("=== Status Hero: " + namaHero + " ===");
        System.out.println("HP     : " + hpHero);
        System.out.println("Mana   : " + manaHero);
        System.out.println("Power  : " + power);
        System.out.println("Status : " + kondisi);
    }
}