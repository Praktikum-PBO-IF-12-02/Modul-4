/**
 *
 * @author wahyuuuwid
 */

class Hero {
    private String nama;
    private int hp;
    private int mana;
    private int damage;

    // Constructor 
    public Hero(String nama, int hp, int mana, int damage) {
        this.nama = nama;

        // Validasi HP
        if (hp < 0) {
            this.hp = 0;
        } else if (hp > 100) {
            this.hp = 100;
        } else {
            this.hp = hp;
        }
        

        // Validasi Mana
        if (mana < 0) {
            this.mana = 0;
        } else if (mana > 100) {
            this.mana = 100;
        } else {
            this.mana = mana;
        }
       
        // Validasi Damage
        if (damage < 0) {
            this.damage = 0;
        } else if (damage > 15) {
            this.damage = 15;
        } else {
            this.damage = damage;
        }
       
    }

    // Getter
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

    // Method mengurangi HP
    private void takeDamage(int dmg) {
        hp -= dmg;
        if (hp < 0) {
            hp = 0;
        }
    }

    // Method untuk mengurangi mana
    private void useMana(int cost) {
        mana -= cost;
        if (mana < 0) {
            mana = 0;
        }
    }

    // Method Heal
    private void addHp(int value) {
        hp += value;
        if (hp > 100) {
            hp = 100;
        }
    }

    // ATTACK
    public void attack(Hero musuh) {
        if (this.hp == 0) {
            System.out.println(nama + " sudah DEAD!");
            return;
        }

        System.out.println(nama + " menyerang " + musuh.getNama());
        musuh.takeDamage(this.damage);
    }

    // SKILL
    public void useSkill(Hero musuh) {
        if (this.hp == 0) {
            System.out.println(nama + " sudah DEAD!");
            return;
        }

        if (this.mana < 25) {
            System.out.println(nama + " tidak cukup mana!");
            return;
        }

        System.out.println(nama + " menggunakan SKILL ke " + musuh.getNama());

        useMana(25);
        musuh.takeDamage(this.damage * 2);
    }

    // HEAL
    public void heal() {
        if (this.hp == 0) {
            System.out.println(nama + " sudah DEAD!");
            return;
        }

        if (this.hp == 100) {
            System.out.println(nama + " HP sudah penuh!");
            return;
        }

        System.out.println(nama + " melakukan HEAL");
        addHp(15);
    }

    // STATUS
    public void status() {
        String kondisi = (hp == 0) ? "DEAD" : "ALIVE";

        System.out.println("Nama   : " + nama);
        System.out.println("HP     : " + hp);
        System.out.println("Mana   : " + mana);
        System.out.println("Damage : " + damage);
        System.out.println("Status : " + kondisi);
        System.out.println("----------------------");
    }
}