public class Hero {

    // Semua atribut bersifat private (Encapsulation)
    private String nama;
    private int hp;
    private int mana;
    private int damage;

    // Constructor — inisialisasi awal dengan validasi
    public Hero(String nama, int hp, int mana, int damage) {
        this.nama   = nama;
        this.hp     = Math.min(100, Math.max(0, hp));
        this.mana   = Math.min(100, Math.max(0, mana));
        this.damage = Math.min(15,  Math.max(0, damage));
    }

    // ===================== GETTER ONLY =====================
    // Tidak ada setter untuk hp, mana, damage.
    // nama tidak boleh diubah setelah object dibuat.

    public String getNama()  { return nama;   }
    public int    getHp()    { return hp;     }
    public int    getMana()  { return mana;   }
    public int    getDamage(){ return damage; }

    // ===================== METHOD PERILAKU =====================

    /**
     * Menyerang hero lain dengan damage dasar.
     * Hero yang sudah mati tidak bisa menyerang.
     */
    public void attack(Hero target) {
        if (this.hp == 0) {
            System.out.println("[ERROR] " + this.nama + " sudah DEAD, tidak bisa menyerang!");
            return;
        }
        if (target.hp == 0) {
            System.out.println("[ERROR] " + target.nama + " sudah DEAD!");
            return;
        }
        target.takeDamage(this.damage);
        System.out.println(this.nama + " menyerang " + target.nama +
                " sebesar " + this.damage + " damage. HP " +
                target.nama + " tersisa: " + target.hp);
    }

    /**
     * Menggunakan skill: damage 2x, mengonsumsi 25 mana.
     */
    public void useSkill(Hero target) {
        if (this.hp == 0) {
            System.out.println("[ERROR] " + this.nama + " sudah DEAD, tidak bisa menggunakan skill!");
            return;
        }
        if (target.hp == 0) {
            System.out.println("[ERROR] " + target.nama + " sudah DEAD!");
            return;
        }
        if (this.mana < 25) {
            System.out.println("[ERROR] " + this.nama + " mana tidak cukup! Mana saat ini: " + this.mana);
            return;
        }
        this.mana -= 25;
        int skillDamage = this.damage * 2;
        target.takeDamage(skillDamage);
        System.out.println(this.nama + " menggunakan SKILL ke " + target.nama +
                " sebesar " + skillDamage + " damage. Sisa mana " +
                this.nama + ": " + this.mana +
                " | HP " + target.nama + " tersisa: " + target.hp);
    }

    /**
     * Regen: menambah HP sebanyak 15, maksimal 100.
     */
    public void heal() {
        if (this.hp == 0) {
            System.out.println("[ERROR] " + this.nama + " sudah DEAD, tidak bisa regen!");
            return;
        }
        if (this.hp >= 100) {
            System.out.println("[INFO] " + this.nama + " HP sudah maksimum (100), tidak perlu regen.");
            return;
        }
        int before = this.hp;
        this.hp = Math.min(100, this.hp + 15);
        System.out.println(this.nama + " regen! HP: " + before + " -> " + this.hp);
    }

    /**
     * Mengurangi HP — private, hanya bisa dipanggil dari dalam class.
     * HP tidak boleh kurang dari 0.
     */
    private void takeDamage(int dmg) {
        this.hp = Math.max(0, this.hp - dmg);
        if (this.hp == 0) {
            System.out.println(">>> " + this.nama + " telah dikalahkan! [DEAD]");
        }
    }

    /**
     * Menampilkan status lengkap hero beserta keterangan ALIVE / DEAD.
     */
    public void displayStatus() {
        String status = (this.hp > 0) ? "ALIVE" : "DEAD";
        System.out.println("+-----------------------------+");
        System.out.println("| Nama   : " + this.nama);
        System.out.println("| Status : " + status);
        System.out.println("| HP     : " + this.hp + " / 100");
        System.out.println("| Mana   : " + this.mana + " / 100");
        System.out.println("| Damage : " + this.damage);
        System.out.println("+-----------------------------+");
    }
}
