import java.util.*;

// -------------------- NUMBER GAME ---------------------

// To Generate a Random Number
class RandNumGenerator{
    int randNum;

    RandNumGenerator() {       
        Random rand = new Random();
        randNum = rand.nextInt(100) + 1;
    }

    int getRandNum() {
        return randNum;
    }
}

// To take Guess Number from User
class Player{
    int num;
    int score=0;
    
    int guessNum(){       // Method to guess Number
        System.out.print("Enter Number : ");
        Scanner sc = new Scanner(System.in);
        num = sc.nextInt();
        return num;
    }
    
}

// To Compare The Random Number and User Guessed Number
class Checker{
    int random;
    int numFromPlayer;
    Player player;
    int playerAttempt = 0;

    Checker(){
        player = new Player();
    }

    void collectRandNum(){
        RandNumGenerator obj = new RandNumGenerator();    // Creating object of RandNumGenerator Class
        random = obj.getRandNum();
    }
    
    void CollectPlayerNum(){                // Collecting Number from Player
        numFromPlayer = player.guessNum();
    }

    // Method to Compare 
    void check() {
        if (playerAttempt < 5) {

            playerAttempt++;            // Increasing the Player's Attempt number

            if (numFromPlayer == random) {          // if Player's guessed number == random number
                System.out.println("Congratulations! You have won the Game");
                player.score+=5;
                System.out.println();
                System.out.println("Your Score = "+player.score);
                System.out.println();
                return;

            } else if (numFromPlayer > random) {         // if Player's guessed number > random Number
                System.out.println("Ooops! Your guessed number is too High");
                player.score-=1;
                
            } else {                                    // if Player's guessed number < random number
                System.out.println("Ooops! Your guessed number is too low");
                player.score-=1;
                
            }

            int attemptsLeft = 5 - playerAttempt;       // Atteempts left for a Player

            if (attemptsLeft > 0) {
                System.out.println("You have only " + attemptsLeft + " attempts left");
                CollectPlayerNum();
                check();

            } else {
                System.out.println("Sorry!!! No attempts Left....You have lost the game");
                System.out.println("The Answer is = "+random);
                System.out.println();
                System.out.println("Your Score = "+player.score);
                System.out.println();

            }
        } else {             
            System.out.println("Sorry!!! No attempts Left....You have lost the game");
            System.out.println("The Answer is = "+random);
            System.out.println();
            System.out.println("Your Score = "+player.score);
            System.out.println();

        }
    }
    
}

public class Launch{
    public static void main(String[] args) {

        System.out.println("------- Welcome to Number Game -------");
        System.out.println();
        System.out.println("--> Game Rules : ");
        System.out.println("    1. You Have to Guess a Number within the range between 1 to 100");
        System.out.println("    2. You will get multiple rounds");
        System.out.println("    3. You Have only 5 attempts in each round");
        System.out.println("    4. For Guessing right number , Score will be +5");
        System.out.println("    5. For Guessing wrong number , Score will be -1");
        System.out.println();

        Checker c = new Checker();       // Creating a Checker Object
        c.collectRandNum();              // Generate and Collect a random number for the initial game
        
        while(true){
            c.CollectPlayerNum();       // Ask the player to guess a number
            c.check();                 // Check the player's guessed number against the random number

            System.out.println("Do you want to play again? (Yes/No)");
            
            Scanner sc = new Scanner(System.in);
            String playAgain = sc.next();
            
            

            if(playAgain.equalsIgnoreCase("No")){
                break;              // Exit the loop if the player chooses not to play again
            }
            c.playerAttempt=0;       // Reset the attempt count for the new game
            c.collectRandNum();       // Generate and collect a new random number for the new game
        }
    }
}