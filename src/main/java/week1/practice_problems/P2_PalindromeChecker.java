package week1.practice_problems;

public class P2_PalindromeChecker {
    public static boolean isPalindromeIterative(String text) {
        for (int left = 0, right = text.length() - 1; left < right; left++, right--) {
            if (text.charAt(left) != text.charAt(right)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isPalindromeRecursive(String text) {
        if (text.length() <= 1) {
            return true;
        }
        return text.charAt(0) == text.charAt(text.length() - 1)
                && isPalindromeRecursive(text.substring(1, text.length() - 1));
    }

    public static boolean isPalindromeArrayReversal(String text) {
        char[] characters = text.toCharArray();
        for (int left = 0, right = characters.length - 1; left < right; left++, right--) {
            char temporary = characters[left];
            characters[left] = characters[right];
            characters[right] = temporary;
        }
        return text.equals(new String(characters));
    }

    private static String result(boolean palindrome) {
        return palindrome ? "Palindrome" : "Not Palindrome";
    }

    public static void main(String[] args) {
        String[] texts = {"madam", "hello"};
        for (String text : texts) {
            System.out.printf("%s -> Iterative: %s | Recursive: %s | Array Reversal: %s%n", text,
                    result(isPalindromeIterative(text)), result(isPalindromeRecursive(text)),
                    result(isPalindromeArrayReversal(text)));
        }
    }
}
