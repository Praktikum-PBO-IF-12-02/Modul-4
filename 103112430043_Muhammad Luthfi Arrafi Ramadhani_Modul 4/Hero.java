public class Hero {
    private String nama;
    private int hp;
    private int mana;
    private int damage;

    public Hero(String nama, int hp, int mana, int damage) {
        this.nama = nama;
        if (hp < 0) {
            this.hp = 0; 
        } else if (hp > 100) {
            this.hp = 100;  
        } else {
            this.hp = hp;
        }

        if (mana < 0) {
            this.mana = 0;  
        } else if (mana > 100) {
            this.mana = 100;  
        } else {
            this.mana = mana;
        }

        if (damage < 0) {
            this.damage = 0;  
        } else if (damage > 15) {
            this.damage = 15;  
        } else {
            this.damage = damage;
        }
    }

    public void menyerang(Hero musuh) {
        if (this.hp > 0) { 
            musuh.terimaSerangan(this.damage);
        }
    }

    private void terimaSerangan(int damage) {
        if (this.hp - damage < 0) {
            this.hp = 0; 
        } else {
            this.hp = this.hp - damage;
        }
    }

    public void menggunakanSkill(Hero musuh) {
        if (this.hp > 0 && this.mana >= 25) { 
            this.mana -= 25; 
            musuh.terimaSerangan(this.damage * 2); 
        }
    }

    public void regen() {
        if (this.hp < 100) { 
            this.hp = this.hp + 15; 
            if (this.hp > 100) {
                this.hp = 100; 
            }
        }
    }

    public void tampilkanStatus() {
        System.out.println("Nama  : " + this.nama);
        System.out.println("HP    : " + this.hp);
        System.out.println("Mana  : " + this.mana);
        System.out.println("Damage: " + this.damage);
        System.out.println("----------------------------");
    }

}