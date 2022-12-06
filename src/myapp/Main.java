public class Main {

    public static void main(String[] args) {

        testBalanceAccountGetters();
        testFixedDepostAccountGetters();
        // Lazy to test the rest :kekw:
        // Test BA withdraw method
            // closed account exception
            // withdrawal < 0 exception
            // withdrawal == 0 exception
            // withdrawal > balance exception
            // withdrawal normal
        // test BA deposit method
            // closed account exception
            // deposit < 0 exception
            // deposit == 0 exception
            // deposit normal
        // test BA closedAccount method
            // close normal
            // close already-closed exception


    }

    private static void testBalanceAccountGetters() {
        BankAccount bankAccount = new BankAccount("Tom", 100f);

        System.out.println("-".repeat(10));
        System.out.println("Testing BankAccount Getters");
        System.out.println("-".repeat(10));
        System.out.print("accountName: %s\n".formatted(bankAccount.getAccountName()));
        System.out.print("accountNumber: %s\n".formatted(bankAccount.getAccountNumber()));
        System.out.print("accountBalance: %f\n".formatted(bankAccount.getAccountBalance()));
        System.out.print("transactions: " + bankAccount.getTransactions() + "\n");
        System.out.print("isClosed: %B\n".formatted(bankAccount.isClosed()));
        System.out.print("accountStartDate: %s\n".formatted(bankAccount.getAccountStartDate()));
        System.out.print("accountEndDate: %s\n".formatted(bankAccount.getAccountEndDate()));
        System.out.println("-".repeat(10));
    }

    private static void testFixedDepostAccountGetters() {
        FixedDepositAccount fdAccount = new FixedDepositAccount("Pete", 100.123f);

        System.out.println("Testing fdAccount Getters");
        System.out.println("-".repeat(10));
        System.out.print("accountName: %s\n".formatted(fdAccount.getAccountName()));
        System.out.print("accountNumber: %s\n".formatted(fdAccount.getAccountNumber()));
        System.out.print("accountBalance: %f\n".formatted(fdAccount.getAccountBalance()));
        System.out.print("transactions: " + fdAccount.getTransactions() + "\n");
        System.out.print("isClosed: %B\n".formatted(fdAccount.isClosed()));
        System.out.print("accountStartDate: %s\n".formatted(fdAccount.getAccountStartDate()));
        System.out.print("accountEndDate: %s\n".formatted(fdAccount.getAccountEndDate()));
        System.out.print("interest: %f\n".formatted(fdAccount.getInterest()));
        System.out.print("months: %d\n".formatted(fdAccount.getMonths()));
        System.out.print("canUpdateInterest: %B\n".formatted(fdAccount.canUpdateInterest()));
        System.out.print("canUpdateMonths: %B\n".formatted(fdAccount.canUpdateMonths()));
        System.out.println("-".repeat(10));
    }
}