package ex03;

import java.util.UUID;
public class Transaction {
    private UUID IdentifierTransaction;
    private User Recipient;
    private User Sender;
    private enum Category {
        DEBIT,
        CREDIT
    }
    private Category transferCategory;
    private Integer transferAmount;

    public Transaction(User sender, User recipient, Integer amount) {
        this.Sender = sender;
        this.Recipient = recipient;
        this.transferAmount = amount;
        this.IdentifierTransaction = UUID.randomUUID();
        if (amount < 0) {
            transferCategory = Category.CREDIT;
        } else {
            transferCategory = Category.DEBIT;
        }
        if (sender.getBalance() < 0 || sender.getBalance() < amount)
            System.err.println("Transaction failed! Insufficient funds");
        else {
            sender.setBalance(sender.getBalance() - amount);
            recipient.setBalance(recipient.getBalance() + amount);
        }
    }

    public void setRecipient(User recipient) {
        Recipient = recipient;
    }
    public void setSender(User sender) {
        Sender = sender;
    }
    public void setCategory(Category category) {
        transferCategory = category;
    }
    public void setAmount(Integer amount) {
        transferAmount = amount;
    }

    public UUID getIdentifier() {
        return IdentifierTransaction;
    }
    public User getRecipient() {
        return Recipient;
    }
    public User getSender() {
        return Sender;
    }
    public Category getCategory() {
        return transferCategory;
    }
    public Integer getAmount() {
        return transferAmount;
    }
}
