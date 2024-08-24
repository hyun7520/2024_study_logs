package AboutJAVA.Abstract;

public class Player {

    private String name;

    private int intelligence;

    public Player(String name, int intelligence) {
        this.name = name;
        this.intelligence = intelligence;
    }

    public String getName() {
        return name;
    }

    public int getIntelligence() {
        return intelligence;
    }
}
