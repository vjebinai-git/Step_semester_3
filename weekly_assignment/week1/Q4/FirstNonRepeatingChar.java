import java.util.LinkedHashMap;
import java.util.Map;

public class FirstNonRepeatingChar {

    public static Character findFirstNonRepeatingChar(String text) {
        Map<Character, Integer> freq = new LinkedHashMap<>();
        for (char c : text.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }
        for (char c : text.toCharArray()) {
            if (freq.get(c) == 1) return c;
        }
        return null;
    }

    public static void main(String[] args) {
        String[] inputs = {"swiss", "aabbcc"};
        for (String text : inputs) {
            Character result = findFirstNonRepeatingChar(text);
            System.out.println("\"" + text + "\"");
            if (result != null) {
                System.out.println("First Non-Repeating Character: '" + result + "'");
            } else {
                System.out.println("No Non-Repeating Character Found");
            }
        }
    }
}