package Extended;

interface ATM {

    void depositMoney(int amount);

    void withdrawMoney(int amount);

    static void connectionStart(Account account) {
        ATMSession atmSession = new ATMSession();
    }

    static void connectionStop() {
        System.out.println("Thank you for using our ATM.");
    }
}

class Account {

}

class ATMSession implements ATM {

    public void depositMoney(int amount) {
        System.out.println("Deposited $" + amount + ".");
    }

    public void withdrawMoney(int amount) {
        System.out.println("Withdrawn $" + amount + ".");
    }

}

public class ApplicationExtended {
    public static void main(String[] args) {
        Account testAccount = new Account();
        ATM.connectionStart(testAccount, new ATMSession());
        atmSession.depositMoney(50);
        atmSession.withdrawMoney(20);
        ATM.connectionStop();
    }
}
