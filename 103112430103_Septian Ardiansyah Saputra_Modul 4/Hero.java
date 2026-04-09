public class Hero {
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
            System.out.println(this.nama + " sudah DEAD dan tidak bisa menyerang!");
            return;
        }

        System.out.println(this.nama + " menyerang " + musuh.nama);

        musuh.hp -= this.damage;

        if (musuh.hp < 0) {
            musuh.hp = 0;
        }
    }

    public void skill(Hero musuh) {
        if (this.hp == 0) {
            System.out.println(this.nama + " sudah DEAD dan tidak bisa menggunakan skill!");
            return;
        }

        if (this.mana < 25) {
            System.out.println(this.nama + " mana tidak cukup!");
            return;
        }

        System.out.println(this.nama + " menggunakan SKILL ke " + musuh.nama);

        this.mana -= 25;
        int skillDamage = this.damage * 2;

        musuh.hp -= skillDamage;

        if (musuh.hp < 0) {
            musuh.hp = 0;
        }
    }

    public void heal() {
        if (this.hp == 0) {
            System.out.println(this.nama + " sudah DEAD dan tidak bisa heal!");
            return;
        }

        if (this.hp == 100) {
            System.out.println(this.nama + " HP sudah penuh!");
            return;
        }

        System.out.println(this.nama + " melakukan HEAL");

        this.hp += 15;

        if (this.hp > 100) {
            this.hp = 100;
        }
    }

    public void status() {
        String kondisi = (hp == 0) ? "DEAD" : "ALIVE";

        System.out.println("===== STATUS HERO =====");
        System.out.println("Nama   : " + nama);
        System.out.println("HP     : " + hp);
        System.out.println("Mana   : " + mana);
        System.out.println("Damage : " + damage);
        System.out.println("Status : " + kondisi);
        System.out.println("========================\n");
    }
}