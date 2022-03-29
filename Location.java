public class Location {
    private String name;
    private int difficulty;

    public Location(int newDifficulty) {
        difficulty = newDifficulty;
        // name = GameData.getRandomName();
        name = "Dohyun";
    }

    public String toString() {
        return name;
    }

    public String toStringLong() {
        return  name + difficulty;
    }
}
