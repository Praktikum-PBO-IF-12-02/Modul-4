public class Hero {
    private String nama;
    private int hp;
    private int mana;
    private int damage;

    public Hero(String nama, int hp, int mana, int damage) {
        this.nama = nama;
        this.hp = Math.max(0, Math.min(100, hp));
        this.mana = Math.max(0, Math.min(100, mana));
        this.damage = Math.max(0, Math.min(15, damage));
    }

    public String getNama() {
        return nama;
    }

    public int getHp() {
        return hp;
    }

    public int getMana() {
        return mana;
    }

    public int getDamage() {
        return damage;
    }

    public void serang(Hero musuh) {
        if (this.hp == 0) {
            System.out.println(this.nama + " sudah mati dan tidak bisa menyerang!");
            return;
        }
        musuh.hp = Math.max(0, musuh.hp - this.damage);
        System.out.println(this.nama + " menyerang " + musuh.nama + " sebesar " + this.damage + " damage!");
    }

    public void gunakanSkill(Hero musuh) {
        if (this.hp == 0) {
            System.out.println(this.nama + " sudah mati dan tidak bisa menggunakan skill!");
            return;
        }
        if (this.mana < 25) {
            System.out.println(this.nama + " tidak cukup mana untuk menggunakan skill!");
            return;
        }
        int skillDamage = this.damage * 2;
        this.mana -= 25;
        musuh.hp = Math.max(0, musuh.hp - skillDamage);
        System.out.println(this.nama + " menggunakan skill ke " + musuh.nama + " sebesar " + skillDamage + " damage!");
    }

    public void heal() {
        if (this.hp == 100) {
            System.out.println(this.nama + " sudah HP maksimum, tidak bisa regen!");
            return;
        }
        this.hp = Math.min(100, this.hp + 15);
        System.out.println(this.nama + " melakukan heal! HP sekarang: " + this.hp);
    }

    public void tampilkanStatus() {
        String status = (this.hp > 0) ? "ALIVE" : "DEAD";
        System.out.println("=== Status " + nama + " ===");
        System.out.println("HP     : " + hp);
        System.out.println("Mana   : " + mana);
        System.out.println("Damage : " + damage);
        System.out.println("Status : " + status);
    }
}
