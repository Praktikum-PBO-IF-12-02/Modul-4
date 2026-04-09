/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package dev.renwxyz.modul4;

/**
 *
 * @author Rendy
 */
public class Modul4 {

    public static void main(String[] args) {

        // Membuat 2 object Hero
        Hero hero1 = new Hero("Layla", 100, 80, 10);
        Hero hero2 = new Hero("Balmond", 90, 50, 12);

        // Tampilkan status awal kedua hero
        System.out.println("=== STATUS AWAL ===");
        hero1.tampilStatus();
        hero2.tampilStatus();

        // Hero1 menyerang hero2
        System.out.println("\n=== RONDE 1: SERANGAN BIASA ===");
        hero1.serang(hero2);
        hero2.tampilStatus();

        // Hero2 menggunakan skill ke hero1
        System.out.println("\n=== RONDE 2: SKILL ===");
        hero2.gunakanSkill(hero1);
        hero1.tampilStatus();
        hero2.tampilStatus(); // mana hero2 berkurang

        // Hero1 melakukan heal
        System.out.println("\n=== RONDE 3: HEAL ===");
        hero1.heal();
        hero1.tampilStatus();

        // Simulasi hero mati (HP habis)
        System.out.println("\n=== SIMULASI HERO MATI ===");
        Hero hero3 = new Hero("Tigreal", 20, 30, 8);
        Hero hero4 = new Hero("Gusion", 100, 100, 15);

        hero3.tampilStatus();
        hero4.tampilStatus();

        // Gusion serang Tigreal sampai mati
        System.out.println("\nGusion menyerang terus...");
        hero4.serang(hero3);
        hero4.gunakanSkill(hero3);
        hero3.tampilStatus();

        // Coba hero mati menyerang
        System.out.println("\nTigreal mencoba menyerang balik...");
        hero3.serang(hero4);

        // Uji validasi nilai melebihi batas
        System.out.println("\n=== UJI VALIDASI BATAS NILAI ===");
        Hero heroTest = new Hero("TestHero", 200, -50, 999); // nilai tidak valid
        System.out.println("HP diset 200  -> HP tersimpan: " + heroTest.getHp());    // harusnya 100
        System.out.println("Mana diset -50 -> Mana tersimpan: " + heroTest.getMana()); // harusnya 0
        System.out.println("Damage diset 999 -> Damage tersimpan: " + heroTest.getDamage()); // harusnya 15
    }
}

