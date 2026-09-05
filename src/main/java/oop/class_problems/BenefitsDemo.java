class FeeAccount {
    private String regNo;
    private double totalFee;
    private double amountPaid;

    public FeeAccount(String regNo, double totalFee) {
        this.regNo = regNo;
        this.totalFee = totalFee;
    }

    public void pay(double amount) {
        if (amount <= 0) {
            System.out.println(
                "Rejected: a payment of Rs " + amount + " makes no sense"
            );
            return;
        }

        amountPaid += amount;

        System.out.println(
            "Rs " + amount + " received for " + regNo
        );
    }

    public double getDue() {
        return totalFee - amountPaid;
    }
}

class HostelFeeAccount extends FeeAccount {

    public HostelFeeAccount(String regNo, double totalFee) {
        super(regNo, totalFee);
    }

    public void payInTwoInstallments(double amount) {
        pay(amount / 2);
        pay(amount / 2);
    }
}

public class BenefitsDemo {
    public static void main(String[] args) {

        HostelFeeAccount ravi =
            new HostelFeeAccount("RA2311003010123", 200000);

        ravi.pay(90000);

        ravi.pay(-5000);

        ravi.payInTwoInstallments(60000);

        System.out.println(
            "Still due: Rs " + ravi.getDue()
        );
    }
}