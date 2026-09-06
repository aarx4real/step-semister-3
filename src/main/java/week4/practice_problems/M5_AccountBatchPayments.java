package week4.practice_problems;

public class M5_AccountBatchPayments {
    static int hostelAccountsProcessed;
    static int dayScholarAccountsProcessed;

    public static void processPayment(FeeAccount account, double amount) {
        if (account instanceof HostelFeeAccount) {
            HostelFeeAccount hostelAccount = (HostelFeeAccount) account;
            hostelAccount.pay(amount);
            hostelAccountsProcessed++;
        } else {
            account.pay(amount);
            dayScholarAccountsProcessed++;
        }
    }

    public static void main(String[] args) {
        FeeAccount[] accounts = {
                new HostelFeeAccount(), new HostelFeeAccount(), new FeeAccount(), new FeeAccount()
        };

        for (int i = 0; i < accounts.length; i++) {
            processPayment(accounts[i], 60000);
        }
        System.out.println("Hostel accounts processed: " + hostelAccountsProcessed
                + " | Day-scholar accounts processed: " + dayScholarAccountsProcessed);
    }
}

class FeeAccount {
    void pay(double amount) {
        System.out.println("Paid in one go (day-scholar account)");
    }
}

class HostelFeeAccount extends FeeAccount {
    @Override
    void pay(double amount) {
        System.out.println("Paid in two installments (hostel account)");
    }
}
