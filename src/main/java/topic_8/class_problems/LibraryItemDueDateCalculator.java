import java.time.LocalDate;
import java.util.*;
import java.util.regex.*;

abstract class LibraryItem {
    protected final String title;

    LibraryItem(String title) {
        this.title = title;
    }

    abstract int getLoanPeriodDays();

    LocalDate calculateDueDate(LocalDate issueDate) {
        return issueDate.plusDays(getLoanPeriodDays());
    }
}

class BookItem extends LibraryItem {
    BookItem(String title) { super(title); }
    int getLoanPeriodDays() { return 14; }
}

class DVDItem extends LibraryItem {
    DVDItem(String title) { super(title); }
    int getLoanPeriodDays() { return 7; }
}

class MagazineItem extends LibraryItem {
    MagazineItem(String title) { super(title); }
    int getLoanPeriodDays() { return 3; }
}

public class LibraryItemDueDateCalculator {
    private static LibraryItem createItem(String type, String title) {
        switch (type.toUpperCase()) {
            case "BOOK": return new BookItem(title);
            case "DVD": return new DVDItem(title);
            case "MAGAZINE": return new MagazineItem(title);
            default: throw new IllegalArgumentException("Invalid item type: " + type);
        }
    }

    private static List<String> tokenize(String line) {
        List<String> tokens = new ArrayList<>();
        Matcher matcher = Pattern.compile("\"([^\"]*)\"|(\\S+)").matcher(line);
        while (matcher.find()) {
            tokens.add(matcher.group(1) != null ? matcher.group(1) : matcher.group(2));
        }
        return tokens;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        LocalDate currentDate = LocalDate.of(2023, 10, 26);

        for (int i = 0; i < n; i++) {
            List<String> tokens = tokenize(sc.nextLine());
            LibraryItem item = createItem(tokens.get(0), tokens.get(1));
            System.out.println(item.title + ": " + item.calculateDueDate(currentDate));
        }
        sc.close();
    }
}
