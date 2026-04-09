class Hero {
    private String nama;
    private int hp;
    private int mana;
    private int damage;

    // Constructor + validasi
    public Hero(String nama, int hp, int mana, int damage) {
        this.nama = nama;

        this.hp = Math.max(0, Math.min(100, hp));
        this.mana = Math.max(0, Math.min(100, mana));
        this.damage = Math.max(0, Math.min(15, damage));
    }

    // Attack
    public void attack(Hero musuh) {
        if (this.hp == 0) {
            System.out.println(this.nama + " sudah mati dan tidak bisa menyerang!");
            return;
        }

        if (musuh.hp == 0) {
            System.out.println(musuh.nama + " sudah mati!");
            return;
        }

        musuh.hp -= this.damage;
        if (musuh.hp < 0) musuh.hp = 0;

        System.out.println(this.nama + " menyerang " + musuh.nama + " (-" + this.damage + " HP)");
    }

    // Skill (dengan mana cost)
    public void skill(Hero musuh) {
        if (this.hp == 0) {
            System.out.println(this.nama + " sudah mati dan tidak bisa menggunakan skill!");
            return;
        }

        System.out.println(this.nama + " mencoba menggunakan SKILL (Cost: 25 Mana)");

        if (this.mana < 25) {
            System.out.println("GAGAL! Mana tidak cukup. Mana sekarang: " + this.mana);
            return;
        }

        this.mana -= 25;
        int skillDamage = this.damage * 2;

        musuh.hp -= skillDamage;
        if (musuh.hp < 0) musuh.hp = 0;

        System.out.println("BERHASIL! " + this.nama + " menggunakan SKILL ke " + musuh.nama);
        System.out.println("Damage: " + skillDamage + " | Sisa Mana: " + this.mana);
    }

    // Heal
    public void heal() {
        if (this.hp == 0) {
            System.out.println(this.nama + " sudah mati dan tidak bisa heal!");
            return;
        }

        if (this.hp == 100) {
            System.out.println(this.nama + " HP sudah penuh!");
            return;
        }

        this.hp += 15;
        if (this.hp > 100) this.hp = 100;

        System.out.println(this.nama + " melakukan heal +15 HP");
    }

    // Status
    public void status() {
        String kondisi = (hp == 0) ? "DEAD" : "ALIVE";

        System.out.println("Hero: " + nama);
        System.out.println("HP: " + hp);
        System.out.println("Mana: " + mana);
        System.out.println("Damage: " + damage);
        System.out.println("Status: " + kondisi);
        System.out.println("-----------------------");
    }
}


// MAIN (DEMO)
public class Main {
    public static void main(String[] args) {

        // Stat kecil biar cepat kelihatan efeknya
        Hero hero1 = new Hero("Layla", 40, 30, 10);
        Hero hero2 = new Hero("Zilong", 35, 20, 8);

        System.out.println("=== STATUS AWAL ===");
        hero1.status();
        hero2.status();

        System.out.println("=== BATTLE MULAI ===");

        hero1.attack(hero2);
        hero2.status();

        hero2.skill(hero1); // cukup mana
        hero2.status();

        hero2.skill(hero1); // mana habis (gagal)

        hero1.heal();
        hero1.status();

        // Spam attack sampai mati
        hero1.attack(hero2);
        hero1.attack(hero2);
        hero1.attack(hero2);

        hero2.status();

        // Hero mati coba menyerang
        hero2.attack(hero1);

        System.out.println("=== STATUS AKHIR ===");
        hero1.status();
        hero2.status();
    }
}