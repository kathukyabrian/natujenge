package tech.kitucode.demo.domain;

import tech.kitucode.demo.domain.enumerations.Event;

public class Request {

    private Event event;

    private String accountNumber;

    private double amount;

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Request{" +
                "event=" + event +
                ", accountNumber='" + accountNumber + '\'' +
                ", amount=" + amount +
                '}';
    }
}
