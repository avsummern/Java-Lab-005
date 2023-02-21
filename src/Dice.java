/**
 * @author Trevor Hartman
 * @author Adrienne van Summern
 *
 * @since Version 1.0
 */
import java.util.Random;
public class Dice {
    private int sideFacingUp;
    private int sides;
    private Random randomGenerator;
    public Dice(int sides){
        this.sides = sides;
        randomGenerator = new Random();
    }

    public int roll(){
        sideFacingUp = randomGenerator.nextInt(sides) + 1;
        return sideFacingUp;
    }
    public int view(){
        return sideFacingUp;
    }
}