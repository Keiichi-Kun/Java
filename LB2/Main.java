package ai221.shevchenko;

/**
 * Contains methods for working with class String
 *
 * @author Keiichi-Kun
 * @version openjdk-19 7 Oct 2022
 */
public class Main {
    /**
     * Gets a string and returns true if the string ends with "ed"
     * and false otherwise
     *
     * @param word    - The word to compare its end with the second parameter
     * @param wordEnd - the end of the word that the first parameter should have
     */
    private static boolean compareEnd(String word, String wordEnd) {
        final int lengthWord = word.length();
        final int lengthEnd = wordEnd.length();

        // if the main word is shorter than its particle
        if (lengthWord < lengthEnd) {
            return false;
        }
        for (int i = 0; i < lengthEnd; i++) {
            // If the previous character is not equal to the current one
            if (wordEnd.charAt(i) != word.charAt(lengthWord - lengthEnd + i)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Gets a string and returns the sum of the digits
     * found in that string
     *
     * @param sentence - The string, which is a set of characters
     */
    private static int countSumDigits(String sentence) {
        int sum = 0;
        for (int i = 0; i < sentence.length(); ++i) {
            // If the symbol is digit
            if (sentence.charAt(i) >= '0' && sentence.charAt(i) <= '9') {
                sum += sentence.charAt(i) - '0'; // converts char to the integer
            }
        }
        return sum;
    }

    /**
     * Gets a string and returns the length
     * of the longest "block" of characters in that string
     *
     * @param sentence - The string, which is a set of characters
     */
    private static int findMaxLengthBlock(String sentence) {
        if (sentence.isEmpty()) {
            return 0;
        }

        int max = 1;
        int lengthBlock = 1;

        for (int i = 1; i < sentence.length(); ++i) {
            // The current symbol is equal to the previous one
            if (sentence.charAt(i) == sentence.charAt(i - 1)) {
                ++lengthBlock;
            } else {
                if (lengthBlock > max) {
                    max = lengthBlock;
                }
                lengthBlock = 1;
            }
        }
        //Checks if the length of the last block is greater than the maximum
        if (lengthBlock > max) {
            max = lengthBlock;
        }
        return max;
    }

    /**
     * Gets a string as input and prints the found words in this string to the console
     *
     * @param sentence - The string, which is a set of characters
     */
    private static void printListOfWords(String sentence) {
        int beginWord = 0;
        boolean isWord = false;
        sentence += ' '; //mark the end of a sentence

        for (int i = 0; i < sentence.length(); ++i) {
            // If the current character is not a space
            if (sentence.charAt(i) != ' ') {
                // If the current character is the beginning of a word
                if (isWord == false) {
                    beginWord = i; // writes the index of the first character of a word
                    isWord = true;
                }
            } else {
                if (isWord == true) {
                    System.out.println(sentence.substring(beginWord, i));
                    isWord = false;
                }
            }
        }
    }

    /**
     * Receives two strings (A and B) and returns a string that consists
     * of the i-th characters of each of the strings in turn.
     *
     * @param firstSentence  - The first string
     * @param secondSentence - The second string
     */
    private static void combineSentences(String firstSentence, String secondSentence) {

        int newLineLength = firstSentence.length() + secondSentence.length(); // The length of new line
        String newLine = "";

        for (int i = 0; i < newLineLength; ++i) {
            // If the number is even, then the queue of the first line
            if (i % 2 == 0) {
                // If not the end of the first sentence
                if (i / 2 < firstSentence.length()) {
                    newLine += firstSentence.charAt(i / 2); // Appends a character to the newline from first sentence
                } else {
                    //Appends the remaining characters from the second line
                    newLine += secondSentence.substring(i / 2, secondSentence.length());
                    break;
                }
            } else {
                if (i / 2 < secondSentence.length()) {
                    newLine += secondSentence.charAt(i / 2);
                } else {
                    newLine += firstSentence.substring(i / 2 + 1, firstSentence.length());
                    break;
                }
            }
        }

        System.out.println(newLine);
    }

    /**
     * Display all the tasks
     */
    public static void main(String[] args) {
        System.out.println("Task 1:");
        String sentenceTask1 = "Completed";
        System.out.println("Line: " + sentenceTask1);
        System.out.println("The line ends with 'ed': " + compareEnd("Completed", "ed"));

        System.out.print("\n");
        System.out.println("Task 2:");
        String sentenceTask2 = "How4 ar5e 1you 7!";
        System.out.println("Line: " + sentenceTask2);
        System.out.println("Sum of the digits in the sentence: " + countSumDigits(sentenceTask2));

        System.out.print("\n");
        System.out.println("Task 3:");
        String sentenceTask3 = "Lool Heeeey Daaa!";
        System.out.println("Line: " + sentenceTask3);
        System.out.println("The longest block in the sentence: " + findMaxLengthBlock(sentenceTask3));

        System.out.print("\n");
        System.out.println("Task 4:");
        String sentenceTask4 = "What a wonderful day!";
        System.out.println("Line: " + sentenceTask4);
        System.out.println("List of words:");
        printListOfWords(sentenceTask4);

        System.out.print("\n");
        System.out.println("Task 5:");
        String phrase = "a wonderful day!";
        String numbers = "123567890";
        System.out.println("First line: " + phrase);
        System.out.println("Second line: " + numbers);
        System.out.println("Combined sentences:");
        combineSentences("Just do", "123567890");
    }
}