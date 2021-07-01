package tech.kitucode.demo.domain;

public class Account {

    private String accountNumber;

    private double unitsCount;

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getUnitsCount() {
        return unitsCount;
    }

    public void setUnitsCount(double unitsCount) {
        this.unitsCount = unitsCount;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountNumber='" + accountNumber + '\'' +
                ", unitsCount=" + unitsCount +
                '}';
    }
}
