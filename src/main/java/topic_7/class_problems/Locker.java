package topic_7.class_problems;

public class Locker {
    private String combinationCode;
    private final int lockerNumber;

    public Locker(int lockerNumber, String combinationCode) {
        this.lockerNumber = lockerNumber;
        this.combinationCode = combinationCode;
    }

    public boolean changeCode(String currentCode, String newCode) {
        if (currentCode == null ||
            !combinationCode.equals(currentCode)) {
            System.out.println("Incorrect current code.");
            return false;
        }

        if (newCode == null || newCode.isEmpty()) {
            System.out.println("Invalid new code.");
            return false;
        }

        combinationCode = newCode;
        System.out.println("Combination changed successfully.");
        return true;
    }

    public int getLockerNumber() {
        return lockerNumber;
    }

    public static void main(String[] args) {
        Locker l = new Locker(101, "1234");

        l.changeCode("1234", "5678");
        l.changeCode("0000", "9999");
    }
}