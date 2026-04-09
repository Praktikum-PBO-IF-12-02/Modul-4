/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dev.renwxyz.modul4;

/**
 *
 * @author Rendy
 */
public class Hero {

    // Atribut private (tidak bisa diakses langsung dari luar class)
    private String nama;
    private int hp;
    private int mana;
    private int damage;

    // Constructor: digunakan untuk membuat object Hero dengan nilai awal yang valid
    public Hero(String nama, int hp, int mana, int damage) {
        this.nama = nama;

        // Validasi hp: minimal 0, maksimal 100
        if (hp < 0) {
            this.hp = 0;
        } else if (hp > 100) {
            this.hp = 100;
        } else {
            this.hp = hp;
        }

        // Validasi mana: minimal 0, maksimal 100
        if (mana < 0) {
            this.mana = 0;
        } else if (mana > 100) {
            this.mana = 100;
        } else {
            this.mana = mana;
        }

        // Validasi damage: minimal 0, maksimal 15
        if (damage < 0) {
            this.damage = 0;
        } else if (damage > 15) {
            this.damage = 15;
        } else {
            this.damage = damage;
        }
    }

    // Getter untuk nama
    public String getNama() {
        return nama;
    }

    // Getter untuk hp
    public int getHp() {
        return hp;
    }

    // Getter untuk mana
    public int getMana() {
        return mana;
    }

    // Getter untuk damage
    public int getDamage() {
        return damage;
    }

    // Method serang: hero ini menyerang hero musuh
    public void serang(Hero musuh) {
        // Hero yang sudah mati tidak bisa menyerang
        if (this.hp == 0) {
            System.out.println(this.nama + " sudah MATI, tidak bisa menyerang!");
            return;
        }

        System.out.println(this.nama + " menyerang " + musuh.getNama() + " sebesar " + this.damage + " damage!");

        // Kurangi HP musuh
        musuh.hp = musuh.hp - this.damage;

        // HP tidak boleh kurang dari 0
        if (musuh.hp < 0) {
            musuh.hp = 0;
        }
    }

    // Method gunakanSkill: serangan khusus 2x damage, menggunakan 25 mana
    public void gunakanSkill(Hero musuh) {
        // Hero yang sudah mati tidak bisa menggunakan skill
        if (this.hp == 0) {
            System.out.println(this.nama + " sudah MATI, tidak bisa menggunakan skill!");
            return;
        }

        // Cek apakah mana cukup
        if (this.mana < 25) {
            System.out.println(this.nama + " tidak cukup mana! Mana saat ini: " + this.mana);
            return;
        }

        int skillDamage = this.damage * 2;

        System.out.println(this.nama + " menggunakan SKILL ke " + musuh.getNama() + " sebesar " + skillDamage + " damage!");

        // Kurangi mana sebanyak 25
        this.mana = this.mana - 25;

        // Kurangi HP musuh
        musuh.hp = musuh.hp - skillDamage;

        // HP tidak boleh kurang dari 0
        if (musuh.hp < 0) {
            musuh.hp = 0;
        }
    }

    // Method heal: menambah HP sebanyak 15
    public void heal() {
        // Cek apakah HP sudah maksimum
        if (this.hp == 100) {
            System.out.println(this.nama + " HP sudah maksimum, tidak bisa regen!");
            return;
        }

        this.hp = this.hp + 15;

        // HP tidak boleh melebihi 100
        if (this.hp > 100) {
            this.hp = 100;
        }

        System.out.println(this.nama + " melakukan regen! HP sekarang: " + this.hp);
    }

    // Method tampilStatus: menampilkan semua atribut hero
    public void tampilStatus() {
        String status;
        if (this.hp == 0) {
            status = "DEAD";
        } else {
            status = "ALIVE";
        }

        System.out.println("==============================");
        System.out.println("Nama   : " + nama);
        System.out.println("HP     : " + hp);
        System.out.println("Mana   : " + mana);
        System.out.println("Damage : " + damage);
        System.out.println("Status : " + status);
        System.out.println("==============================");
    }
}