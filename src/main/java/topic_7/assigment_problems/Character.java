package topic_7.assigment_problems;

public class Character {
    private int health;
    private final int maxHealth;

    public Character(int maxHealth) {
        if (maxHealth < 0) {
            throw new IllegalArgumentException(
                "Maximum health cannot be negative."
            );
        }

        this.maxHealth = maxHealth;
        this.health = maxHealth;
    }

    public void takeDamage(int amount) {
        if (amount < 0) {
            System.out.println("Invalid damage amount.");
            return;
        }

        health = Math.max(0, health - amount);
    }

    public void heal(int amount) {
        if (amount < 0) {
            System.out.println("Invalid healing amount.");
            return;
        }

        health = Math.min(maxHealth, health + amount);
    }

    public int getHealth() {
        return health;
    }

    public static void main(String[] args) {
        Character c = new Character(100);

        c.takeDamage(30);
        System.out.println("Health: " + c.getHealth());

        c.heal(50);
        System.out.println("Health: " + c.getHealth());

        c.takeDamage(150);
        System.out.println("Health: " + c.getHealth());
    }
}