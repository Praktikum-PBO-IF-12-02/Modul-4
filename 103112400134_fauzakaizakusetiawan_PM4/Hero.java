public class Hero {
    private final String nama;
    private int hp;
    private int mana;
    private int damage;

    public Hero(String nama, int hp, int mana, int damage) {
        this.nama = nama;
        this.hp = Math.min(Math.max(hp, 0), 100);
        this.mana = Math.min(Math.max(mana, 0), 100);
        this.damage = Math.min(Math.max(damage, 0), 15);
    }

    public void serang(Hero target) {
        if (this.hp == 0) {
            System.out.println(this.nama + " sudah DEAD, tidak bisa menyerang!");
        } else {
            target.hp = Math.max(target.hp - this.damage, 0);
            System.out.println(this.nama + " menyerang " + target.nama + "! Damage: " + this.damage + " | HP " + target.nama + ": " + target.hp);
        }
    }

    public void gunakanSkill(Hero target) {
        if (this.hp == 0) {
            System.out.println(this.nama + " sudah DEAD, tidak bisa pakai skill!");
        } else if (this.mana < 25) {
            System.out.println(this.nama + " mana tidak cukup! (" + this.mana + "/25)");
        } else {
            int skillDamage = this.damage * 2;
            this.mana -= 25;
            target.hp = Math.max(target.hp - skillDamage, 0);
            System.out.println(this.nama + " pakai SKILL ke " + target.nama + "! Damage: " + skillDamage + " | HP " + target.nama + ": " + target.hp + " | Mana tersisa: " + this.mana);
        }
    }

    public void heal() {
        if (this.hp == 0) {
            System.out.println(this.nama + " sudah DEAD, tidak bisa regen!");
        } else if (this.hp >= 100) {
            System.out.println(this.nama + " HP sudah penuh!");
        } else {
            this.hp = Math.min(this.hp + 15, 100);
            System.out.println(this.nama + " REGEN! HP sekarang: " + this.hp);
        }
    }

    public void tampilkanStatus() {
        System.out.println("| " + this.nama + " | HP: " + this.hp + " | Mana: " + this.mana + " | Damage: " + this.damage + " | " + (this.hp == 0 ? "DEAD" : "ALIVE"));
    }
}