package week5.assignments;

public class A3_BookCopyCirculationGuard {
    public static void main(String[] args) {
        BookInventory bookInventory = new BookInventory(3);
        bookInventory.checkOut();
        bookInventory.checkOut();
        bookInventory.checkOut();
        bookInventory.checkOut();
        System.out.println(bookInventory.getCopiesAvailable());

        bookInventory.checkIn();
        bookInventory.checkIn();
        bookInventory.checkIn();
        bookInventory.checkIn();
        System.out.println(bookInventory.getCopiesAvailable());
    }
}

class BookInventory {
    private int copiesTotal;
    private int copiesAvailable;

    BookInventory(int copiesTotal) {
        if (copiesTotal <= 0) {
            throw new IllegalArgumentException("copiesTotal must be positive");
        }
        this.copiesTotal = copiesTotal;
        this.copiesAvailable = copiesTotal;
    }

    void checkOut() {
        if (copiesAvailable > 0) {
            copiesAvailable--;
        }
    }

    void checkIn() {
        if (copiesAvailable < copiesTotal) {
            copiesAvailable++;
        }
    }

    int getCopiesAvailable() {
        return copiesAvailable;
    }
}
