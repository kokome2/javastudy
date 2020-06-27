package academy.pocu.comp2500.lab5;

public class Knight extends Gladiator {
    private Pet pet;

    public Knight(String name, int hp, int attack, int defence) {
        super(name, hp, attack, defence);
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

        if ((count == mover.size()) && (count < 5)) {
            mover.add(move);
            return true;
        } else {
            return false;
        }
    }

    public void setPet(Pet peter) {
        if (peter == null) {
            pet = null;
        }
        pet = peter;
    }

    public void attackTogether(Knight knighter) {
        if (knighter == this) {
            return;
        }
        if (pet != null) {
            double attack = this.attack;
            double petattack = pet.getPetAttack();
            double knight = knighter.defence;
            int temp = (int) (attack + petattack - knight) / 2;
            if (temp < 0) {
                temp = 1;
            }

            if (temp > knighter.hp) {
                temp = knighter.hp;
            }

            knighter.hp -= temp;
        }

    }

    public void attackTogether(Gladiator gladiatorer) {
        if (gladiatorer == this) {
            return;
        }
        if (pet != null) {
            double attack = this.attack;
            double petattack = pet.getPetAttack();
            double gladiator = gladiatorer.defence;
            int temp = (int) (attack + petattack - gladiator) / 2;
            if (temp < 0) {
                temp = 1;
            }

            if (temp > gladiatorer.hp) {
                temp = gladiatorer.hp;
            }

            gladiatorer.hp -= temp;
        }
    }

    public void attackTogether(Barbarian barbarianer) {
        if (barbarianer == this) {
            return;
        }
        if (pet != null) {
            double attack = this.attack;
            double petattack = pet.getPetAttack();
            double barbarian = barbarianer.defence;
            int temp = (int) (attack + petattack - barbarian) / 2;
            if (temp < 0) {
                temp = 1;
            }

            if (temp > barbarianer.hp) {
                temp = barbarianer.hp;
            }


            barbarianer.hp -= temp;
        }
    }


}
