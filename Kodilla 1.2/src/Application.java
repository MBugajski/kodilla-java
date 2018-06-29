interface ATM {

    void depositMoney(int amount);

    void withdrawMoney(int amount);

    default void connectionStart() {
        System.out.println("Welcome.");
    }

    static void connectionStop() {
        System.out.println("Thank you for using our ATM.");
    }
}

class ATMImpl implements ATM {

    public void depositMoney(int amount) {
        System.out.println("Deposited $" + amount + ".");
    }

    public void withdrawMoney(int amount) {
        System.out.println("Withdrawn $" + amount + ".");
    }

}

class Application {
    public static void main(String[] args) {
        ATMImpl atm = new ATMImpl();
        atm.connectionStart();
        atm.depositMoney(50);
        atm.withdrawMoney(20);
        ATM.connectionStop();
    }
}
