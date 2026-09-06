package week4.practice_problems;

public class M3_LateFees {
    public static void main(String[] args) {
        String[] regNos = {"RA001", "RA002", "RA003", "RA004"};
        double[] totalFees = {200000, 150000, 180000, 220000};
        int[] daysLate = {10, 0, -2, 5};

        for (int i = 0; i < regNos.length; i++) {
            LateFeeAccount account = new LateFeeAccount(regNos[i], totalFees[i]);
            if (daysLate[i] > 0) {
                account.printSummary(daysLate[i]);
            } else {
                System.out.println(regNos[i] + " - On time, no late fee");
            }
        }
    }
}

class LateFeeAccount {
    String regNo;
    double totalFee;

    LateFeeAccount(String regNo, double totalFee) {
        this.regNo = regNo;
        this.totalFee = totalFee;
    }

    final double calculateLateFee(int daysLate) {
        return totalFee * 0.01 * daysLate;
    }

    final void printSummary(int daysLate) {
        System.out.println(regNo + " | Total Fee: Rs " + totalFee + " | Late Fee: Rs " + calculateLateFee(daysLate));
    }
}
