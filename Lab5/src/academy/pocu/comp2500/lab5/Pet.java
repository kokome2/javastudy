package academy.pocu.comp2500.lab5;

public class Pet {
    private String petName;
    private int petAttack;

    public Pet(String petNamer, int petAttackr) {
        petName = petNamer;
        petAttack = petAttackr;
    }

    public int getPetAttack() {
        return petAttack;
    }
}
