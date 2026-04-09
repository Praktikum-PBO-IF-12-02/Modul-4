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

    public void serang(Hero musuh) {
        if (this.hp <= 0) {
            System.out.println(this.nama + " sudah mati, tidak bisa menyerang!");
            return;
        }

        System.out.println(this.nama + " menyerang " + musuh.nama + "!");
        musuh.terimaDamage(this.damage);
    }

    public void gunakanSkill(Hero musuh) {
        if (this.hp <= 0) return;

        if (this.mana >= 25) {
            this.mana -= 25;
            System.out.println(this.nama + " menggunakan skill pada " + musuh.getNama() + "!");
            musuh.terimaDamage(this.damage * 2);
        } else {
            System.out.println("Mana tidak cukup untuk menggunakan skill!");
        }
    }

    private void terimaDamage(int jumlahDamage) {
        this.hp -= jumlahDamage;
        if (this.hp < 0) {
            this.hp = 0;
        }
    }

    public void heal() {
        if (this.hp <= 0) {
            System.out.println(this.nama + " sudah mati, tidak bisa regen!");
            return;
        }

        if (this.hp < 100) {
            this.hp += 15;
            if (this.hp > 100) this.hp = 100;
            System.out.println(this.nama + " melakukan regen HP.");
        } else {
            System.out.println("HP " + this.nama + " sudah penuh!");
        }
    }

    public void tampilkanStatus() {
        String status = (this.hp > 0) ? "ALIVE" : "DEAD";
        System.out.println("--- " + this.nama + " (" + status + ") ---");
        System.out.println("HP     : " + this.hp);
        System.out.println("Mana   : " + this.mana);
        System.out.println("Damage : " + this.damage);
    }

    public String getNama() { return nama; }
    public int getHp() { return hp; }
    public int getMana() { return mana; }
}