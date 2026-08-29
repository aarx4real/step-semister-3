package week1.assignments;

public class Q5_MovieReviewWordLengthProfiler {
    public static void classifyWordLengths(String review) {
        int shortWords = 0;
        int mediumWords = 0;
        int longWords = 0;

        String trimmedReview = review.trim();
        if (!trimmedReview.isEmpty()) {
            String[] words = trimmedReview.split("\\s+");
            for (String word : words) {
                int length = word.length();
                if (length <= 4) {
                    shortWords++;
                } else if (length <= 8) {
                    mediumWords++;
                } else {
                    longWords++;
                }
            }
        }

        System.out.printf("Short: %d | Medium: %d | Long: %d%n", shortWords, mediumWords, longWords);
    }

    public static void main(String[] args) {
        classifyWordLengths("This movie was absolutely fantastic and thrilling");
    }
}
