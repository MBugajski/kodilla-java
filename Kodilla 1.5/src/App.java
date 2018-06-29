interface Employee {

    double calculateSalary();

}

class FixedSalaryEmployee implements Employee {

    private double salary;

    public FixedSalaryEmployee(double salary) {
        this.salary = salary;
    }

    public double calculateSalary() {
        return this.salary;
    }

}

class HourlySalaryEmployee implements Employee {

    private double hours;
    private double hourlyPay;

    public HourlySalaryEmployee(double hours, double hourlyPay) {
        this.hours = hours;
        this.hourlyPay = hourlyPay;
    }

    public double calculateSalary() {
        return this.hourlyPay * this.hours;
    }

}


class SweatshopEmployee implements Employee {
    private int itemsProduced;
    private double payPerItem;

    public SweatshopEmployee(int itemsProduced, double payPerItem) {
        this.itemsProduced = itemsProduced;
        this.payPerItem = payPerItem;
    }

    public double calculateSalary() {
        return this.itemsProduced * this.payPerItem;
    }
}

class BoutiqueEmployee implements Employee {
    private double basicSalary;
    private boolean bonus;

    public BoutiqueEmployee(double basicSalary, boolean bonus) {
        this.basicSalary = basicSalary;
        this.bonus = bonus;
    }

    public double calculateSalary() {
        if (this.bonus) {
            return this.basicSalary * 1.2;
        } else {
            return this.basicSalary;
        }
    }
}

// Payout 
abstract class SalaryPayout {

    private Employee employee;

    public SalaryPayout(Employee employee) {
        this.employee = employee;
    }

    protected abstract void payout();

    public void processPayout() {
        System.out.println("Creating payout for: " + this.employee.calculateSalary() + " PLN");
        this.payout();
        System.out.println("Payout has been completed!");
        System.out.println();
    }

}

class SalaryPayoutProcessor extends SalaryPayout {

    public SalaryPayoutProcessor(Employee employee) {
        super(employee);
    }

    protected void payout() {
        System.out.println("Sending money to employee");
    }

}

class App {

    public static void main(String args[]) {

        FixedSalaryEmployee employee = new FixedSalaryEmployee(2000);
        HourlySalaryEmployee employee1 = new HourlySalaryEmployee(40, 19);

        SalaryPayoutProcessor processor = new SalaryPayoutProcessor(employee);
        SalaryPayoutProcessor processor1 = new SalaryPayoutProcessor(employee1);
        SalaryPayoutProcessor processor2 = new SalaryPayoutProcessor(new SweatshopEmployee(200, 5));
        SalaryPayoutProcessor processor3 = new SalaryPayoutProcessor(new BoutiqueEmployee(2000, true));
        processor.processPayout();
        processor1.processPayout();
        processor2.processPayout();
        processor3.processPayout();

    }

}