abstract class Transaction {
    abstract void insertCard();

    abstract void inputPIN();

    abstract void inputWithdrawalAmount();

    abstract void withdrawMoney();

    abstract void thankUser();

    protected void processRequest() {
        System.out.println("Processing...");
    }

    ;

    protected void checkBalance() {
        System.out.println("Autorizing request...");
    }

    ;

    protected void acceptRequest() {
        System.out.println("Request autorized.");
    }

    ;

    protected void run() {
        this.insertCard();
        this.inputPIN();
        this.inputWithdrawalAmount();
        this.processRequest();
        this.checkBalance();
        this.acceptRequest();
        this.withdrawMoney();
        this.thankUser();
    }
}

class ATMTransaction extends Transaction {

    void insertCard() {
        System.out.println("Insert card.");
    }

    void inputPIN() {
        System.out.println("Enter Your PIN");
    }

    void inputWithdrawalAmount() {
        System.out.println("Input an amount to withdraw:");
    }

    void withdrawMoney() {
        System.out.println("Please take your money.");
    }

    void thankUser() {
        System.out.println("Thank you for using this ATM.");
    }

}

public class Application {
    public static void main(String[] args) {
        ATMTransaction atmtransaction = new ATMTransaction();

        atmtransaction.run();
    }
}