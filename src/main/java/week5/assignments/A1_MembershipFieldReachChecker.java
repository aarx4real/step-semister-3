package week5.assignments;

public class A1_MembershipFieldReachChecker {
    public static void main(String[] args) {
        String[][] attempts = {
                {"private", "SAME_CLASS"}, {"private", "SAME_PACKAGE"},
                {"default", "SAME_PACKAGE"}, {"default", "DIFFERENT_PACKAGE"},
                {"protected", "SAME_PACKAGE"}, {"protected", "SAME_CLASS"},
                {"public", "DIFFERENT_PACKAGE"}
        };
        System.out.println(AccessChecker.summarizeByModifier(attempts));
    }

    static class LibraryMember {
        private String membershipPin;
        String branchCode;
        protected double finesOwed;
        public String displayName;
    }
}

class AccessChecker {
    static String classifyAccess(String fieldModifier, String accessorContext) {
        if (fieldModifier.equals("public")) {
            return "ALLOWED";
        }
        if (fieldModifier.equals("private")) {
            return accessorContext.equals("SAME_CLASS") ? "ALLOWED" : "DENIED";
        }
        if (fieldModifier.equals("default")) {
            return (accessorContext.equals("SAME_CLASS") || accessorContext.equals("SAME_PACKAGE"))
                    ? "ALLOWED" : "DENIED";
        }
        if (fieldModifier.equals("protected")) {
            return (accessorContext.equals("SAME_CLASS") || accessorContext.equals("SAME_PACKAGE")
                    || accessorContext.equals("SUBCLASS_DIFFERENT_PACKAGE_OWN_TYPE")) ? "ALLOWED" : "DENIED";
        }
        return "DENIED";
    }

    static String summarizeByModifier(String[][] attempts) {
        String[] modifiers = {"private", "default", "protected", "public"};
        int[] allowed = new int[modifiers.length];
        int[] denied = new int[modifiers.length];

        for (int i = 0; i < attempts.length; i++) {
            for (int j = 0; j < modifiers.length; j++) {
                if (attempts[i][0].equals(modifiers[j])) {
                    if (classifyAccess(attempts[i][0], attempts[i][1]).equals("ALLOWED")) {
                        allowed[j]++;
                    } else {
                        denied[j]++;
                    }
                }
            }
        }

        StringBuilder summary = new StringBuilder();
        for (int i = 0; i < modifiers.length; i++) {
            if (i > 0) {
                summary.append(" | ");
            }
            summary.append(modifiers[i]).append(": ").append(allowed[i]).append(" allowed / ")
                    .append(denied[i]).append(" denied");
        }
        return summary.toString();
    }
}
