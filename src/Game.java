/**
 * @author Trevor Hartman
 * @author Adrienne van Summern
 *
 * @since Version 1.0
 */

import java.util.Scanner;

public class Game {
    Player p1;
    Player p2;
    Dice die;

    public Game(Player x, Player y, Dice z) {
        p1 = x;
        p2 = y;
        die = z;
    }

    public void play() {
        //declare a local Player variable named current that gets assigned this.p1 and calls methods takeTurn, nextPlayer, and takeTurn again before printing method announceWinner
        Player current = this.p1;
        takeTurn(current);
        current = nextPlayer(current);
        takeTurn(current);
        announceWinner();
    }

    public Player nextPlayer(Player current) {
        if (current == this.p1){
            current = this.p2;
        }
        else {
            current = this.p1;
        }
        return current;
    }

    public void takeTurn(Player player) {
        player.toss(this.die);
    }

    public String announceWinner() {
        //display each Player's name and score, then using conditions needs to determine which Player's score is highest, and finally return the winning Player's name.
        String p1Name = p1.getName();
        String p2Name = p2.getName();
        int p1Score = p1.getScore();
        int p2Score = p2.getScore();
        System.out.printf("Player 1: %s %d\nPlayer 2: %s %d\n", p1Name, p1Score, p2Name, p2Score);
        if (p1Score > p2Score){
            System.out.printf("%s wins!", p1Name);
        }
        if (p2Score > p1Score){
            System.out.printf("%s wins!", p2Name);
        }
        if (p1Score == p2Score){
            System.out.println("Its a tie!");
        }
        return null;
    }

    public static void main(String[] args) {
        //Create a Scanner object.
        Scanner input = new Scanner(System.in);
        //Request and store in an int variable the number of sides you Dice should have.
        System.out.println("Please enter the number of sides of the die: ");
        int sides = Integer.valueOf(input.nextLine());
        System.out.println("Enter the first player's name: ");
        String firstPlayer = input.nextLine();
        System.out.println("Enter the second player's name: ");
        String secondPlayer = input.nextLine();

        Dice sidedDie = new Dice(sides);
        Player one = new Player(firstPlayer);
        Player two = new Player(secondPlayer);

        //Create a new Game object and pass its constructor two new Player objects, and a new Dice object.
        Game firstGame = new Game(one, two, sidedDie);

        //use the Game object to call the play method and play the game.
        firstGame.play();
    }
}
