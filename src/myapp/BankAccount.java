import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

import javax.naming.directory.InvalidAttributeValueException;

public class BankAccount {
    private String accountName;
    private String accountNumber;
    private float accountBalance;
    private ArrayList<String> transactions;
    protected boolean isClosed;
    private Date accountStartDate;
    private Date accountEndDate;

    public BankAccount() {
    }

    public BankAccount(String accountName) {
        this.accountName = accountName;
        // .GetTime returns unix timestamp (i.e. is unique),
        //     - otherwise there's a chance of duplicate account number
        // concat with random-betweem (10_000, 99,999) for added "security"
        //     - otherwise you can *almost* derive account number from accountStartDate
        this.accountNumber = "" + (new Date().getTime() / 1000) 
                                + ThreadLocalRandom.current().nextInt(10_000, 100_000);
        this.accountBalance = 0f;
        this.transactions = new ArrayList<String>();
        this.isClosed = false;
        this.accountStartDate = new Date();
        this.accountEndDate = null;
    }

    public BankAccount(String accountName, float initialBalance) {
        this(accountName);
        // This whacky times-100-divide-100 thingy is to round entered float to 2 dp
        this.accountBalance = (float) Math.floor(initialBalance * 100) / 100;
    }

    // Formats output in print statement
    @Override
    public String toString() {
        return "Account Name: " + this.accountName + "\n" +
            "Account Number: " + this.accountNumber + "\n" +
            "Account Balance: " + this.accountBalance + "\n" +
            "Transactions: " + this.transactions + "\n" +
            "Is Closed?: " + this.isClosed + "\n" +
            "Account Start Date: " + this.accountStartDate + "\n" +
            "Account End Date: " + this.accountEndDate + "\n";
    }

    public void deposit(float depositAmount) {
        if (isClosed) {
            throw new IllegalCallerException("Cannot deposit to closed account");
        }
        if (depositAmount <= 0) {
            throw new IllegalArgumentException("Deposits Amount not positive!");
        }
        // Again, the "times-100-divide-100" is to round entered float to 2 dp
        // Should probably abstract into a helper method, but not in prompt :shrug:
        this.accountBalance += Math.floor(depositAmount * 100) / 100;
        this.transactions.add("deposit %.2f at %t".formatted(depositAmount, new Date()));
    }

    public void withdraw(float withdrawalAmount) {
        if(isClosed) {
            throw new IllegalCallerException("Cannot withdraw from closed account");
        }
        if (withdrawalAmount <= 0) {
            throw new IllegalArgumentException("Withdrawal Amount not positive!");
        }
        if (withdrawalAmount > this.accountBalance) {
            throw new IllegalArgumentException("Withdrawal Amount exceeds Account Balance!");
        }
        this.accountBalance -= Math.floor(withdrawalAmount * 100) / 100;
    }

    public void closeAccount() {
        if(!isClosed){
            this.isClosed = true;
            this.accountEndDate = new Date();
        } else {
            throw new IllegalCallerException("Closed account cannot be closed again");
        }
    }

    public String getAccountName() {
        return accountName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public float getAccountBalance() {
        return accountBalance;
    }

    public ArrayList<String> getTransactions() {
        return transactions;
    }

    public boolean isClosed() {
        return isClosed;
    }

    public Date getAccountStartDate() {
        return accountStartDate;
    }

    public Date getAccountEndDate() {
        return accountEndDate;
    }

}
