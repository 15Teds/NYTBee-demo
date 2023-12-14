
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

/**
 * Write a description of class CodewarsSpell here.
 *
 * @author Ted
 * @version 1.0.0
 */

public class CodewarsSpell {

    public static void main(String[] args) throws FileNotFoundException {
        List<String> wordlist = new ArrayList<>();
        List<String> wordFileList = new ArrayList<>();

        // Assuming word_file is defined and contains words
        File word_file = new File("words.txt");
        Scanner sc = new Scanner(word_file);
        while (sc.hasNextLine()) {
            wordFileList.add(sc.nextLine());
        }
        sc.close();

        for (String word : wordFileList) {
            if (word.length() > 4 && word.length() < 8) {
                wordlist.add(word);
            }
        }

        List<String> lettersList = new ArrayList<>();
        lettersList.add("v");
        lettersList.add("a");
        lettersList.add("i");
        lettersList.add("m");
        lettersList.add("o");
        lettersList.add("t");

        String centerLetter = "r";

        CodewarsSpell cws = new CodewarsSpell();
        List<String> acceptableWords = cws.solveSpellingBee(lettersList, centerLetter, wordlist);

        System.out.println(acceptableWords);
        System.out.println(acceptableWords.size() + " words found.");

    }

    public List<String> solveSpellingBee(List<String> lettersList, String centerLetter, List<String> wordlist) {
        List<String> acceptableWords = new ArrayList<>();

        List<String> alphabet = new ArrayList<>();
        alphabet.add("a");
        alphabet.add("b");
        alphabet.add("c");
        alphabet.add("d");
        alphabet.add("e");
        alphabet.add("f");
        alphabet.add("g");
        alphabet.add("h");
        alphabet.add("i");
        alphabet.add("j");
        alphabet.add("k");
        alphabet.add("l");
        alphabet.add("m");
        alphabet.add("n");
        alphabet.add("o");
        alphabet.add("p");
        alphabet.add("q");
        alphabet.add("r");
        alphabet.add("s");
        alphabet.add("t");
        alphabet.add("u");
        alphabet.add("v");
        alphabet.add("w");
        alphabet.add("x");
        alphabet.add("y");
        alphabet.add("z");

        List<String> unacceptableLetters = new ArrayList<>();
        for (String l : alphabet) {
            if (!lettersList.contains(l)) {
                unacceptableLetters.add(l);
            }
        }

        unacceptableLetters.remove(centerLetter);

        System.out.println(unacceptableLetters);

        for (String word : wordlist) {
            word = word.toLowerCase();
            if (word.contains(centerLetter)) {
                if (!acceptableWords.contains(word)) {

                    boolean containsUnacceptableLetter = false;
                    for (String l : unacceptableLetters) {
                        if (word.contains(l)) {
                            // System.out.println(word + " contains " + l);
                            containsUnacceptableLetter = true;
                        }
                    }
                    System.out.println(word + " containsUnacceptableLetter: " + containsUnacceptableLetter);
                    if (!containsUnacceptableLetter) {
                        System.out.println(word);
                        acceptableWords.add(word);
                    }
                }
            }
        }

        return acceptableWords;

    }

}
