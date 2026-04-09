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

    private int clamp(int nilai, int min, int max) {
        if (nilai < min) return min;
        if (nilai > max) return max;
        return nilai;
    }

    public void attack(Hero target) {
        if (isAlive()) {
            System.out.println("[ATTACK] " + nama + " -> " + target.nama + " (" + damage + " DMG)");
            target.receiveDamage(this.damage);
        } else {
            System.out.println("[FAILED] " + nama + " tidak bisa menyerang karena DEAD.");
        }
    }

    public void skill(Hero target) {
        if (!isAlive()) {
            System.out.println("[FAILED] " + nama + " sudah DEAD.");
            return;
        }
        if (this.mana >= 25) {
            int sDmg = this.damage * 2;
            this.mana -= 25;
            System.out.println("[SKILL] " + nama + " -> " + target.nama + " (" + sDmg + " DMG | -25 MP)");
            target.receiveDamage(sDmg);
        } else {
            System.out.println("[FAILED] Mana " + nama + " tipis!");
        }
    }

    public void heal() {
        if (isAlive()) {
            if (this.hp < 100) {
                this.hp = clamp(this.hp + 15, 0, 100);
                System.out.println("[HEAL] " + nama + " memulihkan HP (+15)");
            } else {
                System.out.println("[FAILED] HP " + nama + " sudah penuh.");
            }
        }
    }

    private void receiveDamage(int amt) {
        this.hp = clamp(this.hp - amt, 0, 100);
    }

    private boolean isAlive() {
        return this.hp > 0;
    }

    public void status() {
        String ket = isAlive() ? "ALIVE" : "DEAD";
        System.out.printf("| %-12s | HP: %-3d | MP: %-3d | [%s] |%n", nama, hp, mana, ket);
    }
}