package Modul4;

public class Hero {

    private final String nama;
    private int hp;
    private int mana;
    private int damage;

    public Hero(String nama, int hp, int mana, int damage) {
        this.nama   = nama;
        this.hp     = Math.max(0, Math.min(100, hp));
        this.mana   = Math.max(0, Math.min(100, mana));
        this.damage = Math.max(0, Math.min(15,  damage));
    }

    public String getNama()   { return nama; }
    public int    getHp()     { return hp; }
    public int    getMana()   { return mana; }
    public int    getDamage() { return damage; }

    public void attack(Hero target) {
        if (this.hp == 0) {
            System.out.println(this.nama + " sudah mati dan tidak bisa menyerang!");
            return;
        }
        int dmg = this.damage;
        target.hp = Math.max(0, target.hp - dmg);
        System.out.println(this.nama + " menyerang " + target.nama
                + " sebesar " + dmg + " damage. HP " + target.nama
                + " sekarang: " + target.hp);
    }

    public void useSkill(Hero target) {
        if (this.hp == 0) {
            System.out.println(this.nama + " sudah mati dan tidak bisa menggunakan skill!");
            return;
        }
        if (this.mana < 25) {
            System.out.println(this.nama + " mana tidak cukup! Mana saat ini: " + this.mana);
            return;
        }
        this.mana -= 25;
        int dmg = this.damage * 2;
        target.hp = Math.max(0, target.hp - dmg);
        System.out.println(this.nama + " menggunakan SKILL ke " + target.nama
                + " sebesar " + dmg + " damage (2x). HP " + target.nama
                + " sekarang: " + target.hp
                + " | Sisa mana " + this.nama + ": " + this.mana);
    }

    public void heal() {
        if (this.hp == 0) {
            System.out.println(this.nama + " sudah mati, tidak bisa melakukan heal!");
            return;
        }
        if (this.hp >= 100) {
            System.out.println(this.nama + " HP sudah maksimum, tidak perlu heal!");
            return;
        }
        int before = this.hp;
        this.hp = Math.min(100, this.hp + 15);
        System.out.println(this.nama + " melakukan heal: " + before
                + " -> " + this.hp + " HP");
    }

    public void displayStatus() {
        String status = (this.hp > 0) ? "ALIVE" : "DEAD";
        System.out.println("=================================");
        System.out.println("Nama   : " + nama);
        System.out.println("HP     : " + hp   + " / 100");
        System.out.println("Mana   : " + mana + " / 100");
        System.out.println("Damage : " + damage);
        System.out.println("Status : [" + status + "]");
        System.out.println("=================================");
    }
}