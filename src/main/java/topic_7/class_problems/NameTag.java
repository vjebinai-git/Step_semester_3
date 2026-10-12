package topic_7.class_problems;

public final class NameTag {
    private final String firstName;
    private final String lastName;

    public NameTag(String fullName) {
        String[] parts = fullName.split(" ", -1);

        if (parts.length != 2 ||
            parts[0].isEmpty() ||
            parts[1].isEmpty()) {
            throw new IllegalArgumentException(
                "Enter a first name and last name separated by one space."
            );
        }

        this.firstName = parts[0];
        this.lastName = parts[1];
    }

    public String getNickname() {
        return firstName + " " + lastName.charAt(0) + ".";
    }

    public static void main(String[] args) {
        NameTag tag = new NameTag("Maria Gomez");

        System.out.println(tag.getNickname());
    }
}