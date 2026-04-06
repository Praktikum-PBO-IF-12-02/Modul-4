public class Hero {
    private String nama;
    private int hp;
    private int mana;
    private int damage;

    public Hero(String nama, int hp, int mana, int damage) {
        this.nama = nama;
        this.hp = clamp(hp, 0, 100);
        this.mana = clamp(mana, 0, 100);
        this.damage = clamp(damage, 0, 15);
    }

    private int clamp(int value, int min, int max) {
        if (value < min) {
            return min;
        }
        if (value > max) {
            return max;
        }
        return value;
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

    public boolean isAlive() {
        return hp > 0;
    }

    public void attack(Hero target) {
        if (!isAlive()) {
            System.out.println(nama + " sudah DEAD dan tidak bisa menyerang.");
            return;
        }

        if (target == null) {
            System.out.println("Target tidak valid.");
            return;
        }

        int oldHp = target.hp;
        target.hp = Math.max(0, target.hp - damage);

        System.out.println(nama + " menyerang " + target.nama
                + " sebesar " + damage + " damage."
                + " (HP " + target.nama + ": " + oldHp + " -> " + target.hp + ")");
    }

    public void useSkill(Hero target) {
        if (!isAlive()) {
            System.out.println(nama + " sudah DEAD dan tidak bisa menggunakan skill.");
            return;
        }

        if (target == null) {
            System.out.println("Target tidak valid.");
            return;
        }

        final int manaCost = 25;
        if (mana < manaCost) {
            System.out.println(nama + " tidak punya mana cukup untuk skill.");
            return;
        }

        int skillDamage = damage * 2;
        mana -= manaCost;

        int oldHp = target.hp;
        target.hp = Math.max(0, target.hp - skillDamage);

        System.out.println(nama + " menggunakan skill ke " + target.nama
                + " sebesar " + skillDamage + " damage"
                + " (mana -" + manaCost + ")."
                + " (HP " + target.nama + ": " + oldHp + " -> " + target.hp + ")");
    }

    public void regen() {
        if (!isAlive()) {
            System.out.println(nama + " sudah DEAD dan tidak bisa regen.");
            return;
        }

        if (hp >= 100) {
            System.out.println(nama + " memiliki HP maksimum dan tidak bisa regen.");
            return;
        }

        int oldHp = hp;
        hp = Math.min(100, hp + 15);
        System.out.println(nama + " melakukan regen +15 HP. (" + oldHp + " -> " + hp + ")");
    }

    public void showStatus() {
        String status = isAlive() ? "ALIVE" : "DEAD";
        System.out.println("Hero: " + nama);
        System.out.println("HP: " + hp + "/100");
        System.out.println("Mana: " + mana + "/100");
        System.out.println("Damage: " + damage);
        System.out.println("Status: " + status);
        System.out.println("--------------------------");
    }
}
