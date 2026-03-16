import java.util.Scanner;
import java.util.Stack;
import java.util.Deque;
import java.util.ArrayDeque;

// Strategy Interface
interface PalindromeStrategy {
    boolean checkPalindrome(String input);
}

// Stack-based Strategy
class StackStrategy implements PalindromeStrategy {
    public boolean checkPalindrome(String input) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < input.length(); i++) {
            stack.push(input.charAt(i));
        }

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) != stack.pop()) {
                return false;
            }
        }

        return true;
    }
}

// Deque-based Strategy
class DequeStrategy implements PalindromeStrategy {
    public boolean checkPalindrome(String input) {
        Deque<Character> deque = new ArrayDeque<>();

        for (int i = 0; i < input.length(); i++) {
            deque.addLast(input.charAt(i));
        }

        while (deque.size() > 1) {
            if (deque.removeFirst() != deque.removeLast()) {
                return false;
            }
        }

        return true;
    }
}

// Context class
class PalindromeService {
    private PalindromeStrategy strategy;

    public void setStrategy(PalindromeStrategy strategy) {
        this.strategy = strategy;
    }

    public boolean execute(String input) {
        return strategy.checkPalindrome(input);
    }
}

// Application class
public class UseCase12PalindromeCheckerApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        System.out.println("Choose Strategy:");
        System.out.println("1. Stack Strategy");
        System.out.println("2. Deque Strategy");
        System.out.print("Enter choice: ");
        int choice = scanner.nextInt();

        PalindromeService service = new PalindromeService();

        // Inject strategy at runtime
        if (choice == 1) {
            service.setStrategy(new StackStrategy());
        } else {
            service.setStrategy(new DequeStrategy());
        }

        boolean result = service.execute(input);

        if (result) {
            System.out.println("The string is a Palindrome.");
        } else {
            System.out.println("The string is NOT a Palindrome.");
        }

        scanner.close();
    }
}
