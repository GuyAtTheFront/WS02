public class FixedDepositAccount extends BankAccount {
    private float interest;
    private int months;
    private boolean canUpdateInterest;
    private boolean canUpdateMonths;

    public FixedDepositAccount(String name, float balance, float interest, int duration) {
        super(name, balance);
        this.interest = interest;
        this.months = duration;
        canUpdateInterest = true;
        canUpdateMonths = true;
    }

    public FixedDepositAccount(String name, float balance, float interest) {
        this(name, balance, interest, 6);
    }

    public FixedDepositAccount(String name, float balance) {
        this(name, balance, 3, 6);
    }

    @Override
    public void withdraw(float depositAmount) {
        // NOP
    }

    @Override
    public void deposit(float depositAmount) {
        // NOP
    }

    public void setInterest(int interest) {
        if (this.isClosed) {
            throw new IllegalCallerException("Cannot update interest of closed account");
        }
        if (!canUpdateInterest) {
            throw new IllegalCallerException("Cannot update interest because max changed reached (MAX = 1)");
        }
        this.interest = interest;
        this.canUpdateInterest = false;
    }

    public void setDuration(int months) {
        if (this.isClosed) {
            throw new IllegalCallerException("Cannot update duration of closed account");
        }
        if (!canUpdateInterest) {
            throw new IllegalCallerException("Cannot update duration because max changed reached (MAX = 1)");
        }
        this.months = months;
        this.canUpdateMonths = false;
    }

    public float getInterest() {
        return interest;
    }

    public int getMonths() {
        return months;
    }

    public boolean canUpdateInterest() {
        return canUpdateInterest;
    }

    public boolean canUpdateMonths() {
        return canUpdateMonths;
    }
    
}
