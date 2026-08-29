package week1.assignments;

public class Q2_TypingSpeedTestAccuracyChecker {
    public static void checkTypingAccuracy(String original, String typed) {
        if (original.length() != typed.length()) {
            System.out.println("Texts must have equal length.");
            return;
        }

        int matchedCharacters = 0;
        int firstMismatch = -1;
        for (int i = 0; i < original.length(); i++) {
            if (original.charAt(i) == typed.charAt(i)) {
                matchedCharacters++;
            } else if (firstMismatch == -1) {
                firstMismatch = i;
            }
        }

        double accuracy = original.isEmpty() ? 100.0 : (matchedCharacters * 100.0) / original.length();
        System.out.printf("Matched: %d/%d | Accuracy: %.2f%%", matchedCharacters, original.length(), accuracy);
        if (firstMismatch == -1) {
            System.out.println(" | No Mismatches");
        } else {
            System.out.printf(" | First Mismatch at position %d ('%c' vs '%c')%n",
                    firstMismatch + 1, original.charAt(firstMismatch), typed.charAt(firstMismatch));
        }
    }

    public static void main(String[] args) {
        checkTypingAccuracy("hello world", "hello worlt");
        checkTypingAccuracy("coding", "coding");
    }
}
