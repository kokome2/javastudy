package academy.pocu.comp2500.lab5;

public class Move {
    private String skillName;
    private int skillPower;
    private int maximumPower;

    public Move(String skillNamer, int skillPowerer, int maximumPowerer) {
        skillName = skillNamer;
        skillPower = skillPowerer;
        maximumPower = maximumPowerer;
    }

    public String getmSkillName() {
        return skillName;
    }

    public int getmSkillPower() {
        return skillPower;
    }

    public void SetSkillPower(int skillpowerer) {
        skillPower = skillpowerer;
    }


}
