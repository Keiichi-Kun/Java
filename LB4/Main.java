package ai221.shevchenko;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Scanner;

/**
 * Contains methods for working with class String
 *
 * @author Keiichi-Kun
 * @version openjdk-19 10 Oct 2022
 */
public class Main {

    static int numTask = 1; // Number of the current task

    /**
     * Template for displaying the result above the string while using regular expressions
     *
     * @param taskText  - text for the task
     * @param regex - regular expression for the taskText
     */
    public static void displayRegexTask(String taskText, String regex)
    {
        Pattern p = Pattern.compile(regex); // compiled regular expression
        Matcher matcher = p.matcher(taskText);
        System.out.println("Task " + numTask++);
        System.out.println("Text: " + taskText);
        System.out.println("Regular expression(" + regex + "): " + matcher.matches());
        System.out.print("\n");
    }

    /**
     * Outputs words from a string consisting of 4 letters.
     *
     * @param text  - text for the task
     */
    private static void numberFourLetterWords(String text){
        System.out.println("List of words that has length 4");
        String[] words = text.split("[ .!?,]");
        for(String word : words){
            if(word.length() == 4) {
                System.out.println(word);
            }
        }
    }

    /**
     * Replace all characters of the Latin alphabet in the word with the
     * corresponding characters of the Russian alphabet
     *
     * @param text  - text for the task
     */
    private static String convertLatToRu(String text) {
        final String[] newAlphabet = {"ЭЙ", "БИ", "СИ", "ДИ", "И", "ЭФ", "ДЖИ",
                "ЭЙЧ", "АЙ", "ДЖЕЙ", "КЕЙ", "ЭЛ", "ЭМ", "ЭН",
                "ОУ", "ПИ", "КЬЮ", "АР", "ЭС", "ТИ", "Ю",
                "ВИ", "ДАБЛ-Ю", "ЭКС", "УАЙ", "ЗИ"};
        for (int i = 0; i < 26; ++i){
            String latLetter = "" + (char)('A' + i); // current letter of the English alphabet
            // replaces all uppercase letters of a Latin letter with the corresponding Russian letter
            text = text.replaceAll(latLetter, newAlphabet[i]);
            // replaces all lowercase letters of a Latin letter with the corresponding Russian letter
            text = text.replaceAll(latLetter.toLowerCase(), newAlphabet[i].toLowerCase());
        }
        return text;
    }

    /**
     * Prompts the user to enter the number of words and then prompts him to enter them
     */
    private static String[] inputWords(){
        Scanner in = new Scanner(System.in); // for console input

        System.out.print("Enter number of words: ");
        int numWords = in.nextInt(); // prompts the user to enter an integer and initializes numWords

        String[] userWords = new String[numWords];
        for(int i = 0; i < numWords; ++i){
            System.out.print("Enter word " + (i+1) + ": ");
            userWords[i] = in.next(); // reads a word into array
        }
        return userWords;
    }

    /**
     * Counts the number of words that match the regular expression
     *
     * @param words  - set of the words
     * @param regex  - regular expression for the word
     */
    private static int countWordsWithRegex(String[] words, String regex){
        int numWords = 0;
        for(String word : words){
            // If the word matches the regular expression
            if(word.matches(regex)){
                ++numWords;
            }
        }
        return  numWords;
    }

    /**
     * Checks if a word is a palindrome
     *
     * @param word  - the word to check
     */
    private static boolean isPalindrome(String word){
        int first = 0; // The first letter of the word
        int last = word.length() - 1;  // The last letter of the word
        while(first < last){ // Until the words reach the middle
            if(word.charAt(first) != word.charAt(last)){ // Compares characters from opposite sides
                return false;
            }
            ++first;
            --last;
        }
        return true;
    }

    /**
     * Checks if a word is a palindrome
     *
     * @param words - set of the words
     */
    private static void findPalindromeNumbers(String[] words){
        for(String word : words){
            // If the word consists only digits
            if(word.matches("\\d+")){
                // If the word is palindrome, then output it
                if(isPalindrome(word)){
                    System.out.println(word);
                }
            }
        }
    }

    /**
     * Displays all the tasks and creates One dimensional array with random numbers.
     */
    public static void main(String[] args) {
        displayRegexTask("a@b", "a.b");
        displayRegexTask("abbbba", "ab*a");
        displayRegexTask("aa", "ab?a");
        displayRegexTask("aefddfa", "a[a-zA-Z]*a");
        displayRegexTask("я4Ауауц6вв", "[а-яА-Я0-9]*");
        displayRegexTask("#FFFFFF", "#[A-Z0-9]{6}");
        String octIP = "(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)";
        displayRegexTask("241.162.12.034", octIP+"\\."+ octIP+"\\."+ octIP+"\\."+ octIP);
        displayRegexTask("_FEsad.java", "[a-zA-Z_]+.java");
        displayRegexTask("maxSpeed_1", "[a-zA-Z_]\\w*");
        displayRegexTask("Shevchenko O.V.", "[A-Z][a-z]{1,25}\s[A-Z]\\.[A-Z]\\.");

        System.out.println("Task " + numTask++);
        String text = "Velit aute nostrud exex? mollit consectetur qui vfut. ";
        numberFourLetterWords(text);

        System.out.println("\nTask " + numTask++);
        System.out.println(text);
        System.out.println(convertLatToRu(text));

        System.out.println("\nTask " + numTask++);
        System.out.println("Number of Latin words: " + countWordsWithRegex(inputWords(), "[a-zA-Z]+"));

        System.out.println("\nTask " + numTask++);
        System.out.println("Words with only numbers: " + countWordsWithRegex(inputWords(), "\\d+"));

        System.out.println("\nTask " + numTask++);
        System.out.println("Palindrome words with only numbers: ");
        findPalindromeNumbers(inputWords());
        }
}