package week1.practice_problems;

public class P4_FirstNonRepeatingCharacter {
    public static char findFirstNonRepeatingChar(String text) {
        int[] frequencies = new int[Character.MAX_VALUE + 1];
        for (int i = 0; i < text.length(); i++) {
            frequencies[text.charAt(i)]++;
        }
        for (int i = 0; i < text.length(); i++) {
            if (frequencies[text.charAt(i)] == 1) {
                return text.charAt(i);
            }
        }
        return '\0';
    }

    public static void main(String[] args) {
        String[] texts = {"swiss", "aabbcc"};
        for (String text : texts) {
            char character = findFirstNonRepeatingChar(text);
            if (character == '\0') {
                System.out.println("No Non-Repeating Character Found");
            } else {
                System.out.println("First Non-Repeating Character: '" + character + "'");
            }
        }
    }
}
