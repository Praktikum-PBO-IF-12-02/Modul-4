import java.util.Scanner;

class Hero {
private String nama;
private int hp;
private int mana;
private int damage;

  Hero(String namaHero, int hpHero, int manaHero, int damageHero) {
  if (hpHero >= 0 && hpHero <= 100) {
    this.hp = hpHero;
  } else {
    System.out.println("Hp hero tidak valid minimal 0 maksimal 100");
    System.exit(0);
  }

  if (manaHero >= 0 && manaHero <= 100) {
    this.mana = manaHero;
  } else {
    System.out.println("mana hero tidak valid minimal 0 maksimal 100");
    System.exit(0);
  }

  if (damageHero >= 0 && damageHero <= 15) {
    this.damage = damageHero;
  } else {
    System.out.println("damage hero tidak valid minimal 0 maksimal 15");
    System.exit(0);
  }
  this.nama = namaHero;
}

void tampilkanAtribut() {
  System.out.println("\n===== Atribut hero =====");
  System.out.println("Nama Hero : " + nama);
  System.out.println("Hp Hero : " + hp);
  System.out.println("Mana Hero : " + mana);
  System.out.println("Damage Hero : " + damage);
  if (hp>0) {
    System.out.println("Status Hero : ALIVE");
  } else {
    System.out.println("Status Hero : DEAD");
  }
  System.out.println("========================");

}

boolean attackHero (Hero hero) {
  if (hp <= 0) {
    System.out.println("Hero " + nama + " sudah kehabisan HP tidak bisa menyerang");
    return false;
  } else if ( hero.hp <= 0 ) {
    System.out.println("Hero " + nama + " tidak bisa melakukan serangan karna lawan sudah kalah");
    return false;
  }else if ( hero.hp < damage ) {
    hero.hp = 0;
    return true;
  } else {
    hero.hp -= damage;
    return true;
  }
}

boolean activateSkil (Hero hero) {
  if (hp <= 0) {
    System.out.println("Hero " + nama + " sudah kehabisan HP tidak bisa menyerang");
    return false;
  } else if ( mana < 25 ){
    System.out.println("Hero " + nama + " mana tidak cukup untuk aktivasi skill ");
    return false;
  } else if ( hero.hp <= 0 ) {
    System.out.println("Hero " + nama + " tidak bisa aktivasi Skill karna lawan sudah kalah");
    return false;
  } else if ( hero.hp < (damage * 2) ) {
    hero.hp = 0;
    mana -= 25;
    return true;
  }else {
    hero.hp -= (damage * 2);
    mana -= 25;
    return true;
  }
}

boolean healHero( ) {
  if (hp == 100) {
    System.out.println("Hero " + nama + " tidak bisa menggunakan heal karna hp masih full");
    return false;
  } else if (hp <= 0) {
    System.out.println("Hero " + nama + " tidak bisa menggunakan heal karna sudah KO");
    return false;
  } else if ( hp > 85 ) {
    hp = 100;
    return true;
  } else {
    hp += 15;
    return true;
  }
}

boolean isAlive() {
  return hp > 0;
}

String getNama() {
  return nama;
}
}

public class LaporanPraktikumModul4 {
  public static void main(String[] args) {
    Hero heroA = new Hero("Layla", 1, 100, 15);
    Hero heroB = new Hero("Fredrin", 100, 10, 5);
    Scanner input = new Scanner(System.in);

    int ronde = 0;
    while (heroA.isAlive() && heroB.isAlive()) {
      Hero attacker;
      Hero target;

    if (ronde % 2 == 0) {
      attacker = heroA;
      target = heroB;
    } else {
      attacker = heroB;
      target = heroA;
    }

    System.out.println("\n===== GILIRAN " + attacker.getNama() + " =====");
    System.out.println("1. Basic Attack");
    System.out.println("2. Skill");
    System.out.println("3. Heal");
    System.out.print("Pilih aksi: ");
    int aksi = input.nextInt();
    boolean aksiBerhasil = false;

    switch (aksi) {
      case 1:
        aksiBerhasil = attacker.attackHero(target);
        break;
      case 2:
        aksiBerhasil = attacker.activateSkil(target);
        break;
      case 3:
        aksiBerhasil = attacker.healHero();
        break;
      default:
        System.out.println("Input tidak valid!");
        continue;
    }

    heroA.tampilkanAtribut();
    heroB.tampilkanAtribut();

    if (aksiBerhasil) {
      ronde++;
    }
    }

    if ( ronde > 0) {
      System.out.println("===== BATTLE SELESAI =====");
      if (heroA.isAlive()) {
        System.out.println("Pemenang: " + heroA.getNama());
      } else {
        System.out.println("Pemenang: " + heroB.getNama());
      }
    }
    

    input.close();
  }
}
