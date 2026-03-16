import java.util.Scanner;
import java.util.Stack;

// Service class with encapsulated palindrome logic
class PalindromeChecker {

    // Public method exposed to clients
    public boolean checkPalindrome(String input) {
        if (input == null) return false;

        // Internal data structure (Stack)
        Stack<Character> stack = new Stack<>();

        // Push characters
        for (int i = 0; i < input.length(); i++) {
            stack.push(input.charAt(i));
        }

        // Compare using pop
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) != stack.pop()) {
                return false;
            }
        }

        return true;
    }
}

// Application class (UI layer)
public class UseCase11PalindromeCheckerApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        // Use service class
        PalindromeChecker checker = new PalindromeChecker();
        boolean result = checker.checkPalindrome(input);

        // Output
        if (result) {
            System.out.println("The string is a Palindrome.");
        } else {
            System.out.println("The string is NOT a Palindrome.");
        }

        scanner.close();
    }
}
