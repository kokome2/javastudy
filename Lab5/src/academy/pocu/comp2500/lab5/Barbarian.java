package academy.pocu.comp2500.lab5;

public class Barbarian {
    protected String name;
    protected int hp;
    protected int attack;
    protected int defence;

    public Barbarian(String name_p, int hp_p, int attack_p, int defence_p) {
        name = name_p;
        hp = hp_p;
        attack = attack_p;
        defence = defence_p;
    }

    public int getHp() {
        return hp;
    }

    public void attack(Barbarian otherBarbarian) {
        if (otherBarbarian == this) {
            return;
        }
        double attack = this.attack;
        double defence = otherBarbarian.defence;
        int damage = (int) ((attack - defence) / 2);
        if (damage < 0) {
            damage = 1;
        }

        if (damage > otherBarbarian.hp) {
            damage = otherBarbarian.hp;
        }

        otherBarbarian.hp = otherBarbarian.hp - damage;
    }

    public boolean isAlive() {
        if (this.hp <= 0) {
            return false;
        } else {
            return true;
        }
    }


}
