package pl.krakow.uek.pp5.creditcard.model;

public class CreditCardFacade {
    private final InMemoryCreditCardStorage storage;

    public CreditCardFacade(InMemoryCreditCardStorage storage) {
        this.storage = storage;
    }

    public void withdraw(WithdrawCommand withdrawCommand) {
        CreditCard cc = this.storage.load(withdrawCommand.getCreditCardNumber());

        cc.withdraw(withdrawCommand.getValueOf());

        storage.add(cc);
    }
}
