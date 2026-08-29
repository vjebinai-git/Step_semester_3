public class PalindromeChecker {

    public static boolean isPalindromeIterative(String text) {
        int left = 0, right = text.length() - 1;
        while (left < right) {
            if (text.charAt(left) != text.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }

    public static boolean isPalindromeRecursive(String text) {
        if (text.length() <= 1) return true;
        if (text.charAt(0) != text.charAt(text.length() - 1)) return false;
        return isPalindromeRecursive(text.substring(1, text.length() - 1));
    }

    public static boolean isPalindromeArrayReversal(String text) {
        char[] chars = text.toCharArray();
        char[] reversed = new char[chars.length];
        for (int i = 0; i < chars.length; i++) {
            reversed[i] = chars[chars.length - 1 - i];
        }
        return new String(chars).equals(new String(reversed));
    }

    private static String label(boolean result) {
        return result ? "Palindrome" : "Not Palindrome";
    }

    public static void main(String[] args) {
        String[] inputs = {"madam", "hello"};
        for (String text : inputs) {
            System.out.println("\"" + text + "\"");
            System.out.println("Iterative: " + label(isPalindromeIterative(text)) +
                    " | Recursive: " + label(isPalindromeRecursive(text)) +
                    " | Array Reversal: " + label(isPalindromeArrayReversal(text)));
        }
    }
}
