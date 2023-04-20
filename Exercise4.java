import java.util.*;

public class ElfWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
      //reads the two words from the input 
        String firstWord = scanner.nextLine();
        String secondWord = scanner.nextLine();
        int commonLetters = 0;
        int minLength = Math.min(firstWord.length(), secondWord.length());
      //uses a loop to iterate over their characters one by one
        for (int i = 0; i < minLength; i++) {
          //counts the number of common letters at the beginning of 
          //the words until it reaches a position where the letters are different
            if (firstWord.charAt(i) == secondWord.charAt(i)) {
                commonLetters++;
            }
        }
      //calculates the length of the two words minus twice the number of common letters
      //total number of letters that the elf needs to cross out to make the words similar
        System.out.println(firstWord.length() + secondWord.length() - 2 * commonLetters);
    }
}
