package week5.practice_problems;

import java.util.Arrays;

public class P5_ImmutableBookingReceiptSettlement {
    public static String processNightlySettlement(BookingReceipt[] receipts) {
        int processed = 0;
        int nullSkipped = 0;
        int group = 0;
        int individual = 0;

        for (int i = 0; i < receipts.length; i++) {
            if (receipts[i] == null) {
                nullSkipped++;
            } else if (receipts[i] instanceof GroupBookingReceipt) {
                processed++;
                group++;
            } else {
                processed++;
                individual++;
            }
        }
        return processed + " processed | " + nullSkipped + " null skipped | " + group
                + " group | " + individual + " individual";
    }

    public static void main(String[] args) {
        BookingReceipt receipt = new BookingReceipt("CH-1001", new String[]{"A1", "A2"});
        String[] copiedSeats = receipt.getSeatNumbers();
        copiedSeats[0] = "X";
        BookingReceipt updated = receipt.withUpdatedSeat(1, "A3");
        System.out.println(Arrays.toString(receipt.getSeatNumbers()));
        System.out.println(Arrays.toString(updated.getSeatNumbers()));

        BookingReceipt[] receipts = {
                new GroupBookingReceipt("CH-2002", new String[]{"B1", "B2"}, 2),
                null,
                new BookingReceipt("CH-3003", new String[]{"C1"})
        };
        System.out.println(processNightlySettlement(receipts));
    }
}

class BookingReceipt {
    private final String bookingId;
    private final String[] seatNumbers;

    public BookingReceipt(String bookingId, String[] seatNumbers) {
        this.bookingId = bookingId;
        this.seatNumbers = Arrays.copyOf(seatNumbers, seatNumbers.length);
    }

    public String[] getSeatNumbers() {
        return Arrays.copyOf(seatNumbers, seatNumbers.length);
    }

    public BookingReceipt withUpdatedSeat(int index, String newSeat) {
        String[] updatedSeats = getSeatNumbers();
        if (index >= 0 && index < updatedSeats.length) {
            updatedSeats[index] = newSeat;
        }
        return new BookingReceipt(bookingId, updatedSeats);
    }
}

class GroupBookingReceipt extends BookingReceipt {
    private final int groupSize;

    public GroupBookingReceipt(String bookingId, String[] seatNumbers, int groupSize) {
        super(bookingId, seatNumbers);
        this.groupSize = groupSize;
    }
}
