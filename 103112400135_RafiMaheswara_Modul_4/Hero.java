public class Hero {

    private final String nama;
    private int hp;
    private int mana;
    private int damage;

    public Hero(String nama, int hp, int mana, int damage) {
        this.nama   = nama;
        this.hp     = Math.min(Math.max(hp, 0), 100);
        this.mana   = Math.min(Math.max(mana, 0), 100);
        this.damage = Math.min(Math.max(damage, 0), 15);
    }

    public String getNama()  { return nama;   }
    public int getHp()       { return hp;     }
    public int getMana()     { return mana;   }
    public int getDamage()   { return damage; }

    public void serang(Hero musuh) {
        if (hp == 0) { System.out.println(nama + " sudah DEAD, tidak bisa menyerang!"); return; }
        musuh.hp = Math.max(musuh.hp - this.damage, 0);
        System.out.println(nama + " menyerang " + musuh.nama + "! Damage: " + damage + " | HP " + musuh.nama + ": " + musuh.hp);
    }

    public void gunakanSkill(Hero musuh) {
        if (hp == 0)      { System.out.println(nama + " sudah DEAD, tidak bisa pakai skill!"); return; }
        if (mana < 25)    { System.out.println(nama + " mana tidak cukup! (" + mana + "/25)"); return; }
        int skillDmg = damage * 2;
        mana -= 25;
        musuh.hp = Math.max(musuh.hp - skillDmg, 0);
        System.out.println(nama + " pakai SKILL ke " + musuh.nama + "! Damage: " + skillDmg + " | HP " + musuh.nama + ": " + musuh.hp + " | Mana tersisa: " + mana);
    }

    public void heal() {
        if (hp == 0)   { System.out.println(nama + " sudah DEAD, tidak bisa regen!"); return; }
        if (hp >= 100) { System.out.println(nama + " HP sudah penuh!"); return; }
        hp = Math.min(hp + 15, 100);
        System.out.println(nama + " REGEN! HP sekarang: " + hp);
    }

    public void tampilkanStatus() {
        System.out.println("| " + nama + " | HP: " + hp + " | Mana: " + mana + " | Damage: " + damage + " | " + (hp == 0 ? "DEAD" : "ALIVE") + " |");
    }
}