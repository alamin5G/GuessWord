package dictionary;

import java.util.Random;

public class Word {
    private String[]  wordDictionary = {"Apple", "Ball", "Bat", "Fish", "Mutton", "Cow", "Bread",
            "Mango", "Jack-Fruit", "Watermelon", "Elephant", "Parrot", "Book", "English", "Love"};
    private Random random = new Random();
    private String selectWords;
    private char[] letter;
    public Word(){
        selectWords = wordDictionary[random.nextInt(wordDictionary.length)];
        letter = new char[selectWords.length()];
    }
    public String toString(){
        StringBuilder nullText = new StringBuilder();
        for (char letters: letter) {
            nullText.append(letters == '\u0000'? "*" : letters);
            nullText.append(" ");
        }
        return nullText.toString();
    }
    public boolean isGuessRight(){
        for (char letters: letter ) {
            if(letters == '\u0000'){
                return false;
            }
        }
        return true;
    }
    public boolean guess(char letter) {
        boolean guessRight = false;
        for (int i = 0; i < selectWords.length(); i++) {
            if (letter==selectWords.charAt(i)){
                this.letter[i] = letter;
                guessRight = true;
            }
        }
        return guessRight;
    }
}
