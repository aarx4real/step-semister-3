package week2.assignments;

public class Q4_LibraryIsbnNormalizerValidator {
    public static String normalizeCode(String raw) {
        String trimmedCode = raw.trim();
        if (trimmedCode.length() < 3) {
            return trimmedCode.toUpperCase();
        }
        return trimmedCode.substring(0, 3).toUpperCase() + trimmedCode.substring(3);
    }

    public static String validateAndFormat(String code) {
        if (code.length() != 13) {
            return "Invalid: code must be exactly 13 characters";
        }
        for (int i = 0; i < 3; i++) {
            if (!Character.isLetter(code.charAt(i))) {
                return "Invalid: publisher code must be 3 letters";
            }
        }
        for (int i = 3; i < code.length(); i++) {
            if (!Character.isDigit(code.charAt(i))) {
                return "Invalid: code body must contain 10 digits";
            }
        }

        StringBuilder formattedCode = new StringBuilder();
        formattedCode.append("[").append(code.substring(0, 3)).append("] ");
        formattedCode.append("YEAR: ").append(code.substring(3, 7)).append(" | ");
        formattedCode.append("CATALOG: ").append(code.substring(7));
        return formattedCode.toString();
    }

    public static void main(String[] args) {
        System.out.println(validateAndFormat(normalizeCode("  pen2026004251  ")));
        System.out.println(validateAndFormat(normalizeCode("12N2026004251")));
    }
}
