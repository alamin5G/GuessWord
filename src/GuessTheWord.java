import dictionary.Word;

import java.util.Scanner;
public class GuessTheWord {
    private boolean play = true;
    private Scanner input = new Scanner(System.in);
    private Word word = new Word();
    private int rounds = 10;
    private char lastRound;
    private String myGuess;
    public void start(){
        do {
            getInput();
            checkInput();
            showWord();
        }while (play);
    }

    private void showWord() {
        System.out.println("You have " + rounds + " tries left.");
        System.out.println(word);
    }
    private void checkInput() {
        boolean isGuessRight = word.guess(lastRound);
        if(isGuessRight){
            if(word.isGuessRight()){
                System.out.println("Congrats, you won!");
                System.out.println("The word is : "+word);
                play = false;
            }
        }else {
            rounds--;
            if(rounds==0){
                System.out.println("Game Over!");
                play = false;
            }
        }
    }
    private void getInput() {
        System.out.println("Enter a letter to Guess the Word: ");
        myGuess = input.nextLine();
        lastRound = myGuess.charAt(0);
    }

    public void end(){
        input.close();
    }
}
