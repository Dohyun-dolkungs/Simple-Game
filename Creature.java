public class Creature {
    // instance variable
    private int difficulty;
    private String creatureName;

    // constructor
    public Creature(int newDifficulty) {
        difficulty = newDifficulty;
        creatureName = GameData.getMonsterNameByDifficulty(newDifficulty);
    }

    // method
    public int getDifficulty() {
        return difficulty;
    }

    public String toString() {
        return creatureName;
    }
}
