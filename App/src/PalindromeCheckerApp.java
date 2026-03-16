import java.util.Scanner;
import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;

public class UseCase6PalindromeCheckerApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input string
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        // Create Stack and Queue
        Stack<Character> stack = new Stack<>();
        Queue<Character> queue = new LinkedList<>();

        // Push to stack and enqueue to queue
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            stack.push(ch);     // LIFO
            queue.add(ch);      // FIFO (enqueue)
        }

        // Compare dequeue and pop
        boolean isPalindrome = true;
        while (!stack.isEmpty()) {
            char fromStack = stack.pop();     // pop (LIFO)
            char fromQueue = queue.remove(); // dequeue (FIFO)

            if (fromStack != fromQueue) {
                isPalindrome = false;
                break;
            }
        }

        // Display result
        if (isPalindrome) {
            System.out.println("The string is a Palindrome.");
        } else {
            System.out.println("The string is NOT a Palindrome.");
        }

        scanner.close();
    }
}
