package week5.assignments;

import java.util.Arrays;

public class A5_ImmutableLoanReceiptLedger {
    public static void main(String[] args) {
        LoanReceipt receipt = new LoanReceipt("LIB-8841", new String[]{"BK-100", "BK-101"});
        String[] copiedIds = receipt.getBookIds();
        copiedIds[0] = "HACKED";
        LoanReceipt corrected = receipt.withCorrectedBookId(1, "BK-102");
        System.out.println(Arrays.toString(receipt.getBookIds()));
        System.out.println(Arrays.toString(corrected.getBookIds()));

        LoanReceipt[] receipts = {
                new ReferenceOnlyLoanReceipt("LIB-001", new String[]{"BK-200"}, "Reading Room 3"),
                null,
                new LoanReceipt("LIB-002", new String[]{"BK-201"})
        };
        System.out.println(CirculationLedger.processNightlyCirculation(receipts));
    }
}

class LoanReceipt {
    private final String memberId;
    private final String[] bookIds;

    public LoanReceipt(String memberId, String[] bookIds) {
        this.memberId = memberId;
        this.bookIds = Arrays.copyOf(bookIds, bookIds.length);
    }

    public String[] getBookIds() {
        return Arrays.copyOf(bookIds, bookIds.length);
    }

    public LoanReceipt withCorrectedBookId(int index, String newId) {
        String[] correctedIds = getBookIds();
        if (index >= 0 && index < correctedIds.length) {
            correctedIds[index] = newId;
        }
        return new LoanReceipt(memberId, correctedIds);
    }
}

class ReferenceOnlyLoanReceipt extends LoanReceipt {
    private final String roomNumber;

    public ReferenceOnlyLoanReceipt(String memberId, String[] bookIds, String roomNumber) {
        super(memberId, bookIds);
        this.roomNumber = roomNumber;
    }
}

class CirculationLedger {
    static String branchCode;

    static {
        branchCode = "PT-CENTRAL";
    }

    static String processNightlyCirculation(LoanReceipt[] receipts) {
        int processed = 0;
        int nullSkipped = 0;
        int referenceOnly = 0;
        int regular = 0;

        for (int i = 0; i < receipts.length; i++) {
            if (receipts[i] == null) {
                nullSkipped++;
            } else if (receipts[i] instanceof ReferenceOnlyLoanReceipt) {
                processed++;
                referenceOnly++;
            } else {
                processed++;
                regular++;
            }
        }
        return processed + " processed | " + nullSkipped + " null skipped | " + referenceOnly
                + " reference-only | " + regular + " regular";
    }
}
