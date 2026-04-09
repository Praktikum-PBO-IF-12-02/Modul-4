public class Hero {
    private final String nama;
    private int hp;
    private int mana;
    private int damage;

    public Hero(String nama, int hp, int mana, int damage) {
        this.nama = nama;
        this.hp = Math.max(0, Math.min(100, hp));          // Memaksa nilai di range 0-100
        this.mana = Math.max(0, Math.min(100, mana));      // Memaksa nilai di range 0-100
        this.damage = Math.max(0, Math.min(15, damage));   // Memaksa nilai di range 0-15
    }

    public void serang(Hero musuh) {
        if (this.hp <= 0) {
            System.out.println(this.nama + " sudah kalah (DEAD) dan tidak bisa menyerang!");
            return;
        }
        if (musuh.hp <= 0) {
            System.out.println(musuh.nama + " sudah kalah, tidak perlu diserang lagi.");
            return;
        }

        System.out.println(this.nama + " menyerang " + musuh.nama + " dengan " + this.damage + " damage!");
        musuh.hp -= this.damage;
        if (musuh.hp < 0) musuh.hp = 0; 
    }

    public void gunakanSkill(Hero musuh) {
        if (this.hp <= 0) {
            System.out.println(this.nama + " sudah kalah (DEAD) dan tidak bisa menggunakan skill!");
            return;
        }
        if (this.mana < 25) {
            System.out.println("Mana " + this.nama + " tidak cukup untuk menggunakan skill!");
            return;
        }

        System.out.println(this.nama + " mengeluarkan SKILL kepada " + musuh.nama + "!");
        this.mana -= 25; 
        
        int skillDamage = this.damage * 2;
        musuh.hp -= skillDamage;
        if (musuh.hp < 0) musuh.hp = 0;
    }

    public void heal() {
        if (this.hp <= 0) {
            System.out.println(this.nama + " sudah kalah (DEAD) dan tidak bisa melakukan heal!");
            return;
        }
        if (this.hp >= 100) {
            System.out.println("HP " + this.nama + " sudah maksimum, tidak bisa melakukan regen.");
            return;
        }

        System.out.println(this.nama + " melakukan heal (+15 HP).");
        this.hp += 15;
        if (this.hp > 100) this.hp = 100; 
    }

    public void tampilkanStatus() {
        String status = (this.hp > 0) ? "ALIVE" : "DEAD";
        System.out.println("--- Status: " + this.nama + " ---");
        System.out.println("Status : " + status + " | HP: " + this.hp + "/100 | Mana: " + this.mana + "/100 | Damage: " + this.damage);
    }
}