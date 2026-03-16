import java.util.Scanner;
import java.util.Stack;
import java.util.Deque;
import java.util.ArrayDeque;

public class UseCase13PalindromeCheckerApp {

    // Algorithm 1: Two-Pointer (String)
    public static boolean twoPointerCheck(String str) {
        int left = 0;
        int right = str.length() - 1;

        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }

    // Algorithm 2: Stack-Based
    public static boolean stackCheck(String str) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            stack.push(str.charAt(i));
        }

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != stack.pop()) return false;
        }

        return true;
    }

    // Algorithm 3: Deque-Based
    public static boolean dequeCheck(String str) {
        Deque<Character> deque = new ArrayDeque<>();

        for (int i = 0; i < str.length(); i++) {
            deque.addLast(str.charAt(i));
        }

        while (deque.size() > 1) {
            if (deque.removeFirst() != deque.removeLast()) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        // Two-Pointer timing
        long start1 = System.nanoTime();
        boolean r1 = twoPointerCheck(input);
        long end1 = System.nanoTime();

        // Stack timing
        long start2 = System.nanoTime();
        boolean r2 = stackCheck(input);
        long end2 = System.nanoTime();

        // Deque timing
        long start3 = System.nanoTime();
        boolean r3 = dequeCheck(input);
        long end3 = System.nanoTime();

        // Results
        System.out.println("\nResults:");
        System.out.println("Two-Pointer Result: " + r1 + " | Time: " + (end1 - start1) + " ns");
        System.out.println("Stack Result:       " + r2 + " | Time: " + (end2 - start2) + " ns");
        System.out.println("Deque Result:       " + r3 + " | Time: " + (end3 - start3) + " ns");

        scanner.close();
    }
}
