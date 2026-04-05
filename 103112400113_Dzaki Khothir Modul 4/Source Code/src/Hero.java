public class Hero {
    private String name;
    private int hp;
    private int mana;
    private int damage;

    // Constructor
    public Hero(String name, int hp, int mana, int damage) {
        this.name = name;

        if(hp < 0) {
            this.hp = 0;
        }
        else if(hp > 100) {
            this.hp = 100;
        }
        else {
            this.hp = hp;
        }

        if(mana < 0) {
            this.mana = 0;
        }
        else if(mana > 100) {
            this.mana = 100;
        }
        else {
            this.mana = mana;
        }

        if(damage < 0) {
            this.damage = 0;
        }
        else if(damage > 15) {
            this.damage = 15;
        }
        else {
            this.damage = damage;
        }

    }

    // Method untuk menerima damage
    private void terimaDamage(int dmg) {
        this.hp -= dmg;
        if (this.hp < 0) this.hp = 0;
    }

    // Method Menyerang
    public void menyerang(Hero musuh) {
        if(this.hp <= 0) {
            System.out.println("udah mati, gak bisa diserang");
            return;
        }
        
        System.out.println(this.name + " menyerang dengan damage: " + this.damage);
        musuh.terimaDamage(this.damage);
    }

    // Method Skill
    public void skill(Hero musuh){
        if (this.hp == 0) {
            System.out.println(this.name + " sudah mati!");
            return;
        }
        if (this.mana < 25) {
            System.out.println(this.name + " tidak memiliki cukup mana untuk menggunakan skill!");
            return;
        }

        this.mana -= 25;
        int skillDamage = this.damage * 2;
        System.out.println(this.name + " menggunakan skill dengan damage: " + skillDamage);
        musuh.terimaDamage(skillDamage);
    }

    //Method Regen
    public void regen(){
        if (this.hp == 0) {
            System.out.println(this.name + " sudah mati!");
            return;
        }
        if(this.hp == 100){
            System.out.println(this.name + " sudah full hp!");
            return;
        }
        this.hp += 15;
        if (this.hp > 100) {
            this.hp = 100;
        }
        System.out.println(this.name + " melakukan regen, HP sekarang: " + this.hp);

    }

    // Method Tampilan Hero
    public void showStatus() {
        String status = (hp == 0) ? "DEAD" : "ALIVE";

        System.out.println("Nama   : " + name);
        System.out.println("HP     : " + hp);
        System.out.println("Mana   : " + mana);
        System.out.println("Damage : " + damage);
        System.out.println("Status : " + status);
        System.out.println("----------------------");
    }

}
