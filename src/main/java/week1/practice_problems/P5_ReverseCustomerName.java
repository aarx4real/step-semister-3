package week1.practice_problems;

public class P5_ReverseCustomerName {
    public static String reverseCustomerName(String customerName) {
        char[] characters = customerName.toCharArray();
        char[] reversedCharacters = new char[characters.length];
        for (int i = 0; i < characters.length; i++) {
            reversedCharacters[i] = characters[characters.length - 1 - i];
        }
        return new String(reversedCharacters);
    }

    public static void main(String[] args) {
        String customerName = "Sunil";
        System.out.println("Original Name: " + customerName);
        System.out.println("Reversed Name: " + reverseCustomerName(customerName));
    }
}
