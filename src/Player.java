/**
 * @author Trevor Hartman
 * @author Adrienne van Summern
 *
 * @since Version 1.0
 */
public class Player {
    private String name;
    private int score;

    public Player(String x){
        name = x;
    }
    public String getName() {
        return name;
    }
    public int getScore()
    {
        return score;
    }
    public void toss(Dice dice){
        score = dice.roll();
    }
}