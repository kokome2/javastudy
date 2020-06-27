package academy.pocu.comp2500.lab5;

import java.util.ArrayList;

public class Gladiator extends Barbarian {
    protected ArrayList<Move> mover;

    public Gladiator(String name, int hp, int attack, int defence) {
        super(name, hp, attack, defence);
        mover = new ArrayList<Move>();
    }

    public boolean addMove(Move move) {
        int count = 0;
        if (mover.size() == 0) {
            mover.add(move);
            return true;
        } else {
            for (int i = 0; i < mover.size(); i++) {
                if (mover.get(i).getmSkillName() != move.getmSkillName()) {
                    count++;
                }
            }
        }

        if ((count == mover.size()) && (count < 4)) {
            mover.add(move);
            return true;
        } else {
            return false;
        }
    }

    public boolean removeMove(String move) {
        for (int i = 0; i < mover.size(); i++) {
            if (mover.get(i).getmSkillName() == move) {
                mover.remove(i);
                return true;
            }
        }
        return false;
    }

    public void attack(String skillname, Gladiator opponent) {
        if (opponent == this) {
            return;
        }

        for (int i = 0; i < mover.size(); i++) {
            if (mover.get(i).getmSkillName().equals(skillname)) {
                int temp = opponent.getHp();
                double attack = super.attack;
                double defence = opponent.defence;
                double skillpower = mover.get(i).getmSkillPower();

                int damage = (int) ((attack / defence * skillpower) / 2);
                if (damage < 0) {
                    damage = 1;
                }

                if (damage > opponent.getHp()) {
                    damage = opponent.getHp();
                }

                temp -= damage;
                opponent.hp = temp;

            }
        }
    }

    public void attack(String skillname, Barbarian opponent) {
        if (opponent == this) {
            return;
        }

        for (int i = 0; i < mover.size(); i++) {
            if (mover.get(i).getmSkillName().equals(skillname)) {
                int temp = opponent.getHp();
                double attack = super.attack;
                double defence = opponent.defence;
                double skillpower = mover.get(i).getmSkillPower();

                int damage = (int) ((attack / defence * skillpower) / 2);
                if (damage < 0) {
                    damage = 1;
                }

                if (damage > opponent.getHp()) {
                    damage = opponent.getHp();
                }

                temp -= damage;
                opponent.hp = temp;
            }
        }
    }

    public void rest() {
        for (int i = 0; i < mover.size(); i++) {
            int temp = mover.get(i).getmSkillPower();
            mover.get(i).SetSkillPower(temp + 1);
        }
        hp += 10;
    }
}
