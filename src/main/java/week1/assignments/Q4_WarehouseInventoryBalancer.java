package week1.assignments;

public class Q4_WarehouseInventoryBalancer {
    public static void analyzeInventory(int[] sectionA, int[] sectionB) {
        if (sectionA.length != sectionB.length || sectionA.length == 0) {
            System.out.println("Both sections must have non-empty arrays of equal length.");
            return;
        }

        int sectionATotal = 0;
        int sectionBTotal = 0;
        int highestQuantity = sectionA[0];
        String highestSection = "A";
        int highestIndex = 0;

        for (int i = 0; i < sectionA.length; i++) {
            sectionATotal += sectionA[i];
            sectionBTotal += sectionB[i];

            if (sectionA[i] > highestQuantity) {
                highestQuantity = sectionA[i];
                highestSection = "A";
                highestIndex = i;
            }
            if (sectionB[i] > highestQuantity) {
                highestQuantity = sectionB[i];
                highestSection = "B";
                highestIndex = i;
            }
        }

        String status = sectionATotal == sectionBTotal ? "Balanced" : "Not Balanced";
        System.out.printf("Section A Total: %d | Section B Total: %d | Status: %s | Highest Quantity: %d (Section %s, Item %d)%n",
                sectionATotal, sectionBTotal, status, highestQuantity, highestSection, highestIndex + 1);
    }

    public static void main(String[] args) {
        analyzeInventory(new int[]{20, 15, 30}, new int[]{25, 10, 30});
    }
}
