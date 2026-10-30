package topic_8.assigment_problems;

import java.time.LocalDate;
import java.util.Scanner;

abstract class SubscriptionPlan {
    protected final String name;
    protected final LocalDate startDate;

    SubscriptionPlan(String name, LocalDate startDate) {
        this.name = name;
        this.startDate = startDate;
    }

    abstract int getValidityDays();

    LocalDate calculateRenewalDate() {
        return startDate.plusDays(getValidityDays());
    }
}

class BasicPlan extends SubscriptionPlan {
    BasicPlan(String name, LocalDate startDate) {
        super(name, startDate);
    }

    int getValidityDays() {
        return 30;
    }
}

class StandardPlan extends SubscriptionPlan {
    StandardPlan(String name, LocalDate startDate) {
        super(name, startDate);
    }

    int getValidityDays() {
        return 90;
    }
}

class PremiumPlan extends SubscriptionPlan {
    PremiumPlan(String name, LocalDate startDate) {
        super(name, startDate);
    }

    int getValidityDays() {
        return 365;
    }
}

public class StreamingPlanRenewalReminder {
    private static SubscriptionPlan createPlan(String type, String name, LocalDate startDate) {
        switch (type.toUpperCase()) {
            case "BASIC": return new BasicPlan(name, startDate);
            case "STANDARD": return new StandardPlan(name, startDate);
            case "PREMIUM": return new PremiumPlan(name, startDate);
            default: throw new IllegalArgumentException("Invalid plan type: " + type);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();
            LocalDate startDate = LocalDate.parse(sc.next());

            SubscriptionPlan plan = createPlan(type, name, startDate);
            System.out.println(plan.name + ": " + plan.calculateRenewalDate());
        }

        sc.close();
    }
}
