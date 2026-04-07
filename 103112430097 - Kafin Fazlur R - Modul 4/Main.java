class Hero {
    private String nama;
    private int hp;
    private int mana;
    private int damage;

    public Hero(String nama, int hp, int mana, int damage) {
        this.nama = nama;

        if (hp < 0) this.hp = 0;
        else if (hp > 100) this.hp = 100;
        else this.hp = hp;

        if (mana < 0) this.mana = 0;
        else if (mana > 100) this.mana = 100;
        else this.mana = mana;

        if (damage < 0) this.damage = 0;
        else if (damage > 15) this.damage = 15;
        else this.damage = damage;
    }

    public void attack(Hero musuh) {
        if (this.hp == 0) {
            System.out.println(this.nama + " sudah mati dan tidak bisa menyerang.");
            return;
        }

        musuh.hp -= this.damage;
        if (musuh.hp < 0) musuh.hp = 0;

        System.out.println(this.nama + " menyerang " + musuh.nama + " sebesar " + this.damage);
    }

    public void skill(Hero musuh) {
        if (this.hp == 0) {
            System.out.println(this.nama + " sudah mati dan tidak bisa menggunakan skill.");
            return;
        }

        if (this.mana < 25) {
            System.out.println(this.nama + " tidak punya cukup mana.");
            return;
        }

        int skillDamage = this.damage * 2;
        this.mana -= 25;

        musuh.hp -= skillDamage;
        if (musuh.hp < 0) musuh.hp = 0;

        System.out.println(this.nama + " menggunakan skill ke " + musuh.nama + " sebesar " + skillDamage);
    }

    public void regen() {
        if (this.hp == 0) {
            System.out.println(this.nama + " sudah mati dan tidak bisa regen.");
            return;
        }

        if (this.hp == 100) {
            System.out.println(this.nama + " HP sudah penuh.");
            return;
        }

        this.hp += 15;
        if (this.hp > 100) this.hp = 100;

        System.out.println(this.nama + " melakukan regen +15 HP");
    }

    public void status() {
        String kondisi = (hp == 0) ? "DEAD" : "ALIVE";
        System.out.println("Nama: " + nama);
        System.out.println("HP: " + hp);
        System.out.println("Mana: " + mana);
        System.out.println("Damage: " + damage);
        System.out.println("Status: " + kondisi);
        System.out.println("----------------------");
    }
}

public class Main {
    public static void main(String[] args) {
        Hero hero1 = new Hero("Lancelot", 100, 50, 12);
        Hero hero2 = new Hero("Kagura", 80, 60, 10);

        hero1.status();
        hero2.status();

        hero1.attack(hero2);
        hero2.skill(hero1);

        hero1.regen();
        hero2.regen();

        hero1.status();
        hero2.status();
    }
}