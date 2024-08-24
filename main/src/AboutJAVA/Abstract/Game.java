package AboutJAVA.Abstract;

public abstract class Game {

    private String rules;

    public Game(String rules) {
        this.rules = rules;
    }

    public abstract void playGame(int[] players);
}
